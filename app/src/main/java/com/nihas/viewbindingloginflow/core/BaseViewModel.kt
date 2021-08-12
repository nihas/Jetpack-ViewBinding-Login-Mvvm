package com.nihas.viewbindingloginflow.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.nihas.viewbindingloginflow.data.MainDataSource
import com.nihas.viewbindingloginflow.data.MainRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers

open class BaseViewModel(application: Application): AndroidViewModel(application) {

//    lateinit var preferencesHelper: AppPreferencesHelper

    val showLoading = MutableLiveData<Boolean>()
    val errMessage = MutableLiveData<String>()

    var ioCoroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    var mainDataSource = MainDataSource()
    val mainRepository = MainRepository(mainDataSource)
}
