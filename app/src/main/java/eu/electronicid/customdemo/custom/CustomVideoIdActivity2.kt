package eu.electronicid.customdemo.custom

import eu.electronicid.customdemo.custom.notification.CustomNotification
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import eu.electronicid.sdk.videoid.VideoIDActivity

class CustomVideoIdActivity2 : VideoIDActivity() {

    override fun getCustomMultimediaNotification(): CustomFragment = CustomNotification.newInstance()

//    override fun getCustomFrontMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomBackMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomFaceMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

//    override fun getCustomFeedbackMultimediaNotification(): CustomFragment = CustomFeedbackNotification.newInstance()
}