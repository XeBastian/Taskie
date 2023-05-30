class TaskBrain {
    private var taskList = mutableListOf<TaskDetails>()

    fun addTask(task: TaskDetails) {
        when {
            taskList.contains(task) -> {
            }

            else -> taskList.add(task)
        }
    }

    fun removeTask(task: TaskDetails) {
        when {
            taskList.contains(task) -> {
                taskList.remove(task)
            }

            else -> {
            }
        }
    }

    fun editTask(task: TaskDetails) {
        when {
            taskList.contains(task) -> {
                //            edit functionality
            }

            else -> {
            }
        }
    }
}