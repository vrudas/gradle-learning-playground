tasks.register<Copy>("copyFiles") {
    group = "custom-copy"
    description = "Copies files from one directory to another"

    from("sourceFiles")
    into("destinationFiles")
}

tasks.register("copyFilesTypeClass", Copy::class) {
    group = "custom-copy"
    description = "Copies files from one directory to another"

    from("sourceFiles")
    into("destinationFiles")
}


//<editor-fold desc="Copy Docs Example">
/**
 * https://docs.gradle.org/current/userguide/working_with_files.html#ex-using-a-deep-filter
 */
tasks.register<Copy>("copyDocs") {
    group = "custom-copy"
    description = "Copies documentation files from resources to docs directory"

    from(layout.projectDirectory.dir("src/main/resources")) // or from("src/main/resources")
    into(layout.projectDirectory.dir("docs")) // or into("docs")

    include("**/*.md")
    includeEmptyDirs = false
}
//</editor-fold>
