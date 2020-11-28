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
    implementation("com.android.tools.build:gradle-api:4.2.0-alpha16")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.8.2")
}

dependencies {
    implementation("com.android.tools.build:gradle:4.2.0-alpha16")
}

gradlePlugin {
    plugins {
        create("codeQuality") {
            id = "com.cammace.code.quality"
            implementationClass = "CodeQualityPlugin"
        }
    }
}
