package com.nihas.viewbindingloginflow.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.nihas.viewbindingloginflow.ui.main.MainViewModel

abstract class BaseFragment<DB : ViewBinding>(private val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> DB): Fragment() {
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: MainViewModel

    lateinit var binding: DB

    open fun setUpViews() {}
    open fun onInject() {}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)
        container?.let { init(inflater, it) }
        return binding.root
    }

    fun init(inflater: LayoutInflater, container: ViewGroup) {
        binding = bindingFactory.invoke(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModelFactory = injectViewModelFactory(activity?.application!!)
        viewModel = injectViewModel(viewModelFactory)
        onInject()
        setUpViews()

    }

}