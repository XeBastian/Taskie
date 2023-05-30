fun main() {
    welcomeUser()
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
        Option.ADD -> println("Adding Functionality selected")
        Option.VIEW -> println("View Functionality selected")
        Option.UPDATE -> println("Update Functionality selected")
        Option.DELETE -> println("Delete Functionality selected")
        else -> println("Seems you selected a wrong option")
    }
}


enum class Option {
    ADD, VIEW, UPDATE, DELETE,
}