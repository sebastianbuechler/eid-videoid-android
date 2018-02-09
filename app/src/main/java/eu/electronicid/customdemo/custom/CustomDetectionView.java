package eu.electronicid.customdemo.custom;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 */
public class CustomDetectionView extends View {

    private final Paint paint;
    private Path path;

    public CustomDetectionView(Context context, AttributeSet attrs) {
        super(context, attrs);

        paint = new Paint(Paint.DITHER_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(6);
        paint.setColor(0xFF2287BB);
        paint.setStrokeJoin(Paint.Join.MITER);
    }

    public void showShape(int left, int top, int right, int bottom) {

        path = new Path();
        int cornerWidth = (right - left) / 4;

        path.moveTo(left, top + cornerWidth);
        path.lineTo(left, top);
        path.lineTo(left + cornerWidth, top);

        path.moveTo(right - cornerWidth, top);
        path.lineTo(right, top);
        path.lineTo(right, top + cornerWidth);

        path.moveTo(left, bottom - cornerWidth);
        path.lineTo(left, bottom);
        path.lineTo(left + cornerWidth, bottom);

        path.moveTo(right - cornerWidth, bottom);
        path.lineTo(right, bottom);
        path.lineTo(right, bottom - cornerWidth);

        invalidate();
    }

    public void hideShape() {
        path = null;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (path != null) {
            canvas.drawPath(path, paint);
        }
    }
}
