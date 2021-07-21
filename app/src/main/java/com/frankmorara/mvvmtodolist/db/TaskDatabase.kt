package com.frankmorara.mvvmtodolist.db

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(version = 1, exportSchema = false, entities = [Task::class])
abstract class TaskDatabase : RoomDatabase(){

    abstract fun taskDao(): TaskDao
}