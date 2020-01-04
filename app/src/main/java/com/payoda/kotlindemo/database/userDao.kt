package com.payoda.kotlindemo.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("select * from user")
    fun getAllUsers(): List<User>

    @Query("Select * from user where userId Like :userId")
    fun getUserById(userId: String): List<User>

    @Insert
    fun insertAllUsers(vararg users: User)

    @Delete
    fun deleteUser(user: User)


}