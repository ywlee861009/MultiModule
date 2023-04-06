plugins {
    id(PlugIn.APPLICATION)
    id(PlugIn.ANDROID)
    id(PlugIn.KAPT)
    id(PlugIn.HILT)
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
}

dependencies {
    implementation(Libraries.KTX)
    implementation(Libraries.ACTIVITY_KTX)
    implementation(Libraries.FRAGMENT_KTX)
    implementation(Libraries.APP_COMPAT)
    implementation(Libraries.MATERIAL)
    implementation(Libraries.CONSTRAINT_LAYOUT)
    implementation(project(mapOf("path" to ":presentation")))
    implementation(project(mapOf("path" to ":data")))
    implementation(project(mapOf("path" to ":domain")))
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