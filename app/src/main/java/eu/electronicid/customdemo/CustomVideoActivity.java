package eu.electronicid.customdemo;

import android.os.Bundle;
import android.widget.FrameLayout;

import eu.electronicid.customdemo.custom.CustomUIView;
import eu.electronicid.sdk.videoid.contract.control.Phase;
import eu.electronicid.sdk.videoid.contract.dto.domain.Quad;
import eu.electronicid.sdk.videoid.ui.NotificationLevel;
import eu.electronicid.sdk.videoid.ui.VideoIDActivity;

public class CustomVideoActivity extends VideoIDActivity {

    private CustomUIView customUIView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FrameLayout layout = (FrameLayout) findViewById(R.id.videoid_main_layout);

        customUIView = new CustomUIView(getBaseContext());
        layout.addView(customUIView);
    }

    @Override
    public void onVideoIDStarting() {
        runOnUiThread(() -> customUIView.showStartingMessage());
    }

    @Override
    public void onVideoIDStarted(Quad roi) {
        runOnUiThread(() -> {
            customUIView.initRoi(roi);
            customUIView.hideStartingMessage();
        });
    }

    @Override
    public void onVideoIDPhaseStarting(final Phase phase, final Runnable runnable) {
        runOnUiThread(() -> customUIView.showInterphase(phase.toString(), runnable));
    }

    @Override
    public void onVideoIDPhaseStarted(Phase phase) {
        if(phase != Phase.FACE) {
            runOnUiThread(() -> customUIView.showRoi());
        }
    }

    @Override
    public void onVideoIDPhaseFinished(final Phase phase, final Runnable runnable) {
        runOnUiThread(() -> {
            if(phase == Phase.FACE) {
                customUIView.hideFaceDetection();
            } else {
                customUIView.hideRoi();
            }
            customUIView.showTick(runnable);
        });
    }

    @Override
    public void onVideoIDDetection(Phase phase, Quad coordinates) {
        runOnUiThread(() -> {
            if(phase == Phase.FACE) {
                customUIView.showFaceDetection(coordinates);
            } else {
                customUIView.showDocumentDetection(coordinates != null);
            }
        });
    }

    @Override
    public void onVideoIDNotification(String code, String message, NotificationLevel level) {
        runOnUiThread(() -> {
            if(level == NotificationLevel.INFO) {
                customUIView.showNotificationInfo(message);
            } else {
                customUIView.showNotificationWarning(message);
            }
        });
    }
}
