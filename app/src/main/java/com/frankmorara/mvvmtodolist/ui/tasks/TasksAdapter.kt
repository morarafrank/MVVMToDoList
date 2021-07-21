package com.frankmorara.mvvmtodolist.ui.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.frankmorara.mvvmtodolist.databinding.ItemTaskBinding
import com.frankmorara.mvvmtodolist.db.Task

class TasksAdapter: ListAdapter<Task, TasksAdapter.TasksViewHolder>(DiffCallback()) {
//    ListAdapter is a subclass of recyclerview adapter
//    Used when you have a reactive data source where you
//    have a completely new list passed to you
    class TasksViewHolder(private val binding: ItemTaskBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(task: Task){
            binding.apply {
                checkBoxCompleted.isChecked = task.completed
                textViewName.text = task.name
                textViewName.paint.isStrikeThruText = task.completed
                labelPriority.isVisible = task.important
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TasksViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int){
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }
    class DiffCallback: DiffUtil.ItemCallback<Task>() {
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem == newItem
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean = oldItem.id == newItem.id

    }
}