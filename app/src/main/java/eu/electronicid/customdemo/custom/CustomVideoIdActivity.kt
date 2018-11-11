package eu.electronicid.customdemo.custom

import eu.electronicid.customdemo.custom.notification.*
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import eu.electronicid.sdk.videoid.VideoIDActivity

class CustomVideoIdActivity : VideoIDActivity() {

//    override fun getCustomMultimediaNotification(): CustomFragment = CustomNotification.newInstance()

    override fun getCustomFrontMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

    override fun getCustomBackMultimediaNotification(): CustomFragment = CustomBackNotification.newInstance()

    override fun getCustomFaceMultimediaNotification(): CustomFragment = CustomFaceNotification.newInstance()

    override fun getCustomHologramMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

    override fun getCustomCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

    override fun getCustomAudioCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

    override fun getCustomFeedbackMultimediaNotification(): CustomFragment = CustomFeedbackNotification.newInstance()
}