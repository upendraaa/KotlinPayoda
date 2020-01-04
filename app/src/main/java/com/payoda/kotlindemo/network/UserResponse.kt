package com.payoda.kotlindemo.network

import com.payoda.kotlindemo.database.User

data class UserResponse(
    val results: List<User>
)