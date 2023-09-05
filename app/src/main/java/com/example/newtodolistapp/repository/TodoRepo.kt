package com.example.newtodolistapp.repository

import androidx.lifecycle.LiveData
import com.example.newtodolistapp.dao.TodoDao
import com.example.newtodolistapp.model.Todo

class TodoRepo(private val todoDao: TodoDao) {
    fun getTodo(): LiveData<List<Todo>> {
        return todoDao.getTodo()
    }

    suspend fun insertTodo(todo: Todo) {
        return todoDao.insertTodo(todo)
    }

    suspend fun updateTodo(todo: Todo) {
        return todoDao.updateTodo(todo)
    }

    suspend fun deleteTodo(id: Long) {
        return todoDao.deleteTodo(id)
    }

}