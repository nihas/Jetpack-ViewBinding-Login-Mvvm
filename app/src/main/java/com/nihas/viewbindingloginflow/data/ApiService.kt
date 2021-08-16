package com.nihas.viewbindingloginflow.data

import com.nihas.viewbindingloginflow.data.model.LoginRequest
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("https://api.publicapis.org/entries")
    suspend fun doLogin(): Response<LoginRequest>
}
