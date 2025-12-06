plugins {
    id("fabric-loom") version "1.14-SNAPSHOT" apply false
    id("com.replaymod.preprocess") version "c2041a3"
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
    val mc121011 = createNode("1.21.11-rc2", 12111, "yarn")
    val mc121010 = createNode("1.21.10", 12110, "yarn")
    val mc12108 = createNode("1.21.8", 12108, "yarn")
    val mc12106 = createNode("1.21.6", 12106, "yarn")
    val mc12105 = createNode("1.21.5", 12105, "yarn")
    val mc12104 = createNode("1.21.4", 12104, "yarn")
    val mc12101 = createNode("1.21.1", 12101, "yarn")
    val mc12100 = createNode("1.21", 12100, "yarn")
    val mc12006 = createNode("1.20.6", 12006, "yarn")
    val mc12004 = createNode("1.20.4", 12004, "yarn")
    val mc12001 = createNode("1.20.1", 12001, "yarn")
    val mc11904 = createNode("1.19.4", 11904, "yarn")

    mc121011.link(mc121010)
    mc121010.link(mc12108)
    mc12108.link(mc12106)
    mc12106.link(mc12105)
    mc12105.link(mc12104)
    mc12104.link(mc12101)
    mc12101.link(mc12100)
    mc12100.link(mc12006)
    mc12006.link(mc12004)
    mc12004.link(mc12001)
    mc12001.link(mc11904)
}