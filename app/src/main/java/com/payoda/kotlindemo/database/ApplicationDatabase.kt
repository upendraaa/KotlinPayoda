package com.payoda.kotlindemo.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(User::class), version = 1)
abstract class ApplicationDatabase : RoomDatabase() {

    abstract fun UserDao(): UserDao;

    companion object {

        @Volatile
        private var instance: ApplicationDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(
            context,
            ApplicationDatabase::class.java, "kotlin_demo.db"
        )
            .build()
    }


}