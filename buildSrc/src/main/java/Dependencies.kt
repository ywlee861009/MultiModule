object Versions {
    const val KTX = "1.9.0"
    const val ACTIVITY_KTX = "1.7.0"
    const val FRAGMENT_KTX = "1.5.6"
    const val APP_COMPAT = "1.6.1"
    const val MATERIAL = "1.8.0"
    const val CONSTRAINT_LAYOUT = "2.1.4"

    const val J_UNIT = "4.13.2"
    const val J_UNIT_EXT = "1.1.5"
    const val ESPRESSO_CORE = "3.5.1"

    const val RETROFIT = "2.9.0"
    const val LOGGING_INTERCEPTOR = "4.10.0"

    const val HILT = "2.44"
    const val HILT_COMPILER = "1.0.0"

    const val COIL = "2.3.0"
}

object Libraries {
    const val KTX = "androidx.core:core-ktx:${Versions.KTX}"
    const val ACTIVITY_KTX = "androidx.activity:activity-ktx:${Versions.ACTIVITY_KTX}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.FRAGMENT_KTX}"
    const val APP_COMPAT = "androidx.appcompat:appcompat:${Versions.APP_COMPAT}"
    const val MATERIAL = "com.google.android.material:material:${Versions.MATERIAL}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    const val J_UNIT = "junit:junit:${Versions.J_UNIT}"
    const val J_UNIT_EXT = "androidx.test.ext:junit:${Versions.J_UNIT_EXT}"
    const val ESPRESSO_CORE = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO_CORE}"

    const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT}"
    const val CONVERTOR_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT}"
    const val LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor:${Versions.LOGGING_INTERCEPTOR}"

    const val HILT_PLUGIN = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
    const val HILT_ANDROID = "com.google.dagger:hilt-android:${Versions.HILT}"
    const val HILT_COMPILER = "com.google.dagger:hilt-compiler:${Versions.HILT}"
    const val HILT_COMPILER_ANDROID_X = "androidx.hilt:hilt-compiler:${Versions.HILT_COMPILER}"

    const val COIL = "io.coil-kt:coil:${Versions.COIL}"
    const val COIL_GIF = "io.coil-kt:coil-gif:${Versions.COIL}"
}

object ClassPath {
    const val HILT = "com.google.dagger:hilt-android-gradle-plugin:${Versions.HILT}"
}

object PlugIn {
    const val LIBRARY = "com.android.library"
    const val APPLICATION = "com.android.application"
    const val ANDROID = "org.jetbrains.kotlin.android"
    const val KAPT = "kotlin-kapt"
    const val HILT = "dagger.hilt.android.plugin"
}