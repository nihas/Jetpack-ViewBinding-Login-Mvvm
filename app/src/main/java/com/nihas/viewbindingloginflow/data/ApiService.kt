package com.nihas.viewbindingloginflow.data

import com.intellicar.mytestgps.data.model.LoginRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("lego/sets/")
    suspend fun doLogin(@Body id: LoginRequest): Response<ResponseBody>
}
