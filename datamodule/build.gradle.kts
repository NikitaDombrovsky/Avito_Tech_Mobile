import java.util.Properties
import javax.crypto.SecretKey


plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}
// Creates a variable called keystorePropertiesFile, and initializes it to the
// keystore.properties file.
/*val keystorePropertiesFile = rootProject.file("apikeys.properties")

// Initializes a new Properties() object called keystoreProperties.
val keystoreProperties = Properties()

// Loads the keystore.properties file into the keystoreProperties object.
keystoreProperties.load(FileInputStream(keystorePropertiesFile))*/

android {
    namespace = "com.example.datamodule"
    compileSdk = 35
    //val apiKey = gradleLocalProperties(project.rootDir, providers = Properties().getProperty("")).getProperty("apiKey")

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")

        val properties = Properties()
        properties.load(project.rootProject.file("apikeys.properties").inputStream())
        buildConfigField("String", "WAPI_KEY", properties.getProperty("API_KEY"))

    //
        // TODO Это не работает
       // val apiKey = gradleLocalProperties(rootDir).getProperty("API_KEY")
            //buildConfigField("String", "API_KEY", apiKey)

/*        productFlavors {
            getByName("dev") {
                // Key duplication only for example
                buildConfigField("String", "NEWS_STAGE_API_KEY", apiKey)
                buildConfigField("String", "NEWS_API_KEY", apiKey)
                buildConfigField("String", "NEWS_STAGE_URL", "\"https://newsapi.org/v2/\"")
                buildConfigField("String", "NEWS_URL", "\"https://newsapi.org/v2/\"")
            }
            getByName("prod") {
                buildConfigField("String", "NEWS_API_KEY", apiKey)
                buildConfigField("String", "NEWS_URL", "\"https://newsapi.org/v2/\"")
            }
        }*/

/*
        Properties properties = new  Properties()
        properties.load(project.rootProject.file("local.properties").newDataInputStream())

        buildConfigField "String", "API_KEY","\"${properties.getProperty("API_KEY")}\""
*/

/*      TODO Вроде работало  //load the values from .properties file
       val keystoreFile = project.rootProject.file("apikeys.properties")
        val properties = Properties()
        properties.load(keystoreFile.inputStream())

        //return empty key in case something goes wrong
        val apiKey = properties.getProperty("API_KEY") ?: ""*/


        
       // buildConfigField("String", "API_KEY", apiKey)
        //
/*        val keyGenerator: KeyGenerator =
            KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
        keyGenerator.init(
            Builder(
                "myKeyAlias",
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)
                .build()
        )
        val myKey: SecretKey = keyGenerator.generateKey()*/
    }

    // TODO Нейронка
    buildFeatures {
        // Enable the BuildConfig feature
        buildConfig = true
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
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(project(":domain"))
    implementation(libs.koin.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")


    // GSON

    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // coroutine

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.2")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
}