package com.arif.filtermytodos.repository

import com.arif.filtermytodos.UserTodoService
import com.arif.filtermytodos.models.Todos
import com.arif.filtermytodos.models.User

class TodosFilterRepository {
    suspend fun fetchUserData(): User {
        val endUrl = "users"
        return UserTodoService.todosApiService.getUsersList(endUrl)
    }

    suspend fun fetchTodoData(userId:Int): Todos {
       // val endUrl = "todos"
        return UserTodoService.todosApiService.getTodosList(userId)
    }
}