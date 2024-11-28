// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.jetbrains.kotlin.jvm) apply false
    id("com.android.library") version "8.7.2" apply false
    // TODO Пишет что плагин скачан
    //id("org.jetbrains.kotlin.jvm") version "1.9.23" apply false
    id("com.google.devtools.ksp") version "2.0.21-1.0.27" apply false
    //id("com.google.dagger.hilt.android") version "2.51.1" apply false
}