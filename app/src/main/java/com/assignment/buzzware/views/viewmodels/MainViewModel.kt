package com.assignment.buzzware.views.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assignment.buzzware.repo.NetworkRepository
import com.assignment.buzzware.model.ApiStates
import com.assignment.buzzware.model.LoginResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(val repository: NetworkRepository) : ViewModel() {
    var loginState = MutableStateFlow<ApiStates<LoginResponse?>>(ApiStates.Loading)

    fun loginUser(name: String, pass: String) {
        viewModelScope.launch {
            loginState.value = ApiStates.Loading
            try {
                val response = repository.loginUser(name, pass)
                loginState.value = ApiStates.Success(response.body())
            } catch (e: Exception) {
                loginState.value = ApiStates.Failure(e.message.toString())
            }
        }
    }
}