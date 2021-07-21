package com.frankmorara.mvvmtodolist.db

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat

@Parcelize
@Entity(tableName = "task_table")
data class Task(
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    val created: Long = System.currentTimeMillis(),
    @PrimaryKey val id: Int = 0,
): Parcelable{
    val createdDateFormatted: String
    get() = DateFormat.getDateInstance().format(created)
}