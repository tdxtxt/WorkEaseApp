package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * 文件名： MyScrollView
 * 功能：
 * 作者： wanny
 * 时间： 13:53 2017/4/20
 */
public class MyScrollView extends ScrollView {
    public static int widthScreen = 0;
    public static int heightScreen = 0;
    boolean c;
    boolean d;
    float xpiex;
    float ypiex;
    Controller controller;
    ScrollViewListener scrollViewListener;
    int i;

    public MyScrollView(Context paramContext) {
        super(paramContext);
        setHeightInteral(paramContext);
    }

    public MyScrollView(Context paramContext, AttributeSet paramAttributeSet) {
        super(paramContext, paramAttributeSet);
        setHeightInteral(paramContext);
    }

    private void setHeightInteral(Context paramContext) {
        setScreenWidth(paramContext);
        this.i = ((int) (0.014063F * widthScreen));
    }

    private void setScreenWidth(Context paramContext) {
        if ((paramContext.getResources() != null) && (paramContext.getResources().getDisplayMetrics() != null)) {
            widthScreen = getResources().getDisplayMetrics().widthPixels;
            heightScreen = getResources().getDisplayMetrics().heightPixels;
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                this.xpiex = ev.getX();
                this.ypiex = ev.getY();
                break;
            case MotionEvent.ACTION_MOVE:

                float f1 = ev.getX();
                float f2 = ev.getY();
                //获取当前的头部view的高度
                int j = getChildAt(0).getMeasuredHeight();
                //获取已经滚动的距离
                int k = getScrollY();
                //湖区整个view的高度；
                int m = getHeight();
                //滚动事件如果说
                if ((this.d) || ((Math.abs(this.xpiex - f1) > 0.7D * this.i) && (k + m >= j) && (f2 - this.ypiex < 0.7D * this.i))) {
                    this.d = true;
                requestDisallowInterceptTouchEvent(true);
                return super.dispatchTouchEvent(ev);
            }
//                if ((this.ypiex < f2) && (f2 - this.ypiex > this.i) && (Math.abs(this.xpiex - f1) < 1.2D * this.i)) {
//                }
                for (this.c = true; ; this.c = false) {
                    this.xpiex = f1;
                    this.ypiex = f2;
                    if ((k + m != j) || (this.c != true)) {
                        break;
                    }
                    if ((this.controller == null) || (!this.controller.canScrollUp())) {
                        break;
                    }
                    requestDisallowInterceptTouchEvent(false);
                    break;
                }
                requestDisallowInterceptTouchEvent(true);
                break;
            case MotionEvent.ACTION_UP:

                break;

            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


//    //    //对于事件的分发
//    public boolean dispatchTouchEvent(MotionEvent paramMotionEvent) {
//        switch (paramMotionEvent.getAction()) {
//
//        }
//        for (; ; ) {
////            return super.dispatchTouchEvent(paramMotionEvent);
//            this.xpiex = paramMotionEvent.getX();
//            this.ypiex = paramMotionEvent.getY();
////            continue;
//            float f1 = paramMotionEvent.getX();
//            float f2 = paramMotionEvent.getY();
//            int j = getChildAt(0).getMeasuredHeight();
//            int k = getScrollY();
//            int m = getHeight();
//            if ((this.d) || ((Math.abs(this.xpiex - f1) > 0.7D * this.i) && (k + m >= j) && (f2 - this.ypiex < 0.7D * this.i))) {
//                this.d = true;
//                requestDisallowInterceptTouchEvent(true);
//                return super.dispatchTouchEvent(paramMotionEvent);
//            }
//            if ((this.ypiex < f2) && (f2 - this.ypiex > this.i) && (Math.abs(this.xpiex - f1) < 1.2D * this.i)) {
//            }
//            for (this.c = true; ; this.c = false) {
//                this.xpiex = f1;
//                this.ypiex = f2;
//                if ((k + m != j) || (this.c != true)) {
//                    break;
//                }
//                if ((this.controller == null) || (!this.controller.canScrollUp())) {
//                    break;
//                }
//                requestDisallowInterceptTouchEvent(false);
//                break;
//            }
//            requestDisallowInterceptTouchEvent(true);
//            continue;
////            if (k + m >= j) {
//////                requestDisallowInterceptTouchEvent(true);
//////                continue;
//////                this.d = false;
////            }
//        }
//    }

    protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
        super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        if (this.scrollViewListener != null) {
            this.scrollViewListener.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
        }
    }

    public void setController(Controller parama) {
        this.controller = parama;
    }

    public void setonScrollViewListener(ScrollViewListener paramb) {
        this.scrollViewListener = paramb;
    }

    public interface Controller {
        boolean canScrollUp();
    }

    public interface ScrollViewListener {
        void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
    }
}
