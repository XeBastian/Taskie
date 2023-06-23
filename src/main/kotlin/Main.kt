import kotlin.system.exitProcess

var allTasks: MutableList<TaskDetails> = mutableListOf()
fun main() {
    while (true) {
        welcomeUser()
    }
}

fun welcomeUser() {
    println("\n\n\nHello and Welcome to Taskie.")
    println("Choose any option here")
    Option.values().forEach {
        println("${Option.values().indexOf(it) + 1} : $it")
    }
    val selectedOption = readln().toInt()
    println("You chose to ${Option.values().elementAt(selectedOption - 1)}")
//    we now have a selected Option
    chooseOption(Option.values().elementAt(selectedOption - 1))

}

fun chooseOption(option: Option) {
    when (option) {
        Option.ADD -> {
            addTask()
        }

        Option.VIEW -> {
            viewTasks()
//            view the items in the task list
        }

        Option.UPDATE -> {
            println("Update Functionality selected")
            editTask()
        }

        Option.DELETE -> {
            println("Delete Functionality selected")
            deleteTask()
        }

    }
}

//add task.... get the user input here
fun addTask() {
    val randomizer = Randomizer()
    val title: String
    val description: String
    println("Enter the title of your task")
    try {
        title = readln()

    } catch (e: Exception) {
        exitProcess(0)
    }
    println("Enter the Description of your task")
    try {
        description = readln()

    } catch (e: Exception) {
        exitProcess(0)
    }

//    add functionality
    allTasks.add(TaskDetails(id = randomizer.generateRandomString(), status = "Pending", title = title, description = description))

}

fun viewTasks() {
    if (allTasks.isEmpty()) {
        println("You have no tasks. Start by adding tasks")
    } else {
        println("#.. ID.....TITLE........ DESCRIPTION..........STATUS")
        allTasks.forEach {
            println("${allTasks.indexOf(it) + 1}...${it.id}.....${it.title}........ ${it.description}..........${it.status}")
        }
    }
}

fun deleteTask() {
//    delete task indexes
    val taskIndex: Int
    viewTasks()
    println("Select the Task index you want to remove")
    try {
        taskIndex = readln().toInt()
        if (taskIndex in 1..allTasks.size) {
            allTasks.removeAt(taskIndex - 1)
            println("Delete command successfully executed")
            print("Removed a Task with the following ID and Title " + "\nID: ${allTasks.elementAt(taskIndex - 1).id}" + "\nTITLE: ${allTasks.elementAt(taskIndex - 1).title}")
        } else {
            if (taskIndex > allTasks.size) {
                println("The task at that index does not exist. Did you mean to delete the last Task?")
                println("1. YES")
                val lastItem: String = readln()
                if (lastItem == "1" || lastItem == "YES") {
                    allTasks.removeLast()
                } else {
                    return
                }

            } else if (taskIndex < 0) {
                println("The task at that index does not exist. Did you mean to delete the first Task?")
                println("1. YES")
                println("2. NO")
                val firstItem: String = readln()
                if (firstItem == "1" || firstItem == "YES") {
                    allTasks.removeFirst()
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
    val taskIndex: Int = readln().toInt()
    if (taskIndex - 1 in 0..allTasks.size) {
//            edit functionality
        println("Choose what to edit")
        println("1. Title")
        println("2. Description")
        println("3. Status")
        val selectedIndex: Int = readln().toInt()
        if (selectedIndex == 1) {
            println("The task you want to edit is \n" +
                    "")
            println("${allTasks.indexOf(allTasks.elementAt(selectedIndex))}...${allTasks.elementAt(selectedIndex).id}.....${allTasks.elementAt(selectedIndex).title}........ ${allTasks.elementAt(selectedIndex).description}..........${allTasks.elementAt(selectedIndex).status}")
            println("You selected to edit Title")
            println("Old Title : ${allTasks.elementAt(selectedIndex).title}\n Enter the New title\n")
            val newTitle = readln()
            allTasks.elementAt(selectedIndex).title = newTitle
            println("The updated Task is")
            println("${allTasks.indexOf(allTasks.elementAt(selectedIndex))}...${allTasks.elementAt(selectedIndex).id}.....${allTasks.elementAt(selectedIndex).title}........ ${allTasks.elementAt(selectedIndex).description}..........${allTasks.elementAt(selectedIndex).status}")

        }
    }
}

enum class Option {
    ADD, VIEW, UPDATE, DELETE,
}