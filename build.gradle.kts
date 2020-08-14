// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(ClassPath.GRADLE_PLUGIN)
        classpath(ClassPath.KOTLIN_GRADLE_PLUGIN)
        classpath(ClassPath.DAGGER_HILT_GRADLE_PLUGIN)
    }
}

allprojects {
    repositories {
        mavenLocal()
        google()
        mavenCentral()
        jcenter()
        maven("https://jitpack.io")
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}