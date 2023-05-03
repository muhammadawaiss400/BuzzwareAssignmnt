package com.assignment.buzzware.model

sealed class ApiStates<out T> {
    data class Success<out T>(val data: T?) : ApiStates<T>()
    data class Failure(val msg: String) : ApiStates<Nothing>()
    object Loading : ApiStates<Nothing>()
 }
