plugins {
    kotlin("js") version "1.3.41"
}

repositories {
    mavenCentral()
}

kotlin {
    target {
        useCommonJs()
        browser()
    }

    sourceSets {
        main {
            dependencies {
                implementation(kotlin("stdlib-js"))
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.2.2")

                implementation(npm("core-js", "3.2.1"))
                implementation(npm("kotlinx-html", "0.6.12"))
                implementation(npm("@jetbrains/kotlin-react", "16.9.0-pre.82"))
                implementation(npm("@jetbrains/kotlin-react-dom", "16.9.0-pre.82"))
                implementation(npm("@jetbrains/kotlin-extensions", "1.0.1-pre.82"))
                implementation(npm("react", "16.9.0"))
                implementation(npm("react-dom", "16.9.0"))
            }
        }
    }
}
