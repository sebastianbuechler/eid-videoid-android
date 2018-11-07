package eu.electronicid.customdemo.custom

import eu.electronicid.customdemo.custom.notification.CustomCaptchaNotification
import eu.electronicid.customdemo.custom.notification.CustomFeedbackNotification
import eu.electronicid.customdemo.custom.notification.CustomFrontNotification
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import eu.electronicid.sdk.videoid.VideoIDActivity

class CustomVideoIdActivity : VideoIDActivity() {
    override fun getCustomFrontMultimediaNotification(): CustomFragment = CustomFrontNotification.newInstance()

    override fun getCustomCaptchaMultimediaNotification(): CustomFragment = CustomCaptchaNotification.newInstance()

    override fun getCustomFeedbackMultimediaNotification(): CustomFragment = CustomFeedbackNotification.newInstance()
}