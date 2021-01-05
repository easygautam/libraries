import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

// Android application id
private const val ANDROID_APPLICATION = "com.android.application"

// Android library id
private const val ANDROID_LIBRARY = "com.android.library"

// Kotlin plugins
private const val KOTLIN_ANDROID = "kotlin-android"
private const val KOTLIN_ANDROID_EXTENSIONS = "kotlin-android-extensions"
private const val KOTLIN_KAPT = "kotlin-kapt"

// Android application
fun PluginDependenciesSpec.androidApp(): PluginDependencySpec = id(ANDROID_APPLICATION)

// Android library plugin
fun PluginDependenciesSpec.androidLibrary(): PluginDependencySpec = id(ANDROID_LIBRARY)

// Kotlin android
fun PluginDependenciesSpec.kotlinAndroid(): PluginDependencySpec = id(KOTLIN_ANDROID)

// Kotlin android extensions
fun PluginDependenciesSpec.kotlinAndroidExtensions(): PluginDependencySpec =
    id(KOTLIN_ANDROID_EXTENSIONS)


fun PluginDependenciesSpec.kotlinKapt() {
    // Include kotlin kapt
    id(KOTLIN_KAPT)
}