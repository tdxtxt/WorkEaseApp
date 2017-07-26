package com.wanny.workease.system.workease_business.customer.work_detail;

import com.wanny.workease.system.framework_mvpbasic.BasePresenter;

/**
 * 文件名： WorkDetailPresenter
 * 功能：
 * 作者： wanny
 * 时间： 14:05 2017/7/26
 */
public class WorkDetailPresenter extends BasePresenter<WorkDetailImpl> {

    public WorkDetailPresenter(WorkDetailImpl view){
        attachView(view);
    }

}
