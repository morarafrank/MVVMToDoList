package com.frankmorara.mvvmtodolist.db

import androidx.room.Dao

@Dao
interface TaskDao {

    suspend fun insert(task: Task)

}