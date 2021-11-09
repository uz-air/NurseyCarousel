package com.ankur.nursery

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("https://mocki.io/v1/3f78bb33-bede-4ab1-8033-e174ba8bf997")
    fun getPlants(): Call<ApiResponse>
}