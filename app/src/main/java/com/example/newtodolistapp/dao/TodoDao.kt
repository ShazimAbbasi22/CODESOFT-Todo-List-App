package com.example.newtodolistapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.newtodolistapp.model.Todo

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTodo(todo: Todo)

    @Update
    suspend fun updateTodo(todo: Todo)

    @Query("DELETE FROM TodoList WHERE id=:id")
    suspend fun deleteTodo(id: Long)

    @Query("SELECT * FROM TodoList")
    fun getTodo(): LiveData<List<Todo>>
}