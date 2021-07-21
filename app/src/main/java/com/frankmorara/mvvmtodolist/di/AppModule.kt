package com.frankmorara.mvvmtodolist.di

import android.app.Application
import androidx.room.CoroutinesRoom
import androidx.room.Room
import com.frankmorara.mvvmtodolist.db.TaskDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
//Tells Room the context of our module
object AppModule {
    @Provides
    @Singleton
// Tells Room to create a single instance of TaskDatabase
    fun providesDatabase(
        app: Application,
         callback: TaskDatabase.Callback) =//        Creates one instance of database class
        Room.databaseBuilder(app, TaskDatabase::class.java, "task_database")
            .fallbackToDestructiveMigration()
            .addCallback(callback)
            .build() 


    @Provides
    fun provideTaskDao(db: TaskDatabase) = db.taskDao()

    @ApplicationScope
    @Provides
    @Singleton
    fun provideApplicationScope() = CoroutineScope(SupervisorJob())
}
@Retention(AnnotationRetention.RUNTIME)
@Qualifier
annotation class ApplicationScope