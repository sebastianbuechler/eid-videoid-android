//package eu.electronicid.customdemo.sdklite
//
//import android.app.Activity
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import eu.electronicid.customdemo.R
//import eu.electronicid.customdemo.sdklite.custom.CustomVideoIdActivity
//import eu.electronicid.customdemo.sdklite.custom.CustomVideoIdActivity2
//import eu.electronicid.sdklite.video.config.Environment
//import eu.electronicid.sdklite.videoid.VideoIDLiteActivity
//import kotlinx.android.synthetic.main.activity_main.*
//import java.net.URL
//
//class MainActivity : AppCompatActivity() {
//
//    private val REQUEST_CODE = 1
//    private val endpoint = URL("https://etrust-sandbox.electronicid.eu/v2/")
//
//    private enum class TypeCustomView { STYLE, CUSTOM_1, CUSTOM_2 }
//
//    private var typeCustomView = TypeCustomView.STYLE
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        button_start_sample.setOnClickListener {
//            startActivityForResult(Intent(this,
//                    when (typeCustomView) {
//                        TypeCustomView.STYLE -> VideoIDLiteActivity::class.java
//                        TypeCustomView.CUSTOM_1 -> CustomVideoIdActivity::class.java
//                        TypeCustomView.CUSTOM_2 -> CustomVideoIdActivity2::class.java
//                    }
//            ).apply {
//                putExtra(VideoIDLiteActivity.INTENT_ENVIRONMENT, Environment(endpoint, "{AUTHORIZATION}"))
//                putExtra(VideoIDLiteActivity.INTENT_LANGUAGE, "en")
//                putExtra(VideoIDLiteActivity.INTENT_DOCUMENT_TYPE, 62)
//            }, REQUEST_CODE)
//        }
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == REQUEST_CODE) {
//            if (resultCode == Activity.RESULT_OK) {
//                data?.run {
//                    val videoId = getStringExtra(VideoIDLiteActivity.INTENT_RESULT_OK)
//
//                    Toast.makeText(this@MainActivity, "Video OK: $videoId", Toast.LENGTH_SHORT).show()
//                }
//            } else if (resultCode == Activity.RESULT_CANCELED) {
//                data?.run {
//                    val errorId = getStringExtra(VideoIDLiteActivity.INTENT_RESULT_ERROR_CODE)
//                    val errorMsg = getStringExtra(VideoIDLiteActivity.INTENT_RESULT_ERROR_MESSAGE)
//
//                    Toast.makeText(this@MainActivity, "Video ERROR id: $errorId, msg: $errorMsg", Toast.LENGTH_SHORT).show()
//                }
//            }
//        }
//    }
//}
