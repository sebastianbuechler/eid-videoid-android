package eu.electronicid.customdemo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.LinearLayout;
import android.widget.Toast;

import eu.electronicid.sdk.videoid.contract.control.Phase;
import eu.electronicid.sdk.videoid.ui.VideoIDActivity;

public class VideoActivity extends VideoIDActivity {

    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // we could include some views in this layout
        layout = (LinearLayout) findViewById(R.id.videoid_central_layout);
    }

    @Override
    public void onVideoIDPhaseStarting(final Phase phase, final Runnable runnable) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(VideoActivity.this, R.style.full_screen_dialog).setCancelable(false).setTitle("Phase: " + phase.name())
                        .setMessage("phase starting").setNeutralButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        runnable.run();
                    }

                }).show();
            }
        });
    }

    @Override
    public void onVideoIDPhaseFinished(final Phase phase, final Runnable runnable) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                new AlertDialog.Builder(VideoActivity.this, R.style.full_screen_dialog).setCancelable(false).setTitle("Phase: " + phase.name())
                        .setMessage("phase finished").setNeutralButton("OK", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int id) {
                        runnable.run();
                    }

                }).show();
            }
        });
    }

    @Override
    public void onVideoIDNotification(String code, String message) {

        final String text = message.replace("\n", "");
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(VideoActivity.this, text, Toast.LENGTH_LONG).show();
            }
        });
    }
}
