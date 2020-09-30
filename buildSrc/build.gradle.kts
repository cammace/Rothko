plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    gradlePluginPortal()
    google()
}

dependencies {
    implementation("com.android.tools.build:gradle-api:4.0.1")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.6.1")
}

dependencies {
    implementation("com.android.tools.build:gradle:4.0.1")
}

gradlePlugin {
    plugins {
        create("codeQuality") {
            id = "com.cammace.code.quality"
            implementationClass = "CodeQualityPlugin"
        }
    }
}
