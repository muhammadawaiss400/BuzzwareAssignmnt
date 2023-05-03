package com.assignment.buzzware.model

import com.assignment.buzzware.model.UserDetail

data class ReturnData(
    val freelancer_detail: Any,
    val freelancer_price: List<Any>,
    val user_detail: UserDetail
)