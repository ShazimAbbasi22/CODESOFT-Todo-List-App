package com.example.newtodolistapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey

@kotlinx.parcelize.Parcelize
@Entity(tableName = "TodoList")
data class Todo(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var title: String,
    var description: String?,
    var date: String,
    var priority: Int
) : Parcelable
