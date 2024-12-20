plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.hilt.android)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.ezgieren.kotlinbasestructor"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.ezgieren.kotlinbasestructor"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        // API key added in BuildConfig
        buildConfigField("String", "API_KEY", project.properties["API_KEY"] as String)
        buildConfigField("String", "BASE_URL", project.properties["BASE_URL"] as String)
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.3"
    }
}

dependencies {
    // Compose Libraries
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.ui)
    implementation(libs.ui.tooling.preview)
    implementation(libs.androidx.material3)

    // Hilt for Dependency Injection
    implementation(libs.hilt.android)
    implementation(libs.androidx.material3.android)
    implementation(libs.androidx.hilt.navigation.compose)
    ksp(libs.hilt.compiler)

    // Retrofit & Gson for API calls
    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    // Coroutine Support for background tasks
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)

    // ViewModel & LiveData
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)

    // Coil (Image Loading)
    implementation(libs.coil.compose)

    // OkHttp
    implementation(libs.okhttp.logging.interceptor)

    // Navigation
    implementation(libs.navigation.compose)

    // Testing Libraries
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}