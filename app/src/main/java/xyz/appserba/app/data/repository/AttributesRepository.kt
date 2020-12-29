package xyz.appserba.app.data.repository

import retrofit2.await
import xyz.appserba.app.data.model.ActionState
import xyz.appserba.app.data.model.Attributes
import xyz.appserba.app.data.model.AttributesList
import xyz.appserba.app.data.remote.AttributesService
import xyz.appserba.app.data.remote.RetrofitApi
import java.lang.Exception

class AttributesRepository {
    private val newsService: AttributesService by lazy { RetrofitApi.newsService() }

    suspend fun listNews(): ActionState<List<Attributes>> {
        return try {
            val list = newsService.listNews().await()
            ActionState(list.attributes)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

}