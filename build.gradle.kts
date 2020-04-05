open class BootNodeJsTask : Exec() {
    @get:Input
    var outputDir: File = project.buildDir
}

plugins {
    kotlin("jvm") version "1.3.71"
    kotlin("plugin.spring") version "1.3.71"
}
repositories {
    mavenCentral()
}

group = "com.reservation"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

open class BootJsTask : DefaultTask() {
    @get:Input
    var buildDir = "./build"

    @TaskAction
    fun greet() {
        println(buildDir)
    }
}

task("bootJar") {
    val projectBuildFile = project.buildDir
    var commands = ""
    val version = getVersion()
    subprojects {
        commands += "bash -c \"exec -a reservation java -jar ${this.name}-${version}.jar &\"\n"

        val subProjectPath = this.path
        this.getTasksByName("bootJar", false).forEach {
            dependsOn("${subProjectPath}:${it.name}")
            (it as org.gradle.jvm.tasks.Jar).destinationDirectory.fileValue(projectBuildFile)
        }
        this.getTasksByName("bootJs", false).forEach {
            dependsOn("${subProjectPath}:${it.name}")
            (it as BootNodeJsTask).outputDir = projectBuildFile
        }
    }

    doLast {
        File(projectBuildFile.path, "startup.sh").writeText(commands)
    }
}
