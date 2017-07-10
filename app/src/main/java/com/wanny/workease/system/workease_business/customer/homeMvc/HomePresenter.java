package com.wanny.workease.system.workease_business.customer.homeMvc;


import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;
import com.wanny.workease.system.R;
import com.wanny.workease.system.framework_mvpbasic.BasePresenter;


/**
 * 文件名： GetTaskPresenter
 * 功能：
 * 作者： wanny
 * 时间： 14:49 2016/9/30
 */
public class HomePresenter extends BasePresenter<HomeOperateView> {

    private AppCompatActivity mActivity;
    private LayoutInflater mLayoutInflater;
    private FragmentTabHost mTabHost;
    private int mTabCount;
    //实现view层和model层的分离，业务逻辑和数据更新分离
    public HomePresenter(HomeOperateView view) {
        attachView(view);
    }

    //Presenter 实现加载数据,通过网络请求实现数据的请求
//    public void checkToken(String token) {
//        mvpView.showLoading();
////        执行网络请求的回调
//        addSubscription(apiStores.checkToken(token), new SubscribCallBack<>(new ApiCallback<OrdinalResultEntity>() {
//            @Override
//            public void onSuccess(OrdinalResultEntity model) {
//                mvpView.success(model);
//            }
//
//            @Override
//            public void onFailure(int code, String msg) {
//            }
//
//            @Override
//            public void onCompleted() {
//            }
//        }));
//    }

    /**
     * 设置数据操作；
     * @param index
     * @return
     */
    protected View setUpTabItemView(int index) {
        View v = mvpView.getTabView(index);
        if (v == null) {
            return getDefaultTabItemView(index);
        } else {
            return v;
        }
    }

    /**
     * 初始化当前的tabHost
     */
    public void setupTab() {
        mActivity = mvpView.getActivity();
        mTabHost = mvpView.getTabHost();
        mLayoutInflater = LayoutInflater.from(mActivity);
        mTabCount = this.mvpView.getTabCount();
        // tab总数不能小于等于0
        assert (mTabCount <= 0);
        if (mTabCount <= 0) {
            return;
        }
        for (int i = 0; i < mTabCount; i++) {
            HiFoFragmentTableItem tabItem = mvpView.getTabItem(i);
            if (tabItem == null)
                break;
            TabHost.TabSpec tab = mTabHost.newTabSpec(tabItem.getName()).setIndicator(
                    setUpTabItemView(i));
            mTabHost.addTab(tab, tabItem.getFragment(), null);
            //设置点击选中的时候的背景
//			mTabHost.getTabWidget().getChildAt(i).setBackgroundResource(R.drawable.selector_tab_background);
        }
    }


    protected View getDefaultTabItemView(int index) {
        HiFoFragmentTableItem tabItem = mvpView.getTabItem(index);
        View view = mLayoutInflater.inflate(R.layout.hifo_layout_tab_item, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.tab_layout_image);
        imageView.setImageResource(tabItem.getIconResourceId());
        TextView textView = (TextView) view.findViewById(R.id.tvName);
        textView.setText(tabItem.getName());
        return view;
    }
    //Presenter 实现加载数据,通过网络请求实现数据的请求
    public void sbmitGetTask(String fid, String username) {
        mvpView.showLoading();
//        addSubscription(apiStores.postGetTask(fid, username), new SubscribCallBack<>(new ApiCallback<GetTaskSuccessModel>() {
//            @Override
//            public void onSuccess(GetTaskSuccessModel model) {
//                mvpView.getTaskSuccess(model);
//            }
//
//            @Override
//            public void onFailure(int code, String msg) {
//                mvpView.getDataFail(msg);
//            }
//
//            @Override
//            public void onCompleted() {
//                mvpView.hideLoading();
//            }
//        }));
    }



}
