package eu.electronicid.customdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.net.MalformedURLException;
import java.net.URL;

import eu.electronicid.sdk.videoid.config.Environment;
import eu.electronicid.sdk.videoid.contract.dto.domain.Process;
import eu.electronicid.sdk.videoid.contract.dto.domain.SimilarityLevel;
import eu.electronicid.sdk.videoid.ui.VideoIDActivity;

public class MainActivity extends AppCompatActivity {

    private static final int VIDEOID_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    final URL eidEndpoint = new URL("https://etrust-sandbox.electronicid.eu/v2");

                    Intent intent = new Intent(MainActivity.this, VideoActivity.class);
                    intent.putExtra(VideoIDActivity.INTENT_ENVIRONMENT, new Environment(eidEndpoint, "---insert_bearer_token---"));
                    intent.putExtra(VideoIDActivity.INTENT_DOCUMENT_TYPE, 62);
                    intent.putExtra(VideoIDActivity.INTENT_MIN_SIMILARITY, SimilarityLevel.Low);
                    intent.putExtra(VideoIDActivity.INTENT_VIDEO_MODE, Process.Unattended);
                    intent.putExtra(VideoIDActivity.INTENT_RAUTHORITY_ID, "---insert_rauthority_id---");
                    startActivityForResult(intent, VIDEOID_REQUEST_CODE);

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == VIDEOID_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                final String videoId = data.getStringExtra(VideoIDActivity.INTENT_RESULT_OK);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, "Video OK: " + videoId, Toast.LENGTH_SHORT).show();
                    }
                });

            } else if (resultCode == RESULT_CANCELED) {

                if (data != null) {

                    final String errorId = data.getStringExtra(VideoIDActivity.INTENT_RESULT_ERROR_CODE);
                    final String errorMsg = data.getStringExtra(VideoIDActivity.INTENT_RESULT_ERROR_MESSAGE);

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this, "Video ERROR id: " + errorId + ", msg: " + errorMsg, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
            }
        }
    }
}
