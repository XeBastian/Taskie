class TaskBrain {
    private var taskList = mutableListOf<TaskDetails>()
    val allTasks: MutableList<TaskDetails> = taskList


    fun addTask() {
        val randomizer = Randomizer()
        var title = ""
        var description = ""
        println("Enter the title of your task")
        try {
            title = readln()

        } catch (e: Exception) {

        }
        println("Enter the Descripion of your task")
        try {
            description = readln()

        } catch (e: Exception) {

        }

//    add functionality
        taskList.add(TaskDetails(id = randomizer.generateRandomString(), status = "Pending", title = title, description = description))

    }

    fun viewTasks() {
        if (taskList.isEmpty()) {
            println("You have no tasks. Start by adding tasks")
        } else {
            println("#.. ID.....TITLE........ DESCRIPTION..........STATUS")
            taskList.forEach {
                println("${taskList.indexOf(it) + 1}...${it.id}.....${it.title}........ ${it.description}..........${it.status}")
            }
        }
    }

    fun deleteTask() {
//    delete task indexes
        var taskIndex: Int = -1
        viewTasks()
        println("Select the Task index you want to remove")
        try {
            taskIndex = readln().toInt()
            if (taskIndex in 1..taskList.size) {
                taskList.removeAt(taskIndex - 1)
                println("Delete command successfully executed")
                print("Removed a Task with the following ID and Title " + "\nID: ${taskList.elementAt(taskIndex - 1).id}" + "\nTITLE: ${allTasks.elementAt(taskIndex - 1).title}")
            } else {
                if (taskIndex > taskList.size) {
                    println("The task at that index does not exist. Did you mean to delete the last Task?")
                    var lastItem: String = ""
                    println("1. YES")
                    lastItem = readln().toString()
                    if (lastItem == "1" || lastItem == "YES") {
                        taskList.removeLast()
                    } else {
                        return
                    }

                } else if (taskIndex < 0) {
                    println("The task at that index does not exist. Did you mean to delete the first Task?")
                    println("1. YES")
                    println("2. NO")
                    var firstItem: String = ""
                    firstItem = readln().toString()
                    if (firstItem == "1" || firstItem == "YES") {
                        taskList.removeFirst()
                    } else {
                        return
                    }
                }
            }

        } catch (e: Exception) {
            println("Please input a number")
        }

    }

    fun editTask() {
        viewTasks()
        println("Enter the number of the task you want to edit")
        var taskIndex: Int = -1
        taskIndex = readln().toInt()
        if (taskIndex - 1 in 0..taskList.size) {
//            edit functionality
            println("Choose what to edit")
            println("1. Title")
            println("2. Description")
            println("3. Status")
            var selectedIndex = -1
            selectedIndex = readln().toInt()
            if (selectedIndex == 1) {
                println("The task you want to edit is \n" +
                        "")
                println("${taskList.indexOf(taskList.elementAt(selectedIndex))}...${taskList.elementAt(selectedIndex).id}.....${taskList.elementAt(selectedIndex).title}........ ${taskList.elementAt(selectedIndex).description}..........${taskList.elementAt(selectedIndex).status}")
                println("You selected to edit Title")
                println("Old Title : ${taskList.elementAt(selectedIndex).title}\n Enter the New title\n")
                var newTitle = readln().toString()
                taskList.elementAt(selectedIndex).title = newTitle
                println("The updated Task is")
                println("${taskList.indexOf(taskList.elementAt(selectedIndex))}...${taskList.elementAt(selectedIndex).id}.....${taskList.elementAt(selectedIndex).title}........ ${taskList.elementAt(selectedIndex).description}..........${taskList.elementAt(selectedIndex).status}")

            }
        }
    }
}