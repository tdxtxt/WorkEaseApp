package com.wanny.workease.system.framework_uikite;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

import com.wanny.workease.system.framework_basicutils.LogUtil;


/**
 * 文件名： CanScrollView
 * 功能：
 * 作者： wanny
 * 时间： 10:00 2017/1/25
 */
public class CanScrollView extends View {

   //构建这个功能就是要先想好构思。
    //让整个画板实现滚动的效果
    //滚动分为上滚和下滚
    public static final float SPEED_NORMAL = 3.0f;

    private Rect rect = new Rect();
    //图片资源
    private Bitmap bitmap;
    //状态
    private boolean isScrolling = false;
    //默认的滚动速度
    private float mSpeed = SPEED_NORMAL;
    private float offset = 0;//记录刚开始的位置
    public CanScrollView(Context context) {
        super(context);
    }

    public CanScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CanScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @TargetApi(Build.VERSION_CODES.LOLLIPOP )
    public CanScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setBitmap(int sourcesId){
        bitmap = BitmapFactory.decodeResource(getResources(),sourcesId );
    }

    /**
     * 设置bitmap
     */
    public void setBitmap(){
//        this.setBitmap(R.mipmap.splash);
    }

    //要铺满整个屏幕
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(canvas == null){
            return;
        }
        if(bitmap == null || bitmap.isRecycled()){
            return;
        }
        //设定这个canvas的边界
        canvas.getClipBounds(rect);
        //
        LogUtil.log("rect.width",rect.width() + "");
        LogUtil.log("rect.height",rect.height() + "");
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        while (offset <= - height) {
            offset += height;
        }
        //竖直滑动的效果
        float top = offset;
        while (top < rect.height()) {
            //竖直滚动
            canvas.drawBitmap(bitmap, 0, getBitmapTop(width, top), null);
//            canvas.drawBitmap(bitmap, 0, 250, null);
            top += height;
        }
        if(isScrolling && mSpeed != 0){
            offset -= Math.abs(mSpeed);
            postInvalidateOnAnimation();
        }
    }
    //一定要是铺满整个屏幕

//要计算出屏幕的宽度

    //通过速度的正反来定义滚动的位置.意味着是上滚还是下滚
    private float getBitmapTop(int height , float top){
        //什么情况下这个值会发生变化
        if(mSpeed < 0){
            LogUtil.log(rect.height() + "");
            LogUtil.log("height===",height + "");
            LogUtil.log("top ==",top +"");
            LogUtil.log("当前的滚动位置==",(rect.height() - height - top )+ "");
            return rect.height() - height - top;
        }else{
            return top;
        }
    }

   //开始执行移动操作
   @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void start() {
        if (!isScrolling) {
            isScrolling = true;
            postInvalidateOnAnimation();
        }
    }

    public void stop(){
        isScrolling = false;
        invalidate();
    }
    //结合画布和对应的数据逻辑，实现自己想要的效果。


}
