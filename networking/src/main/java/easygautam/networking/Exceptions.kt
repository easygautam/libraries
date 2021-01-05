package easygautam.networking

import java.io.IOException

class NetworkConnectivityException : IOException() {
    override val message: String = "No internet connection"
}


