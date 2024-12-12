import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    //id("org.jetbrains.kotlin.jvm") version "1.9.0"
    //id("com.google.devtools.ksp") version "1.9.0-1.0.12"
    id("com.google.devtools.ksp") version "2.0.21-1.0.27"

    //id("com.google.devtools.ksp")
/*    id("kotlin-kapt")*/
    //TODO
   // id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.avito_mobile_dombrovskiy"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.avito_mobile_dombrovskiy"
        minSdk = 25
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        //
        /*val properties = Properties()
        properties.load(project.rootProject.file("apikeys.properties").inputStream())
        buildConfigField("String", "WEATHER_API_KEY", properties.getProperty("API_KEY"))
*/
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        // Enable the BuildConfig feature
        buildConfig = true
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(project(":domain"))
    implementation(project(":datamodule"))
    implementation(libs.androidx.compose.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.4.0")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")


    // GSON

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // coroutine

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")


     implementation("com.google.dagger:hilt-android:2.51.1")

    implementation("androidx.room:room-ktx:2.5.0")
    //ksp("androidx.room:room-compiler:2.5.0")
    // Koin for Kotlin apps
    val koin_version = "3.1.2"
    implementation("io.insert-koin:koin-core:$koin_version") //+
    implementation("io.insert-koin:koin-android:$koin_version") //+
    //Koin Jetpack
    implementation("io.insert-koin:koin-androidx-compose:$koin_version")
    val nav_version = "2.8.4"

    // Jetpack Compose integration
    implementation("androidx.navigation:navigation-compose:$nav_version")

    // Views/Fragments integration
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")

    // Feature module support for Fragments
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")



    ksp("com.google.dagger:dagger-compiler:2.48") // Dagger compiler
    ksp("com.google.dagger:hilt-compiler:2.48")   // Hilt compiler

    //kapt("com.google.dagger:hilt-android-compiler:2.44")
/*    dependencies {
        implementation "com.google.dagger:hilt-android:2.51.1"
        kapt "com.google.dagger:hilt-compiler:2.51.1"
    }*/
/*
// Allow references to generated code
    kapt {
        correctErrorTypes true
    }*/
}


