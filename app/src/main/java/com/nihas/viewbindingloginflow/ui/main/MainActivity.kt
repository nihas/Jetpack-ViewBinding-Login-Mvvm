package com.nihas.viewbindingloginflow.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.nihas.viewbindingloginflow.R
import com.nihas.viewbindingloginflow.core.BaseActivity
import com.nihas.viewbindingloginflow.core.injectViewModel
import com.nihas.viewbindingloginflow.core.injectViewModelFactory
import com.nihas.viewbindingloginflow.databinding.ActivityMainBinding
import com.nihas.viewbindingloginflow.ui.main.login.LoginFragment

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    override fun setUpViews() {
        super.setUpViews()

        replaceFragment(LoginFragment())

    }

    fun replaceFragment(fragment: Fragment, backstackName: String? = null) {
        replaceFragmentBase(binding.containerView.id, fragment, fragment.javaClass.simpleName,backstackName)
    }

    fun addFragment(fragment: Fragment, backstackName: String? = null){
        addFragmentBase(binding.containerView.id, fragment, fragment.javaClass.simpleName,backstackName)
    }

}