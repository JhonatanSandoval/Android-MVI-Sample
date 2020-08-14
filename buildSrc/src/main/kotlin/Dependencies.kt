const val KOTLIN_VERSION = "1.3.71"

object Deps  {
    const val MULTIDEX = "androidx.multidex:multidex:2.0.1"

    // Android
    const val ANDROIDX_ANNOTATIONS = "androidx.annotation:annotation:1.1.0"
    const val ANDROIDX_APPCOMPAT = "androidx.appcompat:appcompat:1.1.0"
    const val ANDROIDX_CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:1.1.3"
    const val ANDROIDX_CORE = "androidx.core:core-ktx:1.2.0-beta02"
    const val ANDROIDX_ACTIVITY_KTX = "androidx.activity:activity-ktx:1.2.0-alpha02"
    const val ANDROIDX_FRAGMENT_KTX = "androidx.fragment:fragment-ktx:1.3.0-alpha02"

    const val ANDROID_MATERIAL = "com.google.android.material:material:1.1.0-beta02" // https://github.com/material-components/material-components-android/releases

    private const val LIFECYCLE_VERSION = "2.2.0-rc02"
    const val ARCH_LIFECYCLE_EXT = "androidx.lifecycle:lifecycle-extensions:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_RUNTIME = "androidx.lifecycle:lifecycle-runtime-ktx:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_VIEWMODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:$LIFECYCLE_VERSION"
    const val ARCH_LIFECYCLE_SAVE_STATE = "androidx.lifecycle:lifecycle-viewmodel-savedstate:1.0.0-rc02"
    const val LIVE_DATA_KTX = "androidx.lifecycle:lifecycle-livedata-ktx:$LIFECYCLE_VERSION"

    // Dagger-Hilt
    const val HILT_VERSION = "2.28-alpha"
    const val HILT = "com.google.dagger:hilt-android:$HILT_VERSION"
    const val HILT_COMPILER = "com.google.dagger:hilt-android-compiler:$HILT_VERSION"

    private const val HILT_VIEWMODEL_VERSION = "1.0.0-alpha01"
    const val HILT_VIEWMODEL = "androidx.hilt:hilt-lifecycle-viewmodel:$HILT_VIEWMODEL_VERSION"
    const val HILT_VIEWMODEL_COMPILER = "androidx.hilt:hilt-compiler:$HILT_VIEWMODEL_VERSION"

    // Network
    private const val OKHTTP_VERSION = "4.2.2" // https://github.com/square/okhttp/blob/master/CHANGELOG.md
    const val OKHTTP = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
    const val OKHTTP_IHSANBAL_LOGGING_INTERCEPTOR = "com.github.ihsanbal:LoggingInterceptor:3.0.0"

    const val COIL = "io.coil-kt:coil:0.9.2"

    // Code
    const val KOTLIN_STD_LIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$KOTLIN_VERSION"
    const val KOTLIN_SERIALIZATION = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:0.13.0"
    private const val COROUTINES_VERSION = "1.3.8"
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$COROUTINES_VERSION"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$COROUTINES_VERSION"
    private const val RETROFIT_VERSION = "2.7.1"
    const val RETROFIT = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"
    const val EXTRAS_DELEGATES = "me.eugeniomarletti:android-extras-delegates:1.0.5"
    const val TIMBER = "com.jakewharton.timber:timber:4.7.1"
}