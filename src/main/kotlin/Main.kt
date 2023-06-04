var allTasks: MutableList<TaskDetails> = mutableListOf<TaskDetails>()
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
    var selectedOption = readln().toInt()
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

        Option.UPDATE -> println("Update Functionality selected")
        Option.DELETE -> println("Delete Functionality selected")
        else -> println("Seems you selected a wrong option")
    }
}

//add task.... get the user input here
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
    allTasks.add(TaskDetails(id = randomizer.generateRandomString(), status = "Pending", title = title, description = description))

}

fun viewTasks() {
    if (allTasks.isEmpty()) {
        println("You have no tasks. Start by adding tasks")
    } else {
        println("ID.....TITLE........ DESCRIPTION..........STATUS")
        allTasks.forEach {
            println("${it.id}.....${it.title}........ ${it.description}..........${it.status}")
        }
    }
}

enum class Option {
    ADD, VIEW, UPDATE, DELETE,
}