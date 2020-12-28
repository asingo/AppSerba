package xyz.appserba.app.data.remote

import retrofit2.Call
import retrofit2.http.GET
import xyz.appserba.app.data.model.NewsList

interface NewsService {
    @GET("/indonesia/provinsi")
    fun listNews(): Call<NewsList>


}