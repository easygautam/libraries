package easygautam.permission

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

/**
 * Permissions request use case
 *
 * Check permissions has granted
 *
 *       1. Granted
 *          Send granted callback

 *       2. Not-Granted
 *          Check if required to educate the user
 *          Educate user for the permission
 *          Request permission Single/Multiple
 *          Handle granted / denied status
 *          Return granted / denied callback
 *
 *          If permission denied completely ( will not show permissions )
 *          Send user to application setting
 *          Handle granted / denied status
 *          Return granted / denied callback
 *
 *
 */

fun Context.requestPermission(
    permission: String,
    grantedCallback: GrantedCallback,
    notGrantedCallback: NotGrantedCallback
) {
    EGPermission.with(this)
        .request(permission, grantedCallback, notGrantedCallback)
}

object EGPermission {

    private var mRuntimePermissionHelper: RuntimePermissionHelper? = null

    /**
     * Callback interface used to send permission granted  result
     */
    private var mGrantedCallback: GrantedCallback? = null

    /**
     * Callback interface used to send permission denied  result
     */
    private var mNotGrantedCallback: NotGrantedCallback? = null

    private var mContext: Context? = null

    private var mPermission: String? = null

    internal fun with(context: Context): EGPermission {
        mContext = context
        return this
    }

    internal fun request(
        permission: String,
        grantedCallback: GrantedCallback,
        notGrantedCallback: NotGrantedCallback
    ) {
        this.mPermission = permission

        this.mGrantedCallback = grantedCallback
        this.mNotGrantedCallback = notGrantedCallback

        mContext?.apply {
            startActivity(Intent(this, EGPermissionActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NO_ANIMATION
            })
        }

    }

    internal fun onActivityStarted(activity: AppCompatActivity) {
        this.mRuntimePermissionHelper = RuntimePermissionHelper(activity)
        this.mRuntimePermissionHelper?.checkAndRequest(
            mPermission!!,
            mGrantedCallback!!,
            mNotGrantedCallback!!
        )
    }

    internal fun onActivityEnd() {
        this.mRuntimePermissionHelper = null
        this.mPermission = null
        this.mGrantedCallback = null
        this.mNotGrantedCallback
    }

}

typealias GrantedCallback = () -> Unit
typealias NotGrantedCallback = Denied.() -> Boolean


interface Denied {

    val educate: Boolean

    fun request()

}