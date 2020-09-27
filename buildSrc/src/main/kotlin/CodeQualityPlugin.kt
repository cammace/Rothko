import com.diffplug.gradle.spotless.SpotlessExtension
import com.diffplug.gradle.spotless.SpotlessPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class CodeQualityPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.afterEvaluate {
            addSpotless()
        }
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
