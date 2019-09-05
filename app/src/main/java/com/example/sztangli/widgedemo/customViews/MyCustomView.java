package com.example.sztangli.widgedemo.customViews;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.sztangli.widgedemo.R;

/**
 * Created by sztangli on 2018-1-26.
 * 第一个自定义view
 */

public class MyCustomView extends View {

    private Paint mPaint;
    private Bitmap bitmap;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    /**
     * 绘制图形
     *
     * @param canvas 画布
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        //画图
        RectF rectf = new RectF(10, 10, 100, 100);//外切矩形

        //圆
        canvas.drawCircle(200, 200, 50, mPaint);

        //圆弧
        canvas.drawArc(rectf, -10, -160, true, mPaint);

        //矩形
        canvas.drawRect(100, 100, 300, 300, mPaint);

        //点:offet:数组中忽略前几个坐标，count：绘制多少个坐标.(两个坐标为一组表示一个点)

        float points[] = {500, 50, 500, 70, 500, 90, 500, 110, 500, 130, 500, 150, 500, 170, 500,
                190};
        canvas.drawPoint(200, 200, mPaint);
        canvas.drawPoints(points, 2, 14, mPaint);

        //椭圆
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawOval(50, 50, 350, 200, mPaint);
        } else {
            canvas.drawOval(new RectF(100, 100, 300, 200), mPaint);
        }

        //圆角椭圆
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(450, 300, 700, 600, 10, 10, mPaint);
        } else {
            canvas.drawRoundRect(new RectF(450, 300, 700, 600), 10, 20, mPaint);
        }


        //线
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(400, 400, 500, 500, mPaint);
        float[] linePoints = {20, 20, 120, 20, 70, 20, 70, 120, 20, 120, 120, 120, 150, 20, 250,
                20, 150, 20, 150, 120, 250, 20, 250, 120, 150, 120, 250, 120};
        canvas.drawLines(linePoints, mPaint);

        //画自定义图形
        Path path = new Path();
        RectF rect1 = new RectF(200, 200, 400, 400);
        RectF rect2 = new RectF(400, 200, 600, 400);

        //画圆弧foceMoveTo=true表示抬笔从当前位置画过去
        path.addArc(rect1, -225, 225);

        //对于封闭的图形Direction表示绘制该图形的方向CW为顺时针,CCW为逆时针
        //       path.addCircle(100,100,50, Path.Direction.CW);

        /**
         * 设置图形填充模式:
         *  EVEN_ODD 即even-odd rule （奇偶原则）：对于平面中的任意一点，向任意方向射出一条射线，
         *   这条射线和图形相交的次数（相交才算，相切不算哦）如果是奇数，则这个点被认为在图形内部，
         *   是要被涂色的区域；如果是偶数，则这个点被认为在图形外部，是不被涂色的区域。
         *
         *  WINDING即 non-zero winding rule （非零环绕数原则）
         *   以 0 为初始值，对于射线和图形的所有交点，遇到每个顺时针的交点（图形从射线的左边向右穿过）
         *   把结果加 1，遇到每个逆时针的交点（图形从射线的右边向左穿过）把结果减 1，
         *   最终把所有的交点都算上，得到的结果如果不是 0，则认为这个点在图形内部，是要被涂色的区域；
         *   如果是 0，则认为这个点在图形外部，是不被涂色的区域
         */
        //       path.setFillType(Path.FillType.EVEN_ODD);

        //画圆弧foceMoveTo=false表示不抬笔从当前位置画过去
        path.arcTo(rect2, -180, 225, false);

        //从当前位置到指定位置画一条直线
        path.lineTo(400, 542);

        //二次贝塞尔曲线(起点是当前位置,第一个点是控制点，第二个点是终点)
        //      path.quadTo(200,200,300,300);

        //当前位置移动到指定位置
        //     path.moveTo(100,100);


        //它的作用是把当前的子图形封闭，即由当前位置向当前子图形的起点绘制一条直线。
        path.close();


        canvas.drawPath(path, mPaint);

        //绘制bitmap
        canvas.drawBitmap(bitmap, 150, 350, mPaint);

        //绘制文字
        mPaint.setStrokeWidth(1);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("你好",100,350,mPaint);

        //给画板设置背景色,还可以用作给画板设置半透明蒙版
        //canvas.drawARGB(255,100,200,100);
        canvas.drawColor(Color.parseColor("#88880000"));
    }

    /**
     * 设置paint 画笔
     */
    private void initPaint() {
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.dakai);
        mPaint = new Paint();
        //画笔风格:勾边，填充，填充加勾边
        mPaint.setStyle(Paint.Style.STROKE);
        //画笔颜色
        mPaint.setColor(Color.BLUE);
        //如果画笔有勾边，设置勾边线条的宽度
        mPaint.setStrokeWidth(10);
       /*所谓的毛边或者锯齿，发生的原因并不是很多人所想象的「绘制太粗糙」「像素计算能力不足」；
       同样，抗锯齿的原理也并不是选择了更精细的算法来算出了更平滑的图形边缘。
       实质上，锯齿现象的发生，只是由于图形分辨率过低，导致人眼察觉出了画面中的像素颗粒而已。
       换句话说，就算不开启抗锯齿，图形的边缘也已经是最完美的了，而并不是一个粗略计算的粗糙版本。
       那么，为什么抗锯齿开启之后的图形边缘会更加平滑呢？因为抗锯齿的原理是：修改图形边缘处的像素颜色，
       从而让图形在肉眼看来具有更加平滑的感觉
        */
        mPaint.setAntiAlias(true);
        //设置线条端点样式
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        //设置画笔写字大小
        mPaint.setTextSize(26);
    }
}
