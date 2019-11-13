package com.example.phonetool;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

/**
 * 这个类是验证生长树形图的，因为树形图不生长 所以建了这个类 看看TreeView是哪里不正
 */
public class CustomeView extends View {

    private Paint mPaint;
    public CustomeView(Context context) {
        this(context,null);
    }

    public CustomeView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.RED);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(getWidth()/2,0,getWidth()/2,200,mPaint);
        canvas.drawCircle(getWidth()/2,200,50,mPaint);
        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(5f);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(60f);
        paint.setUnderlineText(true);
        paint.setStrikeThruText(true);
        paint.setAntiAlias(true);
        canvas.setDensity(4);
        canvas.drawText("this is just a test TextView",getWidth()/2,300,paint);
    }
}
