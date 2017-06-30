package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 文件名： TabViewPager
 * 功能：
 * 作者： wanny
 * 时间： 15:08 2017/4/20
 */
public class TabViewPager extends ViewPager {
    private boolean isCanScroll = false;

    public TabViewPager(Context context) {
        super(context);
    }

    public TabViewPager(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
    }


   //设置是否拦截该事件
    public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent) {
        if (this.isCanScroll) {
            return super.onInterceptTouchEvent(paramMotionEvent);
        }
        return false;
    }
    //设置touch事件自己处理还是留给子view
    public boolean onTouchEvent(MotionEvent paramMotionEvent) {
        if (this.isCanScroll) {
            return super.onTouchEvent(paramMotionEvent);
        }
        return false;
    }

    public void scrollTo(int paramInt1, int paramInt2) {
        super.scrollTo(paramInt1, paramInt2);
    }

    public void setScanScroll(boolean paramBoolean) {
        this.isCanScroll = paramBoolean;
    }
}
