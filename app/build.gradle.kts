plugins {
    id("com.android.application")
}

android {
    namespace = "com.redtermapp.plugin.hello"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.redtermapp.plugin.hello"
        minSdk = 24
        targetSdk = 37
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        release {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.19.1")
    implementation("androidx.appcompat:appcompat:1.8.0")
}
