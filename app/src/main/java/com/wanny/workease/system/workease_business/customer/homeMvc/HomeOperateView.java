package com.wanny.workease.system.workease_business.customer.homeMvc;


import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wanny.workease.system.framework_care.OrdinalResultEntity;
import com.wanny.workease.system.framework_mvpbasic.BaseOperateImp;


/**
 * 文件名： GetTaskView
 * 功能：
 * 作者： wanny
 * 时间： 14:49 2016/9/30
 */
public interface HomeOperateView extends BaseOperateImp<OrdinalResultEntity> {

    void showLoading();
    //返回当前的view;
    AppCompatActivity getActivity();
    //得到当前的tabHost
    FragmentTabHost getTabHost();
    //当前的tabCount;
    int getTabCount();
    //得到当前的Item,
    HiFoFragmentTableItem getTabItem(int tabIndex);
    // 当这个函数返回null的时候，调用默认
    View getTabView(int tabIndex);

}
