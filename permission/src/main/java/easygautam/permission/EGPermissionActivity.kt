package easygautam.permission

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

/**
 * A transparent activity.
 * Handle all the user interaction things
 *
 */
internal class EGPermissionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // Make activity not touchable
        window.addFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE)

        super.onCreate(savedInstanceState)


        EGPermission.onActivityStarted(this)

    }


    override fun onDestroy() {
        super.onDestroy()

        EGPermission.onActivityEnd()
    }

}