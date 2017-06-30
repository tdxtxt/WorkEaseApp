package com.wanny.workease.system.framework_uikite;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * 类名： ${type_name}
 * 工鞥：
 * 作者： wanny
 * 时间：${date} ${time}
 */

public class SquartTextView extends TextView{

    public SquartTextView(Context context) {
        super(context);
    }

    public SquartTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SquartTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SquartTextView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean isFocused() {
        return true;
    }


}
