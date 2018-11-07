package eu.electronicid.customdemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eu.electronicid.customdemo.custom.CustomVideoIdActivity
import eu.electronicid.customdemo.custom.CustomVideoIdActivity2
import eu.electronicid.sdk.video.config.Environment
import eu.electronicid.sdk.video.ui.VideoActivity
import eu.electronicid.sdk.videoid.VideoIDActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1
    private val endpoint = URL("https://etrust-sandbox.electronicid.eu/v2/")

    private var isCustomVideoIdActivity = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start_sample.setOnClickListener {
            startActivityForResult(Intent(this,
                    if (isCustomVideoIdActivity)
                        CustomVideoIdActivity::class.java
                    else
                        CustomVideoIdActivity2::class.java
            ).apply {
                putExtra(VideoActivity.INTENT_ENVIRONMENT, Environment(endpoint, "i5cNAn4T4M-key59JMyIGQ_UgJhXK6bI2qH8qfvI1rR8o0AEKNhfWYaX5Y5_PsFfuzLQow8t-olmeCqj1YmHxYVOpdRTEoJf5pOn7y86G6U="))
                putExtra(VideoActivity.INTENT_LANGUAGE, "en")
                putExtra(VideoIDActivity.INTENT_DOCUMENT_TYPE, 62)
            }, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.run {
                    val videoId = getStringExtra(VideoActivity.INTENT_RESULT_OK)

                    Toast.makeText(this@MainActivity, "Video OK: $videoId", Toast.LENGTH_SHORT).show()
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                data?.run {
                    val errorId = getStringExtra(VideoActivity.INTENT_RESULT_ERROR_CODE)
                    val errorMsg = getStringExtra(VideoActivity.INTENT_RESULT_ERROR_MESSAGE)

                    Toast.makeText(this@MainActivity, "Video ERROR id: $errorId, msg: $errorMsg", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
