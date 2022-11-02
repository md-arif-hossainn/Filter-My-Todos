package com.arif.filtermytodos.models
import com.google.gson.annotations.SerializedName


class Todos : ArrayList<Todos.TodosItem>(){
    data class TodosItem(
        @SerializedName("completed")
        val completed: Boolean,
        @SerializedName("id")
        val id: Int,
        @SerializedName("title")
        val title: String,
        @SerializedName("userId")
        val userId: Int
    )
}