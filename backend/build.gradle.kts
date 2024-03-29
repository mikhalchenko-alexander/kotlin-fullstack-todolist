import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlinxHtmlVersion = "0.6.12"

plugins {
    val kotlinVersion = "1.3.40"
    val springBootVersion = "2.1.6.RELEASE"

    id("org.springframework.boot") version springBootVersion
    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.kapt") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.noarg") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.jpa") version kotlinVersion
}

apply(plugin = "io.spring.dependency-management")

group = "com.anahoret."
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    // Web
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:$kotlinxHtmlVersion")

    // Development
    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    kapt("org.springframework.boot:spring-boot-configuration-processor")
    compileOnly("org.springframework.boot:spring-boot-configuration-processor")

    testCompile("junit", "junit", "4.12")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    processResources {
        dependsOn(":frontend:browserWebpack")
        from(project(":frontend").projectDir.resolve("src/main/resources")) {
            into("static")
        }
        from(project(":frontend").buildDir.resolve("libs/mp-todolist-frontend.js"))  {
            into("static")
        }
    }
}
