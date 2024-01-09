plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

rootProject.name = "gradle-learning-playground"

include("theory")
include("theory:hello-world")
include("practice")
include("theory:gradle-properties")
include("theory:typed-task")
include("theory:zip-task")
