plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
    id("dagger.hilt.android.plugin")
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

    buildFeatures {
        viewBinding = true
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

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(project(":core"))

    // Kotlin
    implementation(kotlin("stdlib"))

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

    // Injection
    implementation(Libs.Hilt.CORE)
    kapt(Libs.Hilt.COMPILER)
    implementation(Libs.Hilt.Android.VIEW_MODEL)
    kapt(Libs.Hilt.Android.COMPILER)

    // Network
    implementation(Libs.Apollo.RUNTIME)
    implementation(Libs.Apollo.COROUTINE)
    implementation(Libs.OkHttp.CORE)
    implementation(Libs.OkHttp.LOGGING)

    // Misc
    implementation(Libs.Epoxy.CORE)
    implementation(Libs.Epoxy.PAGING)
    kapt(Libs.Epoxy.PROCESSOR)
    implementation(Libs.Coil.CORE)
    implementation(Libs.TIMBER)

    // Testing
    testImplementation(Libs.Testing.JUNIT)
    testImplementation(Libs.Hilt.TESTING)
    kaptTest(Libs.Hilt.COMPILER)

    // Instrumentation Testing
    androidTestImplementation(Libs.Testing.Android.JUNIT)
    androidTestImplementation(Libs.Testing.Espresso.CORE)
    androidTestImplementation(Libs.Hilt.TESTING)
    androidTestImplementation(Libs.Hilt.TESTING)
    kaptAndroidTest(Libs.Hilt.COMPILER)
}
