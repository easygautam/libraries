object Dependency {

    object Android {

        private const val APP_COMPAT_VERSION = "1.2.0"

        const val appCompat = "androidx.appcompat:appcompat:$APP_COMPAT_VERSION"

    }


    object Kotlin {

        private const val version = Build.KOTLIN_VERSION
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        const val stdlibJdk = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:$version"

    }

    object Retrofit {
        private const val version = "2.9.0"
        private const val loggingInterceptorVersion = "4.9.0"

        const val retrofit = "com.squareup.retrofit2:retrofit:$version"
        const val gsonConverter = "com.squareup.retrofit2:converter-gson:$version"
        const val loggingInterceptor =
            "com.squareup.okhttp3:logging-interceptor:$loggingInterceptorVersion"
    }

}