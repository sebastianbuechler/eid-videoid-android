package eu.electronicid.customdemo.sdk.custom

import eu.electronicid.customdemo.sdk.custom.notification.CustomNotification
import eu.electronicid.sdk.videoid.VideoIDActivity
import eu.electronicid.sdklite.video.ui.fragment.CustomFragment

class CustomVideoIdActivity2 : VideoIDActivity() {

    override fun getCustomMultimediaNotification(): CustomFragment = CustomNotification.newInstance()

//    override fun getCustomFrontMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomBackMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomFaceMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

//    override fun getCustomCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

//    override fun getCustomFeedbackMultimediaNotification(): CustomFragment = CustomFeedbackNotification.newInstance()
}