plugins {
    `kotlin-dsl`
}

kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

repositories {
    gradlePluginPortal()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:5.6.1")
}

gradlePlugin {
    plugins {
        create("codeQuality") {
            id = "com.cammace.code.quality"
            implementationClass = "CodeQualityPlugin"
        }
    }
}
