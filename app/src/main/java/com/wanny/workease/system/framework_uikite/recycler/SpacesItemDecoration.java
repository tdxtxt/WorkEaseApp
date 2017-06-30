package com.wanny.workease.system.framework_uikite.recycler;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 文件名：com.android.wanny.gift.exchange.giftchange_business.indexmain_mvc.recycler
 * 功能：
 * 创建人：wanny
 * 日期：2017/4/22 下午3:07
 */

public class SpacesItemDecoration  extends RecyclerView.ItemDecoration {

    private int space;

    public SpacesItemDecoration(int space) {
        this.space = space;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = space;
        outRect.right = space;
        outRect.bottom = space;
        if(parent.getChildAdapterPosition(view)==0){
            outRect.top = space;
        }
    }
}

