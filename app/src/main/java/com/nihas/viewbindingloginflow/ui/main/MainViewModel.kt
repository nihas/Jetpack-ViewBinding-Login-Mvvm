package com.nihas.viewbindingloginflow.ui.main

import android.app.Application
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nihas.viewbindingloginflow.data.model.LoginRequest
import com.nihas.viewbindingloginflow.core.BaseViewModel
import com.nihas.viewbindingloginflow.core.Result

class MainViewModel(application: Application): BaseViewModel(application) {
    private val _login = MutableLiveData<LoginRequest>()
    val login: LiveData<LoginRequest> = _login

    fun doLogin(){
        var loginRequest = LoginRequest("email","password")
        mainRepository.observeLogin(loginRequest,ioCoroutineScope) {result ->
            showLoading.postValue(false)
            when (result.status) {
                Result.Status.SUCCESS -> {
                    _login.postValue(result.data)
                }
                Result.Status.LOADING -> View.VISIBLE
                Result.Status.ERROR -> {
                    errMessage.postValue(result.message)
                    _login.postValue(result.data)
                }
            }
        }
    }
}