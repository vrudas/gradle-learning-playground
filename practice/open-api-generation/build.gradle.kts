plugins {
    java
    idea
    id("org.openapi.generator") version "7.2.0"
}

repositories {
    mavenCentral()
}

val javaxVersion = "1.3.2"
val jsr305Version = "3.0.2"
val gsonVersion = "2.10.1"

dependencies {
    implementation("javax.annotation:javax.annotation-api:$javaxVersion")
    implementation("com.google.code.findbugs:jsr305:$jsr305Version")
    implementation("com.google.code.gson:gson:$gsonVersion")
}

openApiGenerate {
    generatorName = "java"
    inputSpec = layout.projectDirectory.file("src/main/resources/openapi.yaml").asFile.path
    outputDir = layout.projectDirectory.asFile.path

    modelPackage.set("dev.vrudas.glp.cipher.generated.model")

    generateModelTests.set(false)
    generateModelDocumentation.set(false)

    globalProperties.set(mapOf(
        "apis" to "false",
        "invokers" to "false",
        "models" to ""
    ))
}

tasks.compileJava {
    dependsOn(tasks.openApiGenerate)
}
