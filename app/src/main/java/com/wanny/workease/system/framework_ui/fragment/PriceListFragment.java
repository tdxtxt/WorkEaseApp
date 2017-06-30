/*
package com.wanny.workease.system.framework_ui.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import www.wanny.hifoyping.com.R;
import www.wanny.hifoyping.com.framework_care.AppContent;
import www.wanny.hifoyping.com.framework_mvpbasic.MvpFragment;
import www.wanny.hifoyping.com.framework_uikite.recycler.ListViewItemDecotion;
import www.wanny.hifoyping.com.yiping_business.yp_pricelist_mvp.PriceListImpl;
import www.wanny.hifoyping.com.yiping_business.yp_pricelist_mvp.PriceListPresenter;
import www.wanny.hifoyping.com.yiping_business.yp_pricelist_mvp.PriceListResult;

*/
/**
 * 文件名： PriceListFragment
 * 功能：
 * 作者： wanny
 * 时间： 14:47 2017/6/23
 *//*

public class PriceListFragment extends MvpFragment<PriceListPresenter> implements PriceListImpl, SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.ordinal_recycler)
    RecyclerView ordinalRecycler;
    Unbinder unbinder;
    @BindView(R.id.ordinal_refresh)
    SwipeRefreshLayout ordinalRefresh;

    public static String TYPE = "type";
    public static PriceListFragment newInstance(String type) {
        Bundle args = new Bundle();
        args.putString(TYPE, type);
        PriceListFragment instance = new PriceListFragment();
        instance.setArguments(args);
        return instance;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pricelist_fragment_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    private String currentType = "";
    private int type = 0;//待回价 0 ，已回价1，已终止2

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle.containsKey(TYPE)) {
            currentType = bundle.getString(TYPE);
        }
        if (!TextUtils.isEmpty(currentType)) {
            if (currentType.equals("待回价")) {
                type = 0;
            } else if (currentType.equals("已回价")) {
                type = 1;
            } else if (currentType.equals("已终止")) {
                type = 2;
            }
        }
        initView();
    }

    private LinearLayoutManager layoutManager;

    private void initView() {
        ordinalRecycler.setHasFixedSize(true);
        ordinalRefresh.setOnRefreshListener(this);
        layoutManager = new LinearLayoutManager(mContext);
        ordinalRecycler.setLayoutManager(layoutManager);
//        adapter = new FriendsAdapter(dataList, mContext, "", headImageUrl);
//        if (adapter != null) {
//            friendsActivityListview.setAdapter(adapter);
//        }
//        adapter.setFriendsRecyclerLmpl(this);
        ordinalRecycler.addOnScrollListener(onScrollListener);
        ordinalRecycler.addItemDecoration(new ListViewItemDecotion(mContext, ListViewItemDecotion.ORIVATION_VERCAL, R.drawable.gridview_itemdecoration_bg));
        upLoad();
    }

    private boolean hasRunnin = false;
    //滚动监听
    private RecyclerView.OnScrollListener onScrollListener = new RecyclerView.OnScrollListener() {
        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
        }

        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
            int lastVisibleItem = layoutManager.findLastVisibleItemPosition();
            int totalItemCount = layoutManager.getItemCount();
            //lastVisibleItem >= totalItemCount - 2 表示剩下4个item自动加载，各位自由选择 ,总数大于已经显示的条数的话
            // dy>0 表示向下滑动
            if (lastVisibleItem >= totalItemCount - 2 && dy > 0) {
                if (!hasRunnin) {
                    //加载更多
                    pageIndex = (totalItemCount / pageSize) + 1;
                    loadMoreData();
                }
            }
        }
    };
    private int pageIndex = 1;
    private int pageSize = 10;

    private void upLoad() {
        flag = AppContent.MODE_UPLOAD;
        pageIndex = 1;
        if (mvpPresenter != null) {
            LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("page", String.valueOf(pageIndex));
            map.put("pageSize", String.valueOf(pageSize));
            map.put("type", String.valueOf(type));
            map.put("key", "");
            mvpPresenter.getPriceList(map, pageIndex, pageSize, type, "", "get", "正在加载");
            hasRunnin = true;
        }
    }


    private void startSetRead() {
        if (mvpPresenter != null) {
//            Map<String, String> map = new HashMap<>();
//            map.put("SchoolClassId", classId);
//            map.put("CreateUserId", parentId);
//            map.put("key", "aFkeieD65dDtgUYod4dDeo98dde" + "#" + "dSDAS");
//            String nosign = MD5Utils.formatUrlMap(map, false, false);
//            String sign = MD5Utils.MD5Encode(nosign, "utf-8", false);
//            mvpPresenter.setFriendRad(classId, 2, parentId, sign);
        }
    }

    private String flag = "";

    private void loadMoreData() {
        hasRunnin = true;
        flag = AppContent.MODE_LOADMORE;
        if (mvpPresenter != null) {
             LinkedHashMap<String, String> map = new LinkedHashMap<>();
            map.put("page", String.valueOf(pageIndex));
            map.put("pageSize", String.valueOf(pageSize));
            map.put("type", String.valueOf(type));
            map.put("key", "");
            mvpPresenter.getPriceList(map, pageIndex, pageSize, type, "", "get", "正在加载");
            hasRunnin = true;
        }
    }


    @Override
    public void onRefresh() {

    }

    @Override
    public void success(PriceListResult priceListResult) {

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

    @Override
    protected PriceListPresenter createPresenter() {
        return new PriceListPresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
*/
