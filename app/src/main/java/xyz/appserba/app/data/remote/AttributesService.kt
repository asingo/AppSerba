package xyz.appserba.app.data.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import xyz.appserba.app.data.model.Attributes
import xyz.appserba.app.data.model.AttributesList

interface AttributesService {
    @GET("/indonesia/provinsi")
    fun listNews(): Call<List<AttributesList>>


}