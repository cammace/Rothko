import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(Libs.Android.GRADLE_PLUGIN)
        classpath(Libs.Android.Navigation.GRADLE_PLUGIN)
        classpath(Libs.Hilt.GRADLE_PLUGIN)
    }
}

plugins {
    kotlin("android") version Versions.KOTLIN apply false
    id("com.github.ben-manes.versions") version Versions.VERSIONS_PLUGIN
    id("com.cammace.code.quality")
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks.named<Wrapper>("wrapper") {
    distributionType = Wrapper.DistributionType.ALL
    gradleVersion = Versions.GRADLE_WRAPPER
}

tasks.named("dependencyUpdates", DependencyUpdatesTask::class).configure {
    // Example 1: reject all non stable versions
    rejectVersionIf {
        isNonStable(candidate.version)
    }
}

fun isNonStable(version: String): Boolean {
    val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
    val regex = "^[0-9,.v-]+(-r)?$".toRegex()
    val isStable = stableKeyword || regex.matches(version)
    return isStable.not()
}
