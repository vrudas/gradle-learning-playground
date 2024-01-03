tasks.register("helloWorld") {
    doLast {
        println("Hello World")
    }
}

//<editor-fold desc="Task with a custom group and description">

tasks.register("helloWorldCustom") {
    description = "Prints 'Hello World' to the console"
    group = "custom"

    doLast {
        println("Hello World")
    }
}

//</editor-fold>
