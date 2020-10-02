import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.apollographql.apollo") version Versions.APOLLO
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        buildConfigField("String", "ARTSY_ACCESS_TOKEN", "\"${System.getenv("ROTHKO_ARTSY_ACCESS_TOKEN")}\"")
        buildConfigField("String", "ARTSY_USER_ID", "\"${System.getenv("ROTHKO_ARTSY_USER_ID")}\"")
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
    // Kotlin
    implementation(kotlin("stdlib"))

    // Android
    implementation(Libs.Android.CORE_KTX)

    // Network
    implementation(Libs.Apollo.RUNTIME)
    implementation(Libs.Apollo.COROUTINE)
    implementation(Libs.OkHttp.CORE)
    implementation(Libs.OkHttp.LOGGING)

    // Dagger
    implementation(Libs.Dagger.HILT)
    kapt(Libs.Dagger.HILT_COMPILER)

    // Misc
    implementation(Libs.TIMBER)
}

apollo {
    // Tells Apollo to generate Kotlin models
    generateKotlinModels.set(true)
    schemaFile.set(file("src/main/graphql/com/cammace/rothko/schema.graphql"))
    graphqlSourceDirectorySet.srcDir("src/main/graphql/com/cammace/rothko")

    // Exclude
    graphqlSourceDirectorySet.exclude("**/schema.graphql", "**/.graphqlconfig")
}
