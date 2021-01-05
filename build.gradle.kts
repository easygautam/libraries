// This is top level build file, all configuration options common for all will be here

/**
 * All the required build scripts to build the project
 */
buildscript {

    // All the source repositories we are using
    repositories {

        // Provide access the google repositories
        google()
        // Provide access jcenter repositories
        jcenter()

    }

    /**
     * Dependencies to be used in the project
     */
    dependencies {

        // Android gradle support
        classpath(Build.Classpath.ANDROID_GRADLE)

        // Kotlin gradle support
        classpath(Build.Classpath.KOTLIN_GRADLE_PLUGIN)

    }
}

/**
 * Common setup for all projects
 */
allprojects {

    // Repository source location for all the projects
    repositories {

        // Google repositories source
        google()

        // Jcenter repositories source
        jcenter()

    }

}

/**
 * Clean the build dir on clean task perform
 */
tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}