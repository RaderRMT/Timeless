pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()

        maven("https://jitpack.io")
        maven("https://maven.fabricmc.net")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.replaymod.preprocess" -> {
                    useModule("com.github.replaymod:preprocessor:${requested.version}")
                }
            }
        }
    }
}

rootProject.name = "timeless-mod"
rootProject.buildFileName = "root.gradle.kts"

listOf(
        "1.19.4",
        "1.20.1",
        "1.20.4",
        "1.20.6",
        "1.21",
        "1.21.1",
        "1.21.4",
        "1.21.5",
        "1.21.6",
        "1.21.8",
        "1.21.10",
        "1.21.11-rc3",
).forEach { version ->
    include(":$version")
    project(":$version").apply {
        projectDir = file("versions/$version")
        buildFileName = "../../build.gradle"
        name = version
    }
}