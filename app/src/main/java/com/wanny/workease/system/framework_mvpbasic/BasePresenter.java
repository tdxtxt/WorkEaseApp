package com.wanny.workease.system.framework_mvpbasic;

import com.wanny.workease.system.framework_net.retrofit.ApiStores;
import com.wanny.workease.system.framework_net.retrofit.AppClient;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
/**
 * 文件名： BasePresenter
 * 功能：  presenter实现和View层的关联。
 * 作者： wanny
 * 时间： 15:50 2016/8/5
 */
public class BasePresenter<V> implements Presenter<V> {

    public V mvpView;
    public ApiStores apiStores = AppClient.retrofit().create(ApiStores.class);
//    public ApiStores apiStores;
    private CompositeSubscription mCompositeSubscription;
//    private AppClient appClient;

    @Override
    public void attachView(V mvpView) {
//        appClient = new AppClient();
        this.mvpView = mvpView;
    }
    @Override
    public void detachView() {
        this.mvpView = null;
        onUnsubscribe();
    }

    //RXjava取消注册，以避免内存泄露
    public void onUnsubscribe() {
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
        }
    }
   //设值值
//    public void setValue(Object object , String method){
//        appClient.setValue(object,method);
//        apiStores = appClient.retrofit().create(ApiStores.class);
//    }


    //执行这个方法钱先执行对象的出事啊
    public void addSubscription(Observable observable, Subscriber subscriber) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }
}
