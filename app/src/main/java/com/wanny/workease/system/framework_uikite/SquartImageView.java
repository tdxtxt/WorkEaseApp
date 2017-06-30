package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * 类名： ${type_name}
 * 工鞥： 正方形的图片展示
 * 作者： wanny
 * 时间：${date} ${time}
 */

public class SquartImageView extends AppCompatImageView {

    public SquartImageView(Context context) {
        super(context);
    }

    public SquartImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquartImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    //设置为正方形
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(getDefaultSize(0, widthMeasureSpec), getDefaultSize(0, heightMeasureSpec));
        int childWidthSize = getMeasuredWidth();
        heightMeasureSpec = widthMeasureSpec = MeasureSpec.makeMeasureSpec(childWidthSize, MeasureSpec.EXACTLY);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
