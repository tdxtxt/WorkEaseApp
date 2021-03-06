package com.wanny.workease.system.framework_ui.customer_UI.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.wanny.workease.system.R;
import com.wanny.workease.system.framework_basicutils.PreferenceUtil;
import com.wanny.workease.system.framework_care.ActivityStackManager;
import com.wanny.workease.system.framework_care.OrdinalResultEntity;
import com.wanny.workease.system.framework_mvpbasic.MvpActivity;
import com.wanny.workease.system.framework_uikite.dialog.HiFoToast;
import com.wanny.workease.system.workease_business.login_mvp.LoginImpl;
import com.wanny.workease.system.workease_business.login_mvp.LoginPresenter;
import com.wanny.workease.system.workease_business.login_mvp.LoginResult;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 文件名： LoginActivity
 * 功能：
 * 作者： wanny
 * 时间： 16:58 2017/6/22
 */
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginImpl {


    @BindView(R.id.login_app_login)
    ImageView loginAppLogin;
    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login_copyright)
    TextView loginCopyright;
    @BindView(R.id.start_login)
    TextView startLogin;

    @BindView(R.id.start_register)
    TextView startRegister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity_view);
        ButterKnife.bind(this);
//        String mobile = PreferenceUtil.getInstance(mContext).getString("mobile", "");
//        if (!TextUtils.isEmpty(mobile)) {
//            Intent intent = new Intent(LoginActivity.this,HomeManagerActivity.class);
//            startActivity(intent);
//        }
    }


    @OnClick(R.id.start_login)
    void setStartLogin(View view) {
        if (TextUtils.isEmpty(loginUsername.getText().toString())) {
            new HiFoToast(mContext, "请输入账号");
            return;
        }
        if (TextUtils.isEmpty(loginPassword.getText().toString())) {
            new HiFoToast(mContext, "请输入密码");
            return;
        }
        if (mvpPresenter != null) {
            mvpPresenter.login(loginUsername.getText().toString(), loginPassword.getText().toString(), "正在登录");
        }
    }


    @Override
    public void success(LoginResult loginResult) {
        if (loginResult.isSuccess()) {
            if (loginResult.getData() != null) {
                PreferenceUtil.getInstance(mContext).saveString("mobile", loginResult.getData().getMobile());
                PreferenceUtil.getInstance(mContext).saveString("name", loginResult.getData().getUserName());
                Intent intent = new Intent(LoginActivity.this, HomeManagerActivity.class);
                startActivity(intent);
                ActivityStackManager.getInstance().exitActivity(mActivity);
            }
        } else {
            if (!TextUtils.isEmpty(loginResult.getMsg())) {
                new HiFoToast(mContext, loginResult.getMsg());
            }
        }

    }


    @OnClick(R.id.start_register)
    void startRegiseter(View view) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 0x0001);
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
    public void setJpush(OrdinalResultEntity entity) {

    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }

}
