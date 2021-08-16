package com.nihas.viewbindingloginflow.data

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.nihas.viewbindingloginflow.data.model.LoginRequest
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import okhttp3.ResponseBody
import com.nihas.viewbindingloginflow.core.Result

class MainRepository(val remoteSource: MainDataSource) {

    fun observeLogin(
        loginRequest: LoginRequest,
        ioCoroutineScope: CoroutineScope,
        callback: (Result<LoginRequest>) -> Unit
    ) {
        ioCoroutineScope.launch(getJobErrorHandler()) {
            val response = remoteSource.doLogin(loginRequest)
            callback(response)
        }
    }


    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        postError(e.message ?: e.toString())
    }

    private fun postError(message: String) {
        Log.e("TAG","An error happened: $message")
    }
}