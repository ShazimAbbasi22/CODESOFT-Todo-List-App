package com.example.newtodolistapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.newtodolistapp.R
import com.example.newtodolistapp.databinding.TodoItemBinding
import com.example.newtodolistapp.model.Todo
import com.example.newtodolistapp.ui.fragments.HomeFragmentDirections

class TodoAdapter(val requireContext: Context, val todos: List<Todo>) :
    RecyclerView.Adapter<TodoAdapter.TodoViewHolder>() {

    class TodoViewHolder(val binding: TodoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        return TodoViewHolder(
            TodoItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = todos.size

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val data = todos[position]
        holder.binding.ItemTitle.text = data.title
        holder.binding.ItemDescription.text = data.description
        holder.binding.ItemDate.text = data.date

        when(data.priority) {
            1 -> holder.binding.PriorityIndicator.setBackgroundResource(R.drawable.green_indicator)
            2 -> holder.binding.PriorityIndicator.setBackgroundResource(R.drawable.yellow_indicator)
            3 -> holder.binding.PriorityIndicator.setBackgroundResource(R.drawable.red_indicator)
        }

        holder.binding.root.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(data)
            Navigation.findNavController(it).navigate(action)
        }
    }

}