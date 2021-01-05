/**
 *  Plugin used in this module
 */

plugins {

    // Include android library
    androidLibrary()

    // Include kotlin android
    kotlinAndroid()

    // Include kotlin android extensions
    kotlinAndroidExtensions()

}


/**
 *  Configure the android application build and other properties
 */
android {

    // Compile SDK target
    compileSdkVersion(AndroidSdk.COMPILE_VERSION)

    // Build tool version
    buildToolsVersion(AndroidSdk.BUILD_TOOLS_VERSION)

    /**
     * Application configuration
     */
    defaultConfig {

        // Min SDK support
        minSdkVersion(Libraries.Media.Sdk.MIN_API)

        // Target sdk version
        targetSdkVersion(Libraries.Media.Sdk.TARGET_API)

        // Version code
        versionCode = Libraries.Media.Version.code

        // Version name
        versionName = Libraries.Media.Version.name

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

    buildTypes {
        getByName(Build.Type.Debug) {
            isDebuggable = true
            isMinifyEnabled = false
        }
        getByName(Build.Type.Release) {
            isDebuggable = false
        }
    }

    packagingOptions {
        exclude("META-INF/*")
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

}