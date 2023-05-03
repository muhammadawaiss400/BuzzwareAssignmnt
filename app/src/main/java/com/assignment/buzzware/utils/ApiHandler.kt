package com.assignment.buzzware.utils
import com.assignment.buzzware.model.ApiStates
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Response

fun <T> result(call:suspend ()-> Response<T>): Flow<ApiStates<T?>> = flow {
    emit(ApiStates.Loading)
    try {
        val c = call()
        c.let {
            if (c.isSuccessful) {
                emit(ApiStates.Success(it.body()))
            } else {
                c.errorBody().let {erroe->
                    erroe?.close()
                    emit(ApiStates.Failure(erroe.toString()))
                }
            }
        }
    }
    catch (t:Throwable){
        emit(ApiStates.Failure(t.message.toString()))
    }
}.flowOn(Dispatchers.IO)