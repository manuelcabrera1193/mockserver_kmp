import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    alias(libs.plugins.kotlin.serialization)
}

kotlin {

    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "ComposeApp"
            isStatic = true
        }
    }
    
    sourceSets {
        androidMain.dependencies {
            implementation(libs.ktor.server.netty)
        }
        commonMain.dependencies {
            implementation(libs.ktor.server.core)
            implementation(libs.ktor.server.content.negotiation)
            implementation(libs.ktor.serialization.kotlinx.json)
        }
        iosMain.dependencies {
            implementation(libs.ktor.server.cio)
        }
    }

}

android {
    compileSdk = 34
    namespace = "org.example.mockserver"
    defaultConfig {
        minSdk = 21
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}