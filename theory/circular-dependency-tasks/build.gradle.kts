tasks.register("firstTask") {
    group = "circular"
    description = "Task 'firstTask' depends on task 'secondTask'"

    dependsOn("secondTask")
}

tasks.register("secondTask") {
    group = "circular"
    description = "Task 'secondTask' depends on task 'firstTask'"

    dependsOn("firstTask")
}
