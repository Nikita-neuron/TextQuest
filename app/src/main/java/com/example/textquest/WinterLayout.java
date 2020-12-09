package com.example.textquest;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class WinterLayout extends FrameLayout {

    private Paint paint = new Paint();
    private ArrayList<Snow> snows;
    private ValueAnimator animator;
    private int minAmplitude = 40;
    private int maxAmplitude = 50;
    private int minSpeed = 3;
    private int maxSpeed = 7;
    private int minSize = 20;
    private int maxSize = 30;
    private Bitmap bitmap;
    private boolean paused = true;
    private int snowCount = 100;
    private boolean stopInProcess;
    private Context context;

    public WinterLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        setWillNotDraw(false);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.WinterLayout);
        snowCount = a.getInt(R.styleable.WinterLayout_snowCount, 100);
        minAmplitude = a.getInt(R.styleable.WinterLayout_minAmplitude, 40);
        maxAmplitude = a.getInt(R.styleable.WinterLayout_maxAmplitude, 50);
        minSpeed = a.getInt(R.styleable.WinterLayout_minSpeed, 3);
        maxSpeed = a.getInt(R.styleable.WinterLayout_maxSpeed, 7);
        minSize = a.getInt(R.styleable.WinterLayout_minSize, 20);
        maxSize = a.getInt(R.styleable.WinterLayout_maxSize, 30);
//        Drawable drawable =  a.getDrawable(R.styleable.WinterLayout_snowImage);
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_snowflake);
//        bitmap = ((BitmapDrawable)bitmapDrawable).getBitmap();
//        bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
//        bitmap = null;
//        bitmap = new Bitmap.createBitmap(R.drawable.ic_snowflake);
//        bitmap = Bitmap.createBitmap(R.drawable);
        snows = new ArrayList<Snow>(snowCount);
        this.context = context;

        a.recycle();
    }

    public void onDrawForeground(Canvas canvas) {
        super.onDrawForeground(canvas);

        if(!paused) {
            for (int i = 0; i < snows.size(); i++) {
                snows.get(i).update();
                snows.get(i).draw(canvas);
            }
        }
    }
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        for (int i = 0; i <= snowCount; i++) {
            snows.add(new Snow(getWidth(), getHeight(), bitmap, minAmplitude, maxAmplitude,
                    minSpeed, maxSpeed, minSize, maxSize, context));
        }
    }

    public void startWinter(){
        for (int i = 0; i < snows.size(); i++) {
            snows.get(i).start();
        }

        stopInProcess = false;

//        if(animator.isRunning()) {
//            return;
//        }


        animator = ValueAnimator.ofFloat(0f, 360f);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        animator.setRepeatCount(-1);
        animator.start();
        paused = false;
    }

    public void stopWinter(){
        if(stopInProcess) {
            return;
        }
        stopInProcess = true;
        int size = 0;
//        for (int i = 0; i < snows.size(); i++) {
//            snows.get(i).stop {
//                size++;
//                if(size == snowCount) {
//                    animator.cancel();
//                    paused = true;
//                    stopInProcess = false;
//                    snows.forEach{
//                        it.restart()
//                    }
//                }
//            }
//        }
    }

    public void stopImmediately(){
        animator.cancel();
        paused = true;
        invalidate();
        animator = null;
        for (int i = 0; i < snows.size(); i++) {
            snows.get(i).restart();
        }
    }

    public void setSnowSize(int size, Bitmap bitmap, int minAmplitude, int maxAmplitude,
                    int minSpeed, int maxSpeed, int minSize, int maxSize){
        snows.clear();
        snowCount = size;

        this.bitmap = bitmap;
        this.minAmplitude = minAmplitude;
        this.maxAmplitude = maxAmplitude;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.minSize = minSize;
        this.maxSize = maxSize;
    }
}
