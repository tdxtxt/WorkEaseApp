package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * 类名：  @MyListView.java
 * 作者：  wanny
 * 功能：  设置listview不显示滚动条。
 * 时间：  2014年8月22日 上午10:29:36
 */
public class ScrollViewAndListView extends ListView {
	//private boolean haveScrollbar = true;

	public ScrollViewAndListView(Context context) {
		super(context);
	}

	public ScrollViewAndListView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public ScrollViewAndListView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	/**
	 * 设置是否有ScrollBar，当要在ScollView中显示时，应当设置为false。 默认为 true
	 * 
	 */
//	public void setHaveScrollbar(boolean haveScrollbar) {
//		this.haveScrollbar = haveScrollbar;
//	}
	
//	@Override
//	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//		if(haveScrollbar == false){
//			int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
//					MeasureSpec.AT_MOST);
//			super.onMeasure(widthMeasureSpec, expandSpec);
//		}else{
//			super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//		}
//	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
			int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
					MeasureSpec.AT_MOST);
			super.onMeasure(widthMeasureSpec, expandSpec);
	}
}
