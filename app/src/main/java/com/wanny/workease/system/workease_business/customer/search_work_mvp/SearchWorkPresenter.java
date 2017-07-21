package com.wanny.workease.system.workease_business.customer.search_work_mvp;

import android.text.TextUtils;

import com.wanny.workease.system.framework_mvpbasic.BasePresenter;
import com.wanny.workease.system.framework_net.rxjava.ApiCallback;
import com.wanny.workease.system.framework_net.rxjava.SubscribCallBack;
import com.wanny.workease.system.workease_business.customer.main_mvp.WorkResult;
import com.wanny.workease.system.workease_business.customer.register_mvp.CityResult;
import com.wanny.workease.system.workease_business.customer.register_mvp.WorkTypeResult;

/**
 * 文件名： SearchWorkPresenter
 * 功能：
 * 作者： wanny
 * 时间： 16:07 2017/7/21
 */
public class SearchWorkPresenter  extends BasePresenter<SearchWorkImpl>{

    public SearchWorkPresenter(SearchWorkImpl view){
        attachView(view);
    }

    public void getWorkByAreaIdAndrWorkType(String areaId , String typeId,int pageNumber , final String loading) {
        //执行网络请求的回调
        if(!TextUtils.isEmpty(loading)){
            mvpView.loadIng(loading);
        }
        addSubscription(apiStores.getWorkByAreaId(areaId,typeId,pageNumber),new SubscribCallBack<>(new ApiCallback<WorkResult>() {
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



    public void getWorkType() {
        //执行网络请求的回调
        addSubscription(apiStores.getWorkType(), new SubscribCallBack<>(new ApiCallback<WorkTypeResult>() {
            @Override
            public void onSuccess(WorkTypeResult model) {
                mvpView.workType(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                if (code == 103) {
                    mvpView.fail("103");
                }
            }

            @Override
            public void onCompleted() {

            }
        }));
    }




    public void getCityValue() {
        //执行网络请求的回调
        addSubscription(apiStores.getCity(), new SubscribCallBack<>(new ApiCallback<CityResult>() {
            @Override
            public void onSuccess(CityResult model) {
                mvpView.getCityValue(model);
            }

            @Override
            public void onFailure(int code, String msg) {
                if (code == 103) {
                    mvpView.fail("103");
                }
            }

            @Override
            public void onCompleted() {

            }
        }));
    }

}
