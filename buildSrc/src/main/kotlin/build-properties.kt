object Application {

    object Sample {
        const val APPLICATION_ID = "easygautam.sample"
    }

}

object Module {


}

/*
*   Android SDK properties
*/
object AndroidSdk {

    //Build tool version
    const val BUILD_TOOLS_VERSION = "30.0.2"

    // Min sdk support
    const val MIN_API = 21

    // Current target version
    const val TARGET_API = 30

    // Compile SDK version
    const val COMPILE_VERSION = 30
}

object Version : BuildVersion()

/**
 * Application version configuration
 *
 */
open class BuildVersion(
    private val major: Int = 0,
    private val minor: Int = 1,
    private val patch: Int = 0,
    private val build: Int = 0,
    private val buildText: String = BETA_BUILD
) {

    companion object {
        const val BETA_BUILD =  "-beta"
        const val ALPHA_BUILD =  "-alpha"
        const val RELEASE_BUILD =  ""
    }

    val code
        get() = major * 10000000 + minor * 100000 + patch * 1000 + build

    val name
        get() = "$major.$minor.${patch}$buildText"

}