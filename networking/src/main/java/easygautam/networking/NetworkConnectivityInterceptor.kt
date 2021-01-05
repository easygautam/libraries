package easygautam.networking

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class NetworkConnectivityInterceptor(private val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!isConnected()) throw NetworkConnectivityException()

        val builder: Request.Builder = chain.request().newBuilder()
        return chain.proceed(builder.build())
    }

    @SuppressLint("MissingPermission")
    private fun isConnected(): Boolean =
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            isConnectedAbove23()
        } else {
            isConnectedBellow23()
        }

    @RequiresApi(Build.VERSION_CODES.M)
    @SuppressLint("MissingPermission")
    private fun isConnectedAbove23(): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        val networkCapabilities =
            connectivityManager?.getNetworkCapabilities(connectivityManager.activeNetwork)
        return (
                networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) == true ||
                        networkCapabilities?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) == true
                )
    }


    @SuppressLint("MissingPermission")
    private fun isConnectedBellow23(): Boolean {

        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?

        val activeNetwork = connectivityManager?.activeNetworkInfo
        return (
                activeNetwork?.type == ConnectivityManager.TYPE_WIFI ||
                        activeNetwork?.type == ConnectivityManager.TYPE_MOBILE
                )

    }


}