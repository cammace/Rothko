import com.android.build.gradle.AppPlugin
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.DynamicFeaturePlugin
import com.android.build.gradle.LibraryPlugin
import com.android.build.gradle.TestPlugin
import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class CodeQualityPlugin : Plugin<Project> {
    override fun apply(project: Project) {

        project.allprojects {
            afterEvaluate {
                addSpotless()
                addLint()
            }
        }
    }
}

private fun Project.addLint() {
    val lintOptions = if (isAndroidProject()) {
        extensions.getByType(BaseExtension::class.java).lintOptions
    } else null

    lintOptions?.apply {
        lintConfig = file("$rootDir/config/lint/lint.xml")
        baselineFile = file("$rootDir/config/lint/lint-baseline.xml")

        isIgnoreWarnings = false
        isWarningsAsErrors = true
        isCheckTestSources = true
        isCheckDependencies = false
    }
}

private fun Project.addSpotless() {
    plugins.apply(SpotlessPlugin::class.java)

    configure<SpotlessExtension> {
        kotlin {
            target("**/*.kt")
            ktlint(Versions.CodeQuality.KTLINT).userData(mapOf("max_line_length" to "120"))
        }

        kotlinGradle {
            target("**/*.gradle.kts")
            ktlint(Versions.CodeQuality.KTLINT).userData(mapOf("max_line_length" to "120"))
        }
    }
}

/**
 * Determines whether the given project is Android.
 */
private fun Project.isAndroidProject(): Boolean {
    val isAndroidLibrary = plugins.hasPlugin(LibraryPlugin::class.java)
    val isAndroidApp = plugins.hasPlugin(AppPlugin::class.java)
    val isAndroidTest = plugins.hasPlugin(TestPlugin::class.java)
    val isAndroidFeature = plugins.hasPlugin(DynamicFeaturePlugin::class.java)
    return isAndroidLibrary || isAndroidApp || isAndroidTest || isAndroidFeature
}
