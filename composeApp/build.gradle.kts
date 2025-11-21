import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlin.multiplatform)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.multiplatform)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.serialization)
    alias(libs.plugins.google.services)
    alias(libs.plugins.kotlin.cocoapods)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Firebase Services Portfolio KMP"
        version = "1.0"
        homepage = "https://github.com/koke050800/firebase_services_portfolio_KMP"
        ios.deploymentTarget = "16.0"

        framework {
            baseName = "ComposeApp"
            isStatic = true
        }

        pod("FirebaseCore") {
            extraOpts += listOf("-compiler-option", "-fmodules")
        }
    }

    sourceSets {
        androidMain.dependencies {

            // Compose Previews
            implementation(compose.preview)
            implementation(libs.androidx.activity.compose)

            // Dependency Injection (Koin for Android)
            implementation(libs.bundles.koin.android)

            // Firebase Services
            implementation(project.dependencies.platform(libs.firebase.bom))
            implementation(libs.firebase.analytics)

        }

        commonMain.dependencies {
            // Compose Multiplatform
            implementation(compose.runtime)
            implementation(compose.foundation)
            implementation(compose.material3)
            implementation(compose.materialIconsExtended)
            implementation(compose.ui)
            implementation(compose.components.resources)
            implementation(compose.components.uiToolingPreview)

            // Material 3 Adaptive
            implementation(libs.material3.adaptive)
            implementation(libs.material3.adaptive.layout)

            // Navigation Compose
            implementation(libs.jetbrains.compose.navigation)

            // AndroidX Lifecycle (common part)
            implementation(libs.bundles.androidx.lifecycle)

            // Dependency Injection (Koin common)
            implementation(libs.bundles.koin.common)

            // Utils
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.coil.compose)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
    }
}

android {
    namespace = "koke050800.firebaseservices.portfoliokmp"
    compileSdk = libs.versions.android.compileSdk.get().toInt()

    defaultConfig {
        applicationId = "koke050800.firebaseservices.portfoliokmp"
        minSdk = libs.versions.android.minSdk.get().toInt()
        targetSdk = libs.versions.android.targetSdk.get().toInt()
        versionCode = 1
        versionName = "1.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
}

dependencies {
    debugImplementation(compose.uiTooling)
}





