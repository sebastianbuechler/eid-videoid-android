package eu.electronicid.customdemo.sdk.custom

import eu.electronicid.customdemo.sdk.custom.notification.*
import eu.electronicid.sdk.videoid.VideoIDActivity
import eu.electronicid.sdklite.video.ui.fragment.CustomFragment

class CustomVideoIdActivity : VideoIDActivity() {

//    override fun getCustomMultimediaNotification(): CustomFragment = CustomNotification.newInstance()

    override fun getCustomFrontMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

    override fun getCustomBackMultimediaNotification(): CustomFragment = CustomBackNotification.newInstance()

    override fun getCustomFaceMultimediaNotification(): CustomFragment = CustomFaceNotification.newInstance()

    override fun getCustomHologramMultimediaNotification(): CustomFragment = CustomHologramNotification.newInstance()

    override fun getCustomCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

    override fun getCustomAudioCaptchaMultimediaNotification(): CustomFragment = CustomAudioCaptchaNotification.newInstance()

    override fun getCustomFeedbackMultimediaNotification(): CustomFragment = CustomFeedbackNotification.newInstance()
}