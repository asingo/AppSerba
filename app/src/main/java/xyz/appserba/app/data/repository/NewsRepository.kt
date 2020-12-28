package xyz.appserba.app.data.repository

import retrofit2.await
import xyz.appserba.app.data.model.ActionState
import xyz.appserba.app.data.model.News
import xyz.appserba.app.data.remote.NewsService
import xyz.appserba.app.data.remote.RetrofitApi
import java.lang.Exception

class NewsRepository {
    private val newsService: NewsService by lazy { RetrofitApi.newsService() }

    suspend fun listNews(): ActionState<News> {
        return try {
            val list = newsService.listNews().await()
            ActionState(list.attributes)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

}