package com.example.phonetool;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;

import java.util.LinkedList;

public class Branch {
    // 形状 （三个控制点）
    private PointF[] cp = new PointF[3];
    // 粗细
    private float radius;
    // 长度
    private int maxLength;
    private int currentLength;
    private float part; // 一根树枝每一次绘制的长度
    // 颜色
    public static int branchColor = Color.CYAN;
    // 分枝
    LinkedList<Branch> childList;
    // 绘制方法
    private float growX, growY;

    public Branch(int data[]) {
        cp[0] = new PointF(data[2], data[3]);
        cp[1] = new PointF(data[4], data[5]);
        cp[2] = new PointF(data[6], data[7]);
        radius = data[8];
        maxLength = data[9];
        part = 1f / maxLength;

    }

    /**
     * 添加树枝枝杈
     * @param branch
     */
    public void addChild(Branch branch) {
        if (childList == null) {
            childList = new LinkedList<>();
        }
        childList.add(branch);
    }

    /**
     *  生长方法
     * @param canvas
     * @param paint
     * @param scalFactor 缩放比例
     * @return
     */
    public boolean grow(Canvas canvas, Paint paint, int scalFactor) {
        if (currentLength < maxLength) {
            // 计算当前绘制点的位置
            bezier(part * currentLength);
            // 绘制
            draw(canvas, paint, scalFactor);
            currentLength++;
            radius *= 0.97f;
            return true;
        } else {
            return false;
        }
    }

    /**
     * 贝瑟尔曲线公式
     * @param t
     */
    private void bezier(float t) {
        float c0 = (1 - t) * (1 - t);
        float c1 = 2 * t * (1 - t);
        float c2 = t * t;
        growX = c0 * cp[0].x + c1 * cp[1].x + c2 * cp[2].x;
        growY = c0 * cp[0].y + c1 * cp[1].y + c2 * cp[2].y;

    }

    private void draw(Canvas canvas, Paint paint, int scalFactor) {
        paint.setColor(branchColor);
        canvas.save();
        canvas.scale(scalFactor, scalFactor);
        canvas.drawCircle(growX, growY, radius, paint);
        canvas.restore(); // 不会影响后面的内容
    }


}
