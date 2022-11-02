package com.arif.filtermytodos.view_model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arif.filtermytodos.models.Todos
import com.arif.filtermytodos.models.User
import com.arif.filtermytodos.repository.TodosFilterRepository
import kotlinx.coroutines.launch

class TodosFilterViewModel:ViewModel() {
    val repository = TodosFilterRepository()
    val userLiveData: MutableLiveData<User> = MutableLiveData()
    val todoLiveData: MutableLiveData<Todos> = MutableLiveData()

    fun fetchData() {
        viewModelScope.launch {
            try {
                userLiveData.value = repository.fetchUserData()
            }catch (e: Exception) {
                Log.d("TodosFilterViewModel", e.localizedMessage)
            }
        }
    }

    fun fetch(userId:Int) {
        viewModelScope.launch {
            try {
                todoLiveData.value = repository.fetchTodoData(userId)
            }catch (e: Exception) {
                Log.d("TodosFilterViewModel", e.localizedMessage)
            }
        }
    }


}