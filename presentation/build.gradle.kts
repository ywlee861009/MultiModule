plugins {
    id(PlugIn.LIBRARY)
    id(PlugIn.ANDROID)
    id(PlugIn.KAPT)
    id(PlugIn.HILT)
}

android {
    namespace = "com.example.multimodule.presentation"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
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

    implementation(Libraries.COIL)
    implementation(Libraries.COIL_GIF)

    implementation(Libraries.EXPANDABLE_LAYOUT)
}