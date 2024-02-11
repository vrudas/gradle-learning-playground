tasks.register<Tar>("compressDocs") {
    group = "compression"
    description = "Compress text files into a Tar archive"

    from(layout.projectDirectory.dir("src/main/resources"))
    include("**/*.text")
    rename { it.replace(".text", ".txt") }

    archiveBaseName.set("docs")
    destinationDirectory.set(layout.buildDirectory.dir("archive"))

    compression = Compression.GZIP

    includeEmptyDirs = false

    doFirst { println("Start compression of files") }
}

tasks.register("startCompression") {
    group = "compression"
    description = "Triggers a compression process"

    dependsOn("compressDocs")
}

tasks.register<Copy>("decompressDocs") {
    group = "compression"
    description = "Decompress text files from a Tar archive"

    from(tarTree(layout.buildDirectory.file("archive/docs.tgz")))
    into(layout.projectDirectory.dir("src/test/resources"))

    doLast { println("Completed decompression of files") }

    dependsOn("startCompression")
}

tasks.register<Delete>("cleanup") {
    group = "compression"
    description = "Deletes files files created during compress/decompress tasks"

    delete(
        layout.buildDirectory.dir("archive"),
        layout.projectDirectory.dir("src/test/resources")
    )
}

