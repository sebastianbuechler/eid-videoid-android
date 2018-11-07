package eu.electronicid.customdemo.custom.notification

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import eu.electronicid.customdemo.R
import eu.electronicid.sdk.video.ui.fragment.CustomFragment
import kotlinx.android.synthetic.main.fragment_custom_feedback.*

class CustomFeedbackNotification : CustomFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_custom_feedback, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        button_feedback.setOnClickListener { finish() }
    }

    companion object {
        @JvmStatic
        fun newInstance() = CustomFeedbackNotification()
    }
}