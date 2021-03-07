package data


import android.app.Application
import androidx.lifecycle.LiveData
import com.example.todoapp.SortColumn
import com.example.todoapp.Task
import com.example.todoapp.TaskStatus


class TaskListRepository(context: Application){
    private val taskListDao: TaskListDao = TaskDatabase.getDatabase(context).taskListDao()

    fun getTasks(sort: SortColumn = SortColumn.Priority
    ): LiveData<List<Task>> {
        return if(sort == SortColumn.Priority){
            taskListDao.getTasksByPriority(TaskStatus.Open.ordinal)
        } else{
            taskListDao.getTasksByTitle(TaskStatus.Open.ordinal)
        }


    }
}