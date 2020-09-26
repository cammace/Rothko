plugins {
    id("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.cammace.rothko"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
}

dependencies {

    // Kotlin
    implementation(Libs.Kotlin.STDLIB)

    // Android
    implementation(Libs.Android.CORE_KTX)
    implementation(Libs.Android.APPCOMPAT)
    implementation(Libs.Android.ACTIVITY_KTX)
    implementation(Libs.Android.FRAGMENT_KTX)
    implementation(Libs.Android.CONSTRAINT_LAYOUT)
    implementation(Libs.Android.Lifecycle.LIVE_DATA_KTX)
    implementation(Libs.Android.Lifecycle.VIEW_MODEL_KTX)
    implementation(Libs.Android.Navigation.FRAGMENT_KTX)
    implementation(Libs.Android.Navigation.UI_KTX)

    // Google
    implementation(Libs.Google.MATERIAL)

    // Misc.
    implementation(Libs.TIMBER)

    // Testing
    testImplementation(Libs.Testing.JUNIT)
    androidTestImplementation(Libs.Testing.Android.JUNIT)
    androidTestImplementation(Libs.Testing.Espresso.CORE)
}
