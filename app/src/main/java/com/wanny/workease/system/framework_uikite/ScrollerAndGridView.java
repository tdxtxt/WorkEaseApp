package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * 类名 ：ScrollerAndGridView.java
 * 功能 ：解决scrollview嵌套GridView的显示不全的问题
 * 作者 ： wanny
 * 时间 ：2015年7月6日上午9:05:10
 */
public class ScrollerAndGridView extends GridView {
//	private boolean haveScrollbar = true;

	public ScrollerAndGridView(Context context) {
		super(context);

	}

	public ScrollerAndGridView(Context context, AttributeSet attrs) {
		super(context, attrs);

	}

	public ScrollerAndGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

	}

	/**
	 * 设置是否有ScrollBar，当要在ScollView中显示时，应当设置为false。 默认为 true
	 * 
	 */
//	public void setHaveScrollbar(boolean haveScrollbar) {
//		this.haveScrollbar = haveScrollbar;
//	}

	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		// TODO Auto-generated method stub
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);

	}

}
