// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
}
buildscript{
    val kotlinVersion by extra("1.9.20-RC")
    dependencies{
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.7.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
    repositories {
        mavenCentral()
    }
}