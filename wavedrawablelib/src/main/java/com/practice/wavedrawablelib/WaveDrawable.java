package com.practice.wavedrawablelib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;

import java.util.Random;

/**
 * Created by zhuyakun on 2017/9/28.
 */

public class WaveDrawable extends Drawable {
    Paint paint;
    Random random;
    float p;
    Handler mainHandler;
    Path curve1;
    Path curve2;
    Path curve3;

    public WaveDrawable() {
        mainHandler = new Handler(Looper.getMainLooper());
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setDither(true);
        paint.setColor(0xAAFFFFFF);
        paint.setStyle(Paint.Style.FILL);
        random = new Random();
        p = 3.14f;
        curve1 = new Path();
        curve2 = new Path();
        curve3 = new Path();
    }

    @Override
    public void draw(Canvas canvas) {
        Rect rect = getBounds();
        generateCurve(50, 0.008f, p, rect.height() * 2 / 3, curve1);
        canvas.drawPath(curve1, paint);
        generateCurve(50, 0.008f, 2.5f * p, rect.height() * 2 / 3, curve2);
        canvas.drawPath(curve2, paint);
        generateCurve(50, 0.008f, 3.5f * p, rect.height() * 2 / 3, curve3);
        canvas.drawPath(curve3, paint);
        p += 0.01f;
        mainHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                invalidateSelf();
            }
        }, 33);
    }

    public void generateCurve(float a, float w, float p, float h, Path path) {
        int width = getBounds().width();
        int height = getBounds().height();
        path.reset();
        path.moveTo(0, height);
        double y;
        for (int x = 0; x <= width; ++x) {
            if (x % 10 == 0) {
                y = a * Math.sin(w * x + p) + h;
                path.lineTo(x, (float) y);
            }
        }
        path.lineTo(width, height);
        path.close();
    }

    @Override
    public void setAlpha(int i) {

    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {

    }

    @Override
    public int getOpacity() {
        return PixelFormat.OPAQUE;
    }
}
