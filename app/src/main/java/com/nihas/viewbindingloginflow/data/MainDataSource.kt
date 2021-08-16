package com.nihas.viewbindingloginflow.data

import com.nihas.viewbindingloginflow.data.model.LoginRequest
import com.nihas.viewbindingloginflow.core.BaseDataSource


class MainDataSource() : BaseDataSource() {

    suspend fun doLogin(loginRequest: LoginRequest) = getResult { service.doLogin() }

}