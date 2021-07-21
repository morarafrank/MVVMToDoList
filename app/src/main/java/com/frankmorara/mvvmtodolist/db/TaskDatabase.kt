package com.frankmorara.mvvmtodolist.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.frankmorara.mvvmtodolist.di.ApplicationScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

@Database(version = 1, exportSchema = false, entities = [Task::class])
abstract class TaskDatabase : RoomDatabase(){

    abstract fun taskDao(): TaskDao

//    Tells Dagger to create an instance of this database and pass in the necessary dependencies
    class Callback @Inject constructor(
    private val database: Provider<TaskDatabase>,
    @ApplicationScope private val applicationScope: CoroutineScope
    ) : RoomDatabase.Callback(){
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)

            val dao = database.get().taskDao()

            applicationScope.launch {
                dao.insert(Task("Wash the Dishes"))
                dao.insert(Task("Call Mom", important = true))
                dao.insert(Task("Do the laundry"))
                dao.insert(Task("Buy Groceries"))
                dao.insert(Task("Prepare food",important = true))
                dao.insert(Task("Visit Grandma", completed = true))
                dao.insert(Task("Repair my bike", completed = true))
                dao.insert(Task("Call Elon Musk", completed = true, important = true))
//
                dao.insert(Task("Buy Groceries"))
                dao.insert(Task("Prepare food",important = true))
                dao.insert(Task("Visit Grandma", completed = true))
                dao.insert(Task("Repair my bike", completed = true))
            }
        }
    }
}