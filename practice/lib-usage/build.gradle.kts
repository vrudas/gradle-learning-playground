plugins {
    id("java")
}

repositories {
    mavenCentral()
    repositories {
        maven {
            name = "repsy-j4w-13-packages-repo"
            url = uri("https://repsy.io/mvn/vrudas/j4w-13-packages/")

            credentials {
                username = System.getenv("REPO_USERNAME") ?: providers.gradleProperty("username").get()
                password = System.getenv("REPO_PASSWORD") ?: providers.gradleProperty("password").get()
            }
        }
    }
}

dependencies {
    implementation("dev.vrudas.glp:open-api-generation:0.0.1-SNAPSHOT")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
