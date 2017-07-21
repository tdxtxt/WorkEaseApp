package com.wanny.workease.system.workease_business.customer.main_mvp;

import android.text.TextUtils;

import com.wanny.workease.system.framework_care.OrdinalResultEntity;
import com.wanny.workease.system.framework_mvpbasic.BasePresenter;
import com.wanny.workease.system.framework_net.rxjava.ApiCallback;
import com.wanny.workease.system.framework_net.rxjava.SubscribCallBack;
import com.wanny.workease.system.workease_business.login_mvp.LoginResult;

/**
 * 文件名： MainPresenter
 * 功能：  首页列表
 * 作者： wanny
 * 时间： 17:25 2017/7/10
 */
public class MainPresenter extends BasePresenter<MainImpl> {


    public MainPresenter(MainImpl view){
        attachView(view);
    }

    public void getWorkData(int pageNumber , final String loading) {
        //执行网络请求的回调
        if(!TextUtils.isEmpty(loading)){
            mvpView.loadIng(loading);
        }
        addSubscription(apiStores.getWorkResult(pageNumber),new SubscribCallBack<>(new ApiCallback<WorkResult>() {
            @Override
            public void onSuccess(WorkResult model) {
                if(!TextUtils.isEmpty(loading)){
                    mvpView.hide();
                }
                mvpView.success(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                mvpView.hide();
            }
            @Override
            public void onCompleted() {

            }
        }));
    }

}
