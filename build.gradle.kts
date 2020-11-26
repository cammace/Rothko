import com.github.benmanes.gradle.versions.updates.DependencyUpdatesTask

buildscript {
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:${Versions.ANDROID_GRADLE}")
        classpath(Libs.Android.Navigation.GRADLE_PLUGIN)
        classpath(Libs.Dagger.HILT_GRADLE_PLUGIN)
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
