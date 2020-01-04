package com.payoda.kotlindemo.network

import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET

interface UserApi {

    @GET
    fun getUser(): Deferred<Response<UserResponse>>
}