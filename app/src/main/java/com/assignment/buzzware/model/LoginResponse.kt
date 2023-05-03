package com.assignment.buzzware.model

data class LoginResponse(
    val msg: String,
    val return_data: ReturnData,
    val sucess: Int
)