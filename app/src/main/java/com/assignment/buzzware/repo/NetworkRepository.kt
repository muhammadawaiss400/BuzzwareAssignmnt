package com.assignment.buzzware.repo

import com.assignment.buzzware.network.ApiService
import com.assignment.buzzware.model.LoginResponse
import com.assignment.buzzware.utils.result
import retrofit2.Response
import javax.inject.Inject

class NetworkRepository @Inject constructor(val apiService: ApiService) {
    suspend fun loginUser(name:String,password:String):Response<LoginResponse>{
       return apiService.LoginUser(name,password)
    }
}