import java.util.Date

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

val javaVersion: JavaVersion by extra { JavaVersion.VERSION_1_8 }

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

val buildTime = Date().time
val versionCodeAppName = "HelloDoctor-Patient"
val minVersionCode = 10_00_00
val appVersionCode = VersionCode.readVersionCode(versionCodeAppName, minVersionCode)
val appVersionName = "1.0.0"

android {
    compileSdkVersion(AndroidSdk.COMPILE)

    defaultConfig {
        minSdkVersion(AndroidSdk.MIN)
        targetSdkVersion(AndroidSdk.TARGET)

        applicationId = "pro.jsandoval.mvisample"

        versionCode = appVersionCode
        versionName = appVersionName

        multiDexEnabled = true
    }

    buildTypes {
        getByName("debug") {
            versionNameSuffix = " DEV"
            buildConfigField("long", "BUILD_TIME", "0l")
        }
        getByName("release") {
            buildConfigField("long", "BUILD_TIME", "${buildTime}l")
        }
    }

    compileOptions {
        sourceCompatibility = javaVersion
        targetCompatibility = javaVersion
    }

    lintOptions {
        isAbortOnError = false
        disable("InvalidPackage")
    }

    buildFeatures {
        buildConfig = true
        dataBinding = true
        resValues = true
    }

    dependenciesInfo {
        includeInApk = false
        includeInBundle = false
    }

}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(Deps.MULTIDEX)

    // Android + UI
    implementation(Deps.ANDROIDX_APPCOMPAT)
    implementation(Deps.ANDROIDX_CORE)
    implementation(Deps.ANDROID_MATERIAL)
    implementation(Deps.ANDROIDX_ANNOTATIONS)
    implementation(Deps.ANDROIDX_CONSTRAINT_LAYOUT)
    implementation(Deps.ANDROIDX_ACTIVITY_KTX)
    implementation(Deps.ANDROIDX_FRAGMENT_KTX)
    implementation(Deps.COIL)

    // === Android Architecture Components ===
    implementation(Deps.ARCH_LIFECYCLE_EXT)
    implementation(Deps.ARCH_LIFECYCLE_RUNTIME)
    implementation(Deps.ARCH_LIFECYCLE_VIEWMODEL)
    implementation(Deps.ARCH_LIFECYCLE_SAVE_STATE)
    implementation(Deps.LIVE_DATA_KTX)

    // Hilt
    implementation(Deps.HILT)
    kapt(Deps.HILT_COMPILER)
    implementation(Deps.HILT_VIEWMODEL)
    kapt(Deps.HILT_VIEWMODEL_COMPILER)

    // Networking
    implementation(Deps.RETROFIT)
    implementation(Deps.GSON_CONVERTER)
    implementation(Deps.OKHTTP)
    implementation(Deps.OKHTTP_IHSANBAL_LOGGING_INTERCEPTOR)

    // Code
    implementation(Deps.KOTLIN_STD_LIB)
    implementation(Deps.KOTLIN_SERIALIZATION)
    implementation(Deps.COROUTINES_CORE)
    implementation(Deps.COROUTINES_ANDROID)
    implementation(Deps.EXTRAS_DELEGATES)
    implementation(Deps.TIMBER)
}