package easygautam.permission

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat.*
import androidx.core.content.ContextCompat
import easygautam.permission.logger.EGLog
import easygautam.permission.logger.eg_d

/**
 * Implementation of android runtime permission.
 * This class delegate the [OnRequestPermissionsResultCallback] to inherit the activity object.
 *
 */
internal class RuntimePermissionHelper constructor(private val mActivity: AppCompatActivity) {

    companion object {

        // Permission request code
        private const val REQUEST_CODE = 1

    }

    fun checkAndRequest(
        permission: String,
        grantedCallback: GrantedCallback,
        notGrantedCallback: NotGrantedCallback
    ) {

        eg_d("Permission grant process started $permission")

        // Permission granted
        if (permission.isGranted()) {
            grantedCallback()
            eg_d("Permission granted $permission")
        }

        // Permission denied, check if should show education UI
        else {

            // return true if showing education UI, false if no need to show education UI
            // Continue to request for permission

            val denied = object : Denied {
                override val educate: Boolean
                    get() = permission.shouldEducate()

                override fun request() {
                    arrayOf(permission).request()
                }
            }

            val showingEducationUi = notGrantedCallback(denied)

            // Request permission if not showing education UI
            if (showingEducationUi) {
                eg_d("Should educate user $permission")
            } else {
                eg_d("No need to educate user requesting permission $permission")
                arrayOf(permission).request()
            }

        }

    }

    private fun String.isGranted() =
        ContextCompat.checkSelfPermission(mActivity, this) == PackageManager.PERMISSION_GRANTED

    private fun String.isNotGranted() =
        ContextCompat.checkSelfPermission(mActivity, this) == PackageManager.PERMISSION_DENIED

    private fun String.shouldEducate() =
        shouldShowRequestPermissionRationale(mActivity, this)

    private fun Array<String>.request() =
        requestPermissions(mActivity, this, REQUEST_CODE)

}