package eu.electronicid.customdemo.sdk

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eu.electronicid.customdemo.R
import eu.electronicid.customdemo.sdk.custom.CustomVideoIdActivity
import eu.electronicid.customdemo.sdk.custom.CustomVideoIdActivity2
import eu.electronicid.sdk.videoid.VideoIDActivity
import eu.electronicid.sdklite.video.config.Environment
import kotlinx.android.synthetic.main.activity_main.*
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1
    private val endpoint = URL("https://etrust-sandbox.electronicid.eu/v2/")

    private enum class TypeCustomView { STYLE, CUSTOM_1, CUSTOM_2 }

    private var typeCustomView = TypeCustomView.STYLE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start_sample.setOnClickListener {
            startActivityForResult(Intent(this,
                    when (typeCustomView) {
                        TypeCustomView.STYLE -> VideoIDActivity::class.java
                        TypeCustomView.CUSTOM_1 -> CustomVideoIdActivity::class.java
                        TypeCustomView.CUSTOM_2 -> CustomVideoIdActivity2::class.java
                    }
            ).apply {
                putExtra(VideoIDActivity.INTENT_ENVIRONMENT, Environment(endpoint, "qVbRbvE-tLhr9zEqKIwN8j3jb6aY4auoqfGw_Mzp9i5yPgE7jBVz4UKbnQEkVhDq59CTSj_L4YQ6cS6ZKOH9YK9S-nOsSqE3DE5h8YJCXo0="))
                putExtra(VideoIDActivity.INTENT_LANGUAGE, "en")
                putExtra(VideoIDActivity.INTENT_DOCUMENT_TYPE, 62)
            }, REQUEST_CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                data?.run {
                    val videoId = getStringExtra(VideoIDActivity.INTENT_RESULT_OK)

                    Toast.makeText(this@MainActivity, "Video OK: $videoId", Toast.LENGTH_SHORT).show()
                }
            } else if (resultCode == Activity.RESULT_CANCELED) {
                data?.run {
                    val errorId = getStringExtra(VideoIDActivity.INTENT_RESULT_ERROR_CODE)
                    val errorMsg = getStringExtra(VideoIDActivity.INTENT_RESULT_ERROR_MESSAGE)

                    Toast.makeText(this@MainActivity, "Video ERROR id: $errorId, msg: $errorMsg", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
