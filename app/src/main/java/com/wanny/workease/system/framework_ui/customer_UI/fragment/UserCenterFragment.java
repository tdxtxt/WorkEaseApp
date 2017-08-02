package com.wanny.workease.system.framework_ui.customer_UI.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wanny.workease.system.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 文件名： MainSecondFragment
 * 功能：
 * 作者： wanny
 * 时间： 13:54 2017/6/23
 */
public class UserCenterFragment extends Fragment {


    @BindView(R.id.register_area_provice)
    TextView registerAreaProvice;
    @BindView(R.id.register_area)
    TextView registerArea;
    @BindView(R.id.register_typeselect)
    TextView registerTypeselect;
    @BindView(R.id.register_workertime_index)
    TextView registerWorkertimeIndex;
    @BindView(R.id.register_workertime)
    EditText registerWorkertime;
    @BindView(R.id.register_skilllevelselect)
    TextView registerSkilllevelselect;
    Unbinder unbinder;
    @BindView(R.id.register_type)
    TextView registerType;
    @BindView(R.id.register_skilllevel)
    TextView registerSkilllevel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.usercenter_fragment_view, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
