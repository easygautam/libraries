package easygautam.permission.logger

import android.util.Log

object EGLog {

    var LOGGING_ENABLE = true

}

inline fun <reified T> T.eg_d(m: String) {
    if (EGLog.LOGGING_ENABLE)
        Log.d(T::class.java.simpleName, m)
}