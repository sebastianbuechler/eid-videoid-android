package eu.electronicid.customdemo.sdk.custom

import androidx.fragment.app.Fragment
import eu.electronicid.customdemo.sdk.custom.notification.CustomWaitingAgentFragment
import eu.electronicid.sdk.videoid.VideoIDActivity

class CustomVideoIdActivity3: VideoIDActivity() {
    override fun customWaitingAgentNotification(): Fragment = CustomWaitingAgentFragment.newInstance()
}