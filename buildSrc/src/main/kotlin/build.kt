/**
 * Build configuration details
 */
object Build {

    private const val GRADLE_VERSION = "4.1.1"
    const val KOTLIN_VERSION = "1.4.10"

    /**
     * Plugin used in build file
     */
    object Plugin {


    }

    /**
     * All the classpath dependencies used in the build file
     */
    object Classpath {
        const val ANDROID_GRADLE = "com.android.tools.build:gradle:$GRADLE_VERSION"
        const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:$KOTLIN_VERSION"
    }

    object Type {
        const val Debug = "debug"
        const val Release = "release"
    }

}

