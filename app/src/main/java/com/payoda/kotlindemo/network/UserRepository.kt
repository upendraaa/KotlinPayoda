package com.payoda.kotlindemo.network

import com.payoda.kotlindemo.database.User

class MovieRepository(private val api: UserApi) : BaseRepository() {

    suspend fun getUser(): MutableList<User>? {

        val userResponse = safeApiCall(
            call = { api.getUser().await() },
            errorMessage = "Error while fetching the users!"
        )

        return userResponse?.results!!.toMutableList();

    }

}