plugins {
    java
    idea
    id("org.openapi.generator") version "7.2.0"
    `maven-publish`
}

repositories {
    mavenCentral()
}

group = "dev.vrudas.glp"
version = "0.0.1-SNAPSHOT"

publishing {
    repositories {
        maven {
            name = "repsy-j4w-13-packages-repo"
            url = uri("https://repsy.io/mvn/vrudas/j4w-13-packages/")

            credentials {
                username = System.getenv("USERNAME") ?: providers.gradleProperty("username").get()
                password = System.getenv("PASSWORD") ?: providers.gradleProperty("password").get()
            }
        }
    }

    publications {
        create<MavenPublication>("test-gh-packages-publish") {
            groupId = project.group as String
            artifactId = project.name
            version = project.version as String

            from(components["java"])
        }
    }
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

tasks.processResources {
    dependsOn(tasks.openApiGenerate)
}
