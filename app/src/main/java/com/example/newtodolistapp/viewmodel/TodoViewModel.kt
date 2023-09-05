package com.example.newtodolistapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.newtodolistapp.database.TodoDatabase
import com.example.newtodolistapp.model.Todo
import com.example.newtodolistapp.repository.TodoRepo
import kotlinx.coroutines.launch

class TodoViewModel(application: Application): AndroidViewModel(application) {

    private val repository: TodoRepo

    init {
        val database = TodoDatabase.getDatabase(application).todoDao()
        repository = TodoRepo(database)
    }

     fun getTodo(): LiveData<List<Todo>> {
        return repository.getTodo()
    }

    fun insertTodo(todo: Todo) {
        viewModelScope.launch {
            repository.insertTodo(todo)
        }
    }

     fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            repository.updateTodo(todo)
        }
    }

    fun deleteTodo(id: Long) {
        viewModelScope.launch {
            repository.deleteTodo(id)
        }
    }

}