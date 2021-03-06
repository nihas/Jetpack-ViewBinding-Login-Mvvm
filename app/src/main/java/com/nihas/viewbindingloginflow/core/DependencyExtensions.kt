package com.nihas.viewbindingloginflow.core

import android.app.Application
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
/**
 * Kotlin extensions for dependency injection
 */

inline fun <reified T : ViewModel> FragmentActivity.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory).get(T::class.java)
}

inline fun <reified T : ViewModel> Fragment.injectViewModel(factory: ViewModelProvider.Factory): T {
    return ViewModelProvider(this, factory).get(T::class.java)
}

//fun FragmentActivity.injectViewModelFactory(application: Application): ViewModelFactory {
//    return ViewModelFactory(application)
//}
fun injectViewModelFactory(application: Application): ViewModelFactory {
    return ViewModelFactory(application)
}
