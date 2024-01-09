tasks.register<Copy>("copyDocs") {
    group = "custom-zip"
    description = "Copies documentation files from resources to docs directory"

    from(layout.projectDirectory.dir("src/main/resources")) // or from("src/main/resources")
    into(layout.projectDirectory.dir("docs")) // or into("docs")

    include("**/*.md")
    includeEmptyDirs = false
}

tasks.register<Zip>("zipDocs") {
    group = "custom-zip"
    description = "Zips documentation files from docs directory"

    from(layout.projectDirectory.dir("docs")) // or from("docs")

    archiveBaseName.set("docs")
    destinationDirectory.set(layout.projectDirectory)

    dependsOn("copyDocs") // or dependsOn(tasks.named("copyDocs")) !!! discuss 'dependsOn' usage
}
