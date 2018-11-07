package eu.electronicid.customdemo

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import eu.electronicid.sdk.video.config.Environment
import eu.electronicid.sdk.video.ui.VideoActivity
import eu.electronicid.sdk.videoid.VideoIDActivity
import java.net.URL

class MainActivity : AppCompatActivity() {

    private val REQUEST_CODE = 1
    private val endpoint = URL("https://etrust-sandbox.electronicid.eu/v2/")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivityForResult(Intent(this, VideoIDActivity::class.java).apply {
            putExtra(VideoActivity.INTENT_ENVIRONMENT, Environment(endpoint, "ajDQRmBsqYYJy1ygOgrVaBYuZTrVWEMtqolPHGL1PCIbTXx3Y7vOuA7S2yZfTAVZa66szbcff2BP-76ZueoFBTOmB-3b-f6vqzPtsXe9Cx0="))
            putExtra(VideoActivity.INTENT_LANGUAGE, "es")
            putExtra(VideoIDActivity.INTENT_DOCUMENT_TYPE, 62)
        }, REQUEST_CODE)
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
