/**
 * Libraries configurations
 */
object Libraries {

    /**
     * Core library configurations
     */
    object Core {

        /*
        *   Android SDK properties
        */
        object Sdk {

            //Build tool version
            const val BUILD_TOOLS_VERSION = AndroidSdk.BUILD_TOOLS_VERSION

            // Min sdk support
            const val MIN_API = AndroidSdk.MIN_API

            // Current target version
            const val TARGET_API = AndroidSdk.TARGET_API

            // Compile SDK version
            const val COMPILE_VERSION = AndroidSdk.COMPILE_VERSION
        }

        object Version : BuildVersion(
            major = 0,
            minor = 1,
            patch = 0,
            build = 0,
            buildText = BETA_BUILD
        )


    }

    /**
     * Permission library configurations
     */
    object Permission {

        /*
        *   Android SDK properties
        */
        object Sdk {

            //Build tool version
            const val BUILD_TOOLS_VERSION = AndroidSdk.BUILD_TOOLS_VERSION

            // Min sdk support
            const val MIN_API = AndroidSdk.MIN_API

            // Current target version
            const val TARGET_API = AndroidSdk.TARGET_API

            // Compile SDK version
            const val COMPILE_VERSION = AndroidSdk.COMPILE_VERSION
        }

        object Version : BuildVersion(
            major = 0,
            minor = 1,
            patch = 0,
            build = 0,
            buildText = BETA_BUILD
        )


    }

    /**
     * Media library configurations
     */
    object Media {

        /*
        *   Android SDK properties
        */
        object Sdk {

            //Build tool version
            const val BUILD_TOOLS_VERSION = AndroidSdk.BUILD_TOOLS_VERSION

            // Min sdk support
            const val MIN_API = AndroidSdk.MIN_API

            // Current target version
            const val TARGET_API = AndroidSdk.TARGET_API

            // Compile SDK version
            const val COMPILE_VERSION = AndroidSdk.COMPILE_VERSION
        }

        object Version : BuildVersion(
            major = 0,
            minor = 1,
            patch = 0,
            build = 0,
            buildText = BETA_BUILD
        )


    }


    /**
     * Networking library configurations
     */
    object Networking {

        /*
        *   Android SDK properties
        */
        object Sdk {

            //Build tool version
            const val BUILD_TOOLS_VERSION = AndroidSdk.BUILD_TOOLS_VERSION

            // Min sdk support
            const val MIN_API = AndroidSdk.MIN_API

            // Current target version
            const val TARGET_API = AndroidSdk.TARGET_API

            // Compile SDK version
            const val COMPILE_VERSION = AndroidSdk.COMPILE_VERSION
        }

        object Version : BuildVersion(
            major = 0,
            minor = 1,
            patch = 0,
            build = 0,
            buildText = BETA_BUILD
        )


    }

}