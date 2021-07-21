package com.frankmorara.mvvmtodolist.ui.tasks

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.frankmorara.mvvmtodolist.db.TaskDao

class TasksViewModel @ViewModelInject constructor(
    private val taskDao: TaskDao
): ViewModel(){
    val tasks = taskDao.getTask().asLiveData()
}