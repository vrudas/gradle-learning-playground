plugins {
    id("java")
    id("checkstyle")
    id("name.remal.sonarlint") version "3.4.2"
}

sonarLint {
    languages {
        include("java")
    }

    rules {
        disable(
            "java:S1192", // Allow string literals to be duplicated
            "java:S1197", // Allow constants to be defined in interfaces
            "java:S1118", // Allow utility classes to have a private constructor
            "java:S106", // Allow system out and err to be used
            "java:S107", // Allow constructors with more than 7 parameters
            "java:S3776", // Allow methods with more than 15 lines
            "java:S1135", // Allow T0D0 comments
            "java:S2094" // Allow empty classes for homeworks
        )
    }
}

checkstyle {
    toolVersion = "10.3.3"
}

tasks.withType<Checkstyle>().configureEach {
    reports {
        xml.required = false
        html.required = true
    }
}
