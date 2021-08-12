package com.nihas.viewbindingloginflow.core

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.nihas.viewbindingloginflow.core.feedback.ApplicationToaster
import com.nihas.viewbindingloginflow.ui.main.MainViewModel


abstract class BaseActivity<DB : ViewBinding>(val bindingFactory: (LayoutInflater) -> DB): AppCompatActivity() {

    val binding: DB by lazy {
        bindingFactory(layoutInflater)
    }

    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    protected lateinit var toaster: ApplicationToaster

    open fun setUpViews() {}
    open fun onInject() {}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        viewModelFactory = injectViewModelFactory(application)
        viewModel = injectViewModel(viewModelFactory)
        onInject()
        setUpViews()
        toaster = ApplicationToaster(this@BaseActivity)
    }

    fun addFragmentBase(@IdRes containerViewId: Int,
                         fragment: Fragment,
                         fragmentTag: String,
                         @Nullable backStackStateName: String?) {

        var fragmentTransaction = supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .add(containerViewId, fragment, fragmentTag)
        if(backStackStateName==null){
            fragmentTransaction.disallowAddToBackStack()
                    .commit()
        }else{
            fragmentTransaction.addToBackStack(backStackStateName)
                    .commit()
        }
    }

    protected fun replaceFragmentBase(@IdRes containerViewId: Int,
                                       fragment: Fragment,
                                       fragmentTag: String,
                                       @Nullable backStackStateName: String?) {
        var fragmentTransaction = supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
                .replace(containerViewId, fragment, fragmentTag)
        if(backStackStateName==null){
            fragmentTransaction.disallowAddToBackStack()
                    .commit()
        }else{
            fragmentTransaction.addToBackStack(backStackStateName)
                    .commit()
        }
    }

    fun showSnackBar(msg: String) {
        val snackbar = Snackbar
                .make(findViewById(android.R.id.content), msg, Snackbar.LENGTH_LONG)
//                        .setAction("RETRY") { }
        snackbar.show()
    }
}