package xyz.appserba.app.ui.news

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import xyz.appserba.app.data.model.ActionState
import xyz.appserba.app.data.model.Attributes
import xyz.appserba.app.data.repository.AttributesRepository

class NewsViewModel : ViewModel() {
    private val repo: AttributesRepository by lazy { AttributesRepository() }

    val loading = MutableLiveData(false)
    val actionState = MutableLiveData<ActionState<*>>()

    val listResp = MutableLiveData<List<Attributes>>()

    val url = MutableLiveData("")

    fun listNews() {
        viewModelScope.launch {
            loading.value = true
            val resp = repo.listNews()
            actionState.value = resp
            listResp.value = resp.data
            loading.value = false
        }
    }


}