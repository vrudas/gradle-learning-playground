tasks.register("printValueFromGradleProperties") {
    description = "Prints the value of the 'custom.property' property"
    group = "properties"

    doFirst {
        println("Message: " + project.property("custom.property"))
    }
}

tasks.register("printGradleJvmArgs") {
    description = "Prints the value of the 'org.gradle.jvmargs' property"
    group = "properties"

    doFirst {
        println("Gradle JVM args: ${project.property("org.gradle.jvmargs")}")
    }
}
