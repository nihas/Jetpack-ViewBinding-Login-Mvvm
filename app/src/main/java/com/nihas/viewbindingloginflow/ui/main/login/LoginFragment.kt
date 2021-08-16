package com.nihas.viewbindingloginflow.ui.main.login

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.nihas.viewbindingloginflow.core.BaseFragment
import com.nihas.viewbindingloginflow.core.injectViewModel
import com.nihas.viewbindingloginflow.core.injectViewModelFactory
import com.nihas.viewbindingloginflow.databinding.ViewLoginBinding
import com.nihas.viewbindingloginflow.ui.main.MainActivity
import com.nihas.viewbindingloginflow.ui.main.MainViewModel

class LoginFragment: BaseFragment<ViewLoginBinding>(ViewLoginBinding::inflate) {

    override fun setUpViews() {
        super.setUpViews()

        binding.signinButton.setOnClickListener {
            binding.signinButton.visibility = View.INVISIBLE
            binding.signinButton.isEnabled = false
            viewModel.doLogin()
        }

        viewModel.login.observe(this,{
            binding.signinButton.isEnabled = true
            binding.signinButton.visibility = View.VISIBLE
            if(it!=null){
                showSnackBar("SUCCESS")
                (activity as MainActivity).replaceFragment(MainFragment())
            }
        })

        viewModel.errMessage.observe(this,{
            binding.signinButton.isEnabled = true
            if(it!=null){
                showSnackBar(it)
            }
        })

    }
}