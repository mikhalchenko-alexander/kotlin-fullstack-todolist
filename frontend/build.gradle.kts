plugins {
    val kotlinVersion = "1.3.40"
    
    id("org.jetbrains.kotlin.js") version kotlinVersion
}

group = "com.anahoret."
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-js"))
    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
kotlin.target.browser { }
