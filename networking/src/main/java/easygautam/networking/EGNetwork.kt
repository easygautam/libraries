package easygautam.networking

import android.content.Context
import okhttp3.Authenticator
import okhttp3.Interceptor

class EGNetwork(
    private val context: Context,
    override val baseUrl: String
) : EGBaseNetwork() {

    override fun interceptors(): List<Interceptor> = listOf(

        // Network check interceptor
        NetworkConnectivityInterceptor(context)

    )

    // Ignore token refresh, or other authenticator
    override fun authenticator(): Authenticator? = null


}