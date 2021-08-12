package com.nihas.viewbindingloginflow.ui.main

import android.app.Application
import com.intellicar.mytestgps.data.model.LoginRequest
import com.nihas.viewbindingloginflow.core.BaseViewModel

class MainViewModel(application: Application): BaseViewModel(application) {

    fun getLogin(){
        var loginRequest = LoginRequest("email","password")
        mainRepository.observeLogin(loginRequest,ioCoroutineScope) {

        }
    }
}