plugins {
    id("java")
}

group = "dev.vrudas.glp"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    // Usage of a single dependency - Example
    implementation("com.google.guava:guava:33.0.0-jre")
    implementation("com.github.ben-manes.caffeine:caffeine:3.1.8")
    implementation("org.slf4j:slf4j-api:2.0.11")

    /*
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
            <version>2.0.11</version>
        </dependency>
    */
    implementation("org.slf4j:slf4j-simple:2.0.11")


    // Usage of BOM dependencies - Example
    testImplementation(platform("org.junit:junit-bom:5.10.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.junit.jupiter:junit-jupiter-params")
}

tasks.test {
    useJUnitPlatform()
}
