package eu.electronicid.customdemo.custom.notification

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import eu.electronicid.customdemo.R
import eu.electronicid.sdk.video.contract.control.Phase
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import kotlinx.android.synthetic.main.fragment_custom_captcha.*
import kotlinx.android.synthetic.main.fragment_custom_feedback.*

@Suppress("WHEN_ENUM_CAN_BE_NULL_IN_JAVA")
class CustomNotification : CustomFragment() {

    private val handler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(
                    when (notificationType) {
                        NotificationType.FEEDBACK -> R.layout.fragment_custom_feedback
                        NotificationType.CAPTCHA -> R.layout.fragment_custom_captcha
                        NotificationType.VIEW ->
                            when (phase) {
                                Phase.FRONT -> R.layout.fragment_custom_front
                                Phase.BACK -> R.layout.fragment_custom_back
                                Phase.FACE -> R.layout.fragment_custom_face
                            }
                    }, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        when (notificationType) {
            NotificationType.FEEDBACK -> button_feedback.setOnClickListener { finish() }
            NotificationType.CAPTCHA -> {
                edit_text_captcha.inputType = when (inputType) {
                    InputType.TEXT -> android.text.InputType.TYPE_CLASS_TEXT
                    InputType.NUMBER -> android.text.InputType.TYPE_CLASS_NUMBER
                    else -> android.text.InputType.TYPE_CLASS_TEXT
                }

                Glide.with(this).load(imageURL).into(image_captcha)

                button_captcha.setOnClickListener {
                    val captcha = edit_text_captcha.text.toString()
                    setAckData(captcha)
                    finish()
                }
            }
            NotificationType.VIEW ->
                when (phase) {
                    Phase.FRONT, Phase.BACK, Phase.FACE -> handler.postDelayed({ finish() }, 5000)
                }
        }
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CustomNotification()
    }
}