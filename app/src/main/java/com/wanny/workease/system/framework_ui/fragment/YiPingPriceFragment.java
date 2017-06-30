/*
package com.wanny.workease.system.framework_ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.lang.reflect.Field;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import www.wanny.hifoyping.com.R;
import www.wanny.hifoyping.com.framework_basicutils.AppUtils;
import www.wanny.hifoyping.com.framework_care.OrdinalResultEntity;
import www.wanny.hifoyping.com.framework_mvpbasic.MvpFragment;
import www.wanny.hifoyping.com.yiping_business.yp_price_mvp.PriceFragmentAdapter;
import www.wanny.hifoyping.com.yiping_business.yp_price_mvp.YPPriceImpl;
import www.wanny.hifoyping.com.yiping_business.yp_price_mvp.YPPricePresenter;

*/
/**
 * 文件名： YiPingPriceFragment
 * 功能：
 * 作者： wanny
 * 时间： 14:03 2017/6/23
 *//*

public class YiPingPriceFragment extends MvpFragment<YPPricePresenter> implements YPPriceImpl {


    //返回首页
    @BindView(R.id.title_left)
    TextView titleLeft;
    //标题
    @BindView(R.id.title_title)
    TextView titleTitle;
    //搜索
    @BindView(R.id.yp_price_fragment_search)
    TextView ypPriceFragmentSearch;
    //tablayout
    @BindView(R.id.yp_price_fragment_tabLayout)
    TabLayout ypPriceFragmentTabLayout;
    //viewPager
    @BindView(R.id.yp_price_fragment_viewpager)
    ViewPager ypPriceFragmentViewpager;
    Unbinder unbinder;

    private PriceFragmentAdapter priceFragmentAdapter;

    private ArrayList<String> typeList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.yp_price_fragment_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private ArrayList<Fragment> fragments ;

    private void initView(){
        if(typeList == null){
            typeList = new ArrayList<>();
        }
        if(fragments == null){
            fragments = new ArrayList<>();
        }
        typeList.add("待回价");
        typeList.add("已回价");
        typeList.add("已中止");
        for(String type : typeList){
            fragments.add(PriceListFragment.newInstance(type));
        }
        priceFragmentAdapter = new PriceFragmentAdapter(getChildFragmentManager(), fragments, typeList);
        ypPriceFragmentViewpager.setAdapter(priceFragmentAdapter);
        //将TabLayout和ViewPager关联起来。
        ypPriceFragmentTabLayout.setupWithViewPager(ypPriceFragmentViewpager);
        //给TabLayout设置适配器
        ypPriceFragmentTabLayout.setupWithViewPager(ypPriceFragmentViewpager, true);
        setTabWidth();
    }


    private void setTabWidth(){
        ypPriceFragmentTabLayout.post(new Runnable() {
            @Override
            public void run() {
                try {
                    //拿到tabLayout的mTabStrip属性
                    Field mTabStripField = ypPriceFragmentTabLayout.getClass().getDeclaredField("mTabStrip");
                    mTabStripField.setAccessible(true);

                    LinearLayout mTabStrip = (LinearLayout) mTabStripField.get(ypPriceFragmentTabLayout);

                    int dp10 = AppUtils.dip2px(getContext(), 20);

                    for (int i = 0; i < mTabStrip.getChildCount(); i++) {
                        View tabView = mTabStrip.getChildAt(i);

                        //拿到tabView的mTextView属性
                        Field mTextViewField = tabView.getClass().getDeclaredField("mTextView");
                        mTextViewField.setAccessible(true);

                        TextView mTextView = (TextView) mTextViewField.get(tabView);

                        tabView.setPadding(0, 0, 0, 0);

                        //因为我想要的效果是   字多宽线就多宽，所以测量mTextView的宽度
                        int width = 0;
                        width = mTextView.getWidth();
                        if (width == 0) {
                            mTextView.measure(0, 0);
                            width = mTextView.getMeasuredWidth();
                        }

                        //设置tab左右间距为10dp  注意这里不能使用Padding 因为源码中线的宽度是根据 tabView的宽度来设置的
                        LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) tabView.getLayoutParams();
                        params.width = width ;
                        params.leftMargin = dp10;
                        params.rightMargin = dp10;
                        tabView.setLayoutParams(params);

                        tabView.invalidate();
                    }

                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }

            }
        });

    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
    }

    @Override
    public void success(OrdinalResultEntity ordinalResultEntity) {

    }

    @Override
    public void fail(String errorMessage) {

    }

    @Override
    public void loadIng(String title) {

    }

    @Override
    public void hide() {

    }


    //询价列表
    @Override
    protected YPPricePresenter createPresenter() {
        return new YPPricePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
*/
