package easygautam.sample

import android.Manifest
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import easygautam.permission.logger.eg_d
import easygautam.permission.requestPermission
import kotlinx.android.synthetic.main.activity_sample.*


class SampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sample)

        btnRequestPermission.setOnClickListener {


            requestPermission(Manifest.permission.ACCESS_FINE_LOCATION, {

                eg_d("Permission granted")

            }, { // it will be true if required to educate
                eg_d("Permission denied, Required to educate $educate")

                if (educate) {
                    Toast.makeText(
                        this@SampleActivity,
                        "Location permission required",
                        Toast.LENGTH_SHORT
                    ).show()
                    Handler(Looper.getMainLooper()).postDelayed({ request() }, 2000)
                }


                educate  // True id educating to user and false if not educating to user
            })
        }


    }


}