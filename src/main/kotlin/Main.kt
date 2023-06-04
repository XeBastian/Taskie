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
    var taskController: TaskBrain = TaskBrain()
    when (option) {
        Option.ADD -> {
            taskController.addTask()
        }

        Option.VIEW -> {
//            view the items in the task list
            taskController.viewTasks()
        }

        Option.UPDATE -> {
            taskController.editTask()
        }
        Option.DELETE -> {
            taskController.deleteTask()
        }

        else -> println("Seems you selected a wrong option")
    }
}
enum class Option {
    ADD, VIEW, UPDATE, DELETE,
}