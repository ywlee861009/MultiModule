plugins {
    id(PlugIn.LIBRARY)
    id(PlugIn.ANDROID)
    id(PlugIn.KAPT)
}

android {
    namespace = "com.example.multimodule.data"
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
}

dependencies {
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