plugins {
    id("fabric-loom") version "1.0-SNAPSHOT" apply false
    id("com.replaymod.preprocess") version "48e02ad"
}

subprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        maven("https://libraries.minecraft.net/")
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://github.com/jitsi/jitsi-maven-repository/raw/master/releases/")
        maven("https://maven.fabricmc.net/")
        maven("https://jitpack.io")
    }
}

preprocess {
    val mc12002 = createNode("1.20.2-rc2", 12002, "yarn")
    val mc12001 = createNode("1.20.1", 12001, "yarn")
    val mc11904 = createNode("1.19.4", 11904, "yarn")

    mc12002.link(mc12001)
    mc12001.link(mc11904)
}