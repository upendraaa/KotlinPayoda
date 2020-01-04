package com.payoda.kotlindemo.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey var userId: String,
    @ColumnInfo(name = "first_name") var firstName: String,
    @ColumnInfo(name = "last_name") var lastName: String,
    @ColumnInfo(name = "mobile_number") var mobileNumber: String,
    @ColumnInfo(name = "email_id") var emailId: String
) {

}