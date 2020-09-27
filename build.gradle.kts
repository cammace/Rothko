import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version Versions.ANDROID_GRADLE apply false
    id("com.android.library") version Versions.ANDROID_GRADLE apply false
    kotlin("android") version Versions.KOTLIN apply false
    id("androidx.navigation.safeargs.kotlin") version Versions.NAVIGATION apply false
    id("com.github.ben-manes.versions") version Versions.GRADLE_VERSION_PLUGIN
    id("com.cammace.code.quality")
}

allprojects {
    repositories {
        google()
        jcenter()
    }
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
