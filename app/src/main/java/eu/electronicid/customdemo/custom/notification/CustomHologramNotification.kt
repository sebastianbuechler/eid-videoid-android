package eu.electronicid.customdemo.custom.notification

import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.electronicid.customdemo.R
import eu.electronicid.sdk.video.ui.fragment.CustomFragment

class CustomHologramNotification : CustomFragment() {

    private val handler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_custom_hologram, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        handler.postDelayed({ finish() }, 5000)
    }

    override fun onDestroy() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance() = CustomHologramNotification()
    }
}