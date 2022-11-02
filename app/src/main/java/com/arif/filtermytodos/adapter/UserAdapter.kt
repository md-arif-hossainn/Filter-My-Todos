package com.arif.filtermytodos.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.arif.filtermytodos.databinding.TodoDesignLayoutBinding
import com.arif.filtermytodos.models.Todos

class UserAdapter():ListAdapter<Todos.TodosItem,UserAdapter.UserViewHolder>(UserDiffutil()) {
    class UserViewHolder(val binding:TodoDesignLayoutBinding):
            RecyclerView.ViewHolder(binding.root){
        fun bind(item: Todos.TodosItem){
            binding.item = item
        }

            }
    class UserDiffutil:DiffUtil.ItemCallback<Todos.TodosItem>(){
        override fun areItemsTheSame(oldItem: Todos.TodosItem, newItem: Todos.TodosItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: Todos.TodosItem,
            newItem: Todos.TodosItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = TodoDesignLayoutBinding.inflate(
            LayoutInflater.from(parent.context),parent,false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val todo = getItem(position)
        holder.bind(todo)
    }
}

