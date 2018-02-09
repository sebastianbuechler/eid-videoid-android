package eu.electronicid.customdemo.custom;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.github.lguipeng.library.animcheckbox.AnimCheckBox;

import eu.electronicid.customdemo.R;
import eu.electronicid.sdk.videoid.contract.dto.domain.Quad;

/**
 * Custom view class.
 */
public class CustomUIView extends ConstraintLayout {

    private View roiView;
    private AnimCheckBox checkBox;
    private TextView startingTextView;
    private TextView notificationView;
    private CustomDetectionView faceDetectionView;
    private View interphaseView;
    private TextView interphaseText;
    private Button interphaseButton;
    private int roiDetectedColor;
    private int roiNotDetectedColor;
    private int notificationInfoColor;
    private int notificationWarningColor;

    final Handler handler = new Handler();

    public CustomUIView(Context context) {
        super(context);
        init();
    }

    public CustomUIView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CustomUIView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() { //AttributeSet attrs, int defStyle) {

        inflate(getContext(), R.layout.custom_uiview, this);

        roiView = findViewById(R.id.roiView);
        faceDetectionView = findViewById(R.id.faceDetectionView);
        checkBox = findViewById(R.id.checkbox);
        notificationView = findViewById(R.id.notificationLabel);
        startingTextView = findViewById(R.id.startingTextView);

        interphaseView = findViewById(R.id.customInterphase);
        interphaseText = findViewById(R.id.textInterphaseName);
        interphaseButton = findViewById(R.id.buttonInterphase);

        roiDetectedColor = ContextCompat.getColor(getContext(), R.color.roiDetectedColor);
        roiNotDetectedColor = ContextCompat.getColor(getContext(), R.color.roiNotDetectedColor);

        notificationInfoColor = ContextCompat.getColor(getContext(), R.color.colorCustomNotification);
        notificationWarningColor = ContextCompat.getColor(getContext(), R.color.colorNotification);
    }

    public void showStartingMessage() {
        Animation animation = new AlphaAnimation(0.0f, 1.0f);
        animation.setDuration(500);
        animation.setStartOffset(250);
        animation.setRepeatMode(Animation.REVERSE);
        animation.setRepeatCount(Animation.INFINITE);
        startingTextView.startAnimation(animation);
        startingTextView.setVisibility(VISIBLE);
    }

    public void hideStartingMessage() {
        startingTextView.clearAnimation();
        startingTextView.setVisibility(INVISIBLE);
    }

    public void initRoi(Quad quad) {
        roiView.getLayoutParams().width = quad.getWidth();
        roiView.getLayoutParams().height = quad.getHeight();
        roiView.requestLayout();
    }

    public void showRoi() {
        showDocumentDetection(false);
        roiView.setVisibility(VISIBLE);
    }

    public void hideRoi() {
        roiView.setVisibility(INVISIBLE);
        notificationView.setVisibility(INVISIBLE);
    }

    public void showInterphase(String name, Runnable runnable) {
        interphaseText.setText(name);
        interphaseView.setVisibility(VISIBLE);

        interphaseButton.setOnClickListener((view) -> {
            interphaseView.setVisibility(INVISIBLE);
            runnable.run();
        });
    }

    public void showTick(Runnable runnable) {

        checkBox.setVisibility(VISIBLE);
        checkBox.setChecked(true, true);

        handler.postDelayed(() -> {
            checkBox.setVisibility(INVISIBLE);
            checkBox.setChecked(false);
            runnable.run();
        }, 2000);
    }

    public void showDocumentDetection(boolean succeeded) {
        GradientDrawable drawable = (GradientDrawable) roiView.getBackground();
        if (succeeded) {
            drawable.setColor(roiDetectedColor);
            drawable.setStroke(4, ColorUtils.setAlphaComponent(roiDetectedColor, 200));
        } else {
            drawable.setColor(roiNotDetectedColor);
            drawable.setStroke(0, Color.TRANSPARENT);
        }
    }

    public void showFaceDetection(Quad quad) {
        if (quad != null) {
            faceDetectionView.showShape(quad.getP1().getX(), quad.getP1().getY(), quad.getP3().getX(), quad.getP3().getY());
        } else {
            faceDetectionView.hideShape();
        }
    }

    public void hideFaceDetection() {
        faceDetectionView.hideShape();
    }

    public void showNotificationInfo(String message) {
        notificationView.setText(message);
        notificationView.setBackgroundColor(notificationInfoColor);
        if (notificationView.getVisibility() != VISIBLE) {
            notificationView.setVisibility(VISIBLE);
        }
    }

    public void showNotificationWarning(String message) {
        notificationView.setText(message);
        notificationView.setBackgroundColor(notificationWarningColor);
        if (notificationView.getVisibility() != VISIBLE) {
            notificationView.setVisibility(VISIBLE);
        }
    }

}
