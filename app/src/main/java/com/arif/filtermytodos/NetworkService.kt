package com.arif.filtermytodos

import com.arif.filtermytodos.models.Todos
import com.arif.filtermytodos.models.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

const val baseURL = "https://jsonplaceholder.typicode.com/"


val retrofit = Retrofit.Builder()
    .baseUrl(baseURL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface TodosApiService {
    @GET("todos")
    suspend fun getTodosList(@Query("userId") userId: Int): Todos

    @GET
    suspend fun getUsersList(@Url endUrl: String): User
}

object UserTodoService{
    val todosApiService: TodosApiService by lazy {
        retrofit.create(TodosApiService::class.java)
    }
}