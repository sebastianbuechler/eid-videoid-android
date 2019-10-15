//package eu.electronicid.customdemo.sdklite.custom.notification
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.bumptech.glide.Glide
//import eu.electronicid.customdemo.R
//import eu.electronicid.customdemo.sdk.custom.notification.CustomAudioCaptchaNotification
//import eu.electronicid.sdklite.video.ui.fragment.CustomFragment
//import kotlinx.android.synthetic.main.fragment_custom_audio_captcha.*
//
//class CustomAudioCaptchaNotification : CustomFragment() {
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        return inflater.inflate(R.layout.fragment_custom_audio_captcha, container, false)
//    }
//
//    override fun onActivityCreated(savedInstanceState: Bundle?) {
//        super.onActivityCreated(savedInstanceState)
//
//        Glide.with(this).load(imageURL).into(image_audio_captcha)
//
//        button_audio_captcha.setOnClickListener {
//            finish()
//        }
//    }
//
//    companion object {
//        @JvmStatic
//        fun newInstance() = CustomAudioCaptchaNotification()
//    }
//}