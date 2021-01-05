/**
 *  Plugin used in this module
 */

plugins {

    // Include android application
    androidApp()

    // Include kotlin android
    kotlinAndroid()

    // Include kotlin android extensions
    kotlinAndroidExtensions()

}

/**
 *  Configure the android application build and other properties
 */

android {

    // Key store
    val keystoreProperties = Keystore()

    // Compile SDK target
    compileSdkVersion(AndroidSdk.COMPILE_VERSION)

    // Build tool version
    buildToolsVersion(AndroidSdk.BUILD_TOOLS_VERSION)

    /**
     * Application configuration
     */
    defaultConfig {

        // Application ID for sample application
        applicationId = Application.Sample.APPLICATION_ID

        // Min SDK support
        minSdkVersion(AndroidSdk.MIN_API)

        // Target sdk version
        targetSdkVersion(AndroidSdk.TARGET_API)

        // Version code
        versionCode = Version.code

        // Version name
        versionName = Version.name

        // Instrumentation test runner
        testInstrumentationRunner = InstrumentationTest.RUNNER

    }

    /**
     * Application compile options
     */
    compileOptions {

        // Source compatibility java version
        sourceCompatibility = JavaVersion.VERSION_1_8

        // Target compatibility java version
        targetCompatibility = JavaVersion.VERSION_1_8

    }

    /**
     * Kotlin compatibility configuration
     */
    kotlinOptions {

        // JVM target
        jvmTarget = JavaVersion.VERSION_1_8.toString()

        // Compile argument
        freeCompilerArgs = listOf("-Xallow-result-return-type")

    }

    /**
     * Signing configurations
     */
    signingConfigs {

        create(Build.Type.Release) {
            storeFile = File(keystoreProperties.storeFile)
            storePassword = keystoreProperties.storePassword
            keyAlias = keystoreProperties.keyAlias
            keyPassword = keystoreProperties.keyPassword
        }
    }

    buildTypes {
        getByName(Build.Type.Debug) {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName(Build.Type.Release) {
            isDebuggable = false
            isMinifyEnabled = true
            isShrinkResources = true
            if (keystoreProperties.isAutoSigning) {
                signingConfig = signingConfigs.getByName(Build.Type.Release)
            }
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }

    packagingOptions {
        exclude("META-INF/*")
    }

    buildFeatures {
        dataBinding = true
    }

}


dependencies {

    // Include by default all the jar file from libs folder
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Kotlin standard libraries
    implementation(Dependency.Kotlin.stdlib)
    implementation(Dependency.Kotlin.stdlibJdk)

    // Android support libraries
    implementation(Dependency.Android.appCompat)

    // Easygautam permission
    implementation(project(":permission"))

    // Easygautam Core
    implementation(project(":core"))

}