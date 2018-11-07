package eu.electronicid.customdemo.custom.notification

import android.os.Bundle
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import eu.electronicid.customdemo.R
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import kotlinx.android.synthetic.main.fragment_custom_captcha.*

class CustomCaptchaNotification : CustomFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_custom_captcha, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        edit_text_captcha.inputType = when (inputType) {
            a.TEXT -> InputType.TYPE_CLASS_TEXT
            a.NUMBER -> InputType.TYPE_CLASS_NUMBER
            else -> InputType.TYPE_CLASS_TEXT
        }

        Glide.with(this).load(imageURL).into(image_captcha)

        button_captcha.setOnClickListener {
            val captcha = edit_text_captcha.text.toString()
            setAckData(captcha)
            finish()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CustomCaptchaNotification()
    }
}