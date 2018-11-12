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

    private enum class TypeCustomView { STYLE, CUSTOM_1, CUSTOM_2 }

    private var typeCustomView = TypeCustomView.CUSTOM_2

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
                putExtra(VideoActivity.INTENT_ENVIRONMENT, Environment(endpoint, "S1T14mx3TGGKvTyzBO4gcAChAMHHYdmS1DGSinJczehAGeZTYB64fsC8yu0kwi5r4jBLMBlb_AkXNV4SUZd5wIIkQzqnSKjPJAyhHBwsCxY="))
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
