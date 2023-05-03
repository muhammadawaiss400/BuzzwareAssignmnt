package com.assignment.buzzware.network

import com.assignment.buzzware.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface ApiService {
companion object{
    const val BASE_URL="https://houseservice.app/backend/Houseservice/api"
}
    @POST("/login")
    @FormUrlEncoded
    suspend fun LoginUser(@Field("user_email") user_email:String,
    @Field("user_password")user_password:String):Response<LoginResponse>
}