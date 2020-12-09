package com.example.textquest;

// https://github.com/Jamshid-M/WinterLayout

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.Random;

public class Snow {

    int parentWidth;
    int parentHeight;
    private Bitmap bitmap;
    int minAmplitude;
    int maxAmplitude;
    int minSpeed;
    int maxSpeed;
    int minSize;
    int maxSize;

    private Random random;

    private float positionX = 0f;                                      //position of snowflake on X coordinate
    private float positionY = 0f;                                      //position of snowflake on Y coordinate
    private int range;          //range for amplitude
    private int speedY;            //speed on Y coordinate
    private int speedX;         //speed on X coordinate
    private float startingOffset;                 //for initializing starting point of snowflake
    private float amplitude;         // amplitude for sin function, depends on range field
    private int horizontalOffset;  //horizontal offset, for keeping snowflakes on screen
    private int degree = 0;                                          //degree for sin function
    private int size;          //size of snow
    private Paint paint;
    private boolean stopped = false;
    private boolean destroyed = false;
//    private var callback: (()-> Unit)?= null
    private Context context;

    public Snow(int parentWidth, int parentHeight, Bitmap bitmap, int minAmplitude, int maxAmplitude, int minSpeed, int maxSpeed, int minSize, int maxSize, Context context) {
        this.parentWidth = parentWidth;
        this.parentHeight = parentHeight;
        this.minAmplitude = minAmplitude;
        this.maxAmplitude = maxAmplitude;
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.minSize = minSize;
        this.maxSize = maxSize;

        random = new Random();

        range = random.nextInt(maxAmplitude + 1 - minAmplitude) + minAmplitude;          //range for amplitude
        speedY = random.nextInt(maxSpeed + 1 - minSpeed) + minSpeed;            //speed on Y coordinate
        speedX = random.nextInt(65 + 1 - 45) + 45;         //speed on X coordinat
        startingOffset = random.nextFloat();                 //for initializing starting point of snowflake
        amplitude = parentWidth * range/100;         // amplitude for sin function, depends on range field
        horizontalOffset = random.nextInt(7 + 1 - 4) + 4;  //horizontal offset, for keeping snowflakes on screen
        size = random.nextInt(maxSize + 1 - minSize) + minSize;          //size of snow
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);

        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.FILL);
        positionY = (-(random.nextInt(parentHeight + 1 - 1) + 1));
        positionX = parentWidth/2f;
        this.context = context;
        int inImage = random.nextInt(3 + 1 - 1) + 1;
        if(inImage == 1){
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.snow_1);
        }
        else if (inImage == 2) {
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.snow_2);
        }
        else {
            this.bitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.snow_3);
        }
        if(this.bitmap!=null) {
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, size, size, false);
        }
    }

    public void draw(Canvas canvas){
        if(!destroyed && isOnScreen()) {
            if (bitmap != null) {
                canvas.drawBitmap(bitmap, positionX, positionY, paint);
            }
            else {
                canvas.drawCircle(positionX, positionY, size, paint);
            }
        }
    }

    private boolean isOnScreen() {
        return positionY > 0 && positionY < parentHeight;
    }

    public void update(){
        if(destroyed) {
            return;
        }
        double radians = (Math.PI / amplitude) * degree;
        double sin = Math.sin(radians);
        degree++;

        positionX = (float) (sin * parentWidth/ horizontalOffset * speedX/100 + parentWidth*startingOffset);
        positionY += speedY;

        if(positionY-size > parentHeight) {
            reset();
        }
    }

//    private void stop(Unit callback (() -> Unit)){
//        stopped = true;
//        this.callback = callback
//    }

    private void reset(){
        if(stopped) {
            destroyed = true;
//            callback?.invoke()
        }
        positionY = (-size);
        speedY = random.nextInt(maxSpeed + 1 - minSpeed) + minSpeed;
        speedX = random.nextInt(65 + 1 - 45) + 45;
        startingOffset = random.nextFloat();
        amplitude = parentWidth * range / 100;
        horizontalOffset = random.nextInt(7 + 1 - 4) + 4;
        size = random.nextInt(maxSize - 1 + minSize) + minSize;
        if (bitmap != null) {
            bitmap = Bitmap.createScaledBitmap(bitmap, size, size, false);
        }

    }

    public void restart(){
        reset();
        positionY = (-random.nextInt(parentHeight + 1 - 1) + 1);
        positionX = parentWidth/2f;
    }

    public void start() {
        stopped = false;
//        callback = null
        destroyed = false;
    }
}
