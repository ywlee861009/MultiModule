plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace= "com.example.multimodule"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = "com.example.multimodule"
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    kapt {
        correctErrorTypes = true
    }
    dataBinding {
        enable = true
    }
}

dependencies {
    implementation(Libraries.KTX)
    implementation(Libraries.ACTIVITY_KTX)
    implementation(Libraries.FRAGMENT_KTX)
    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINT_LAYOUT)
    testImplementation(Libraries.J_UNIT)
    androidTestImplementation(Libraries.J_UNIT_EXT)
    androidTestImplementation(Libraries.ESPRESSO_CORE)

    implementation(Libraries.RETROFIT)
    implementation(Libraries.CONVERTOR_GSON)
    implementation(Libraries.LOGGING_INTERCEPTOR)

    implementation(Libraries.HILT_ANDROID)
    kapt(Libraries.HILT_COMPILER)
    kapt(Libraries.HILT_COMPILER_ANDROID_X)
}