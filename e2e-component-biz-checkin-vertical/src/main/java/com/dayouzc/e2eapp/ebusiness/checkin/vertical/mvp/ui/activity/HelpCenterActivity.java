package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dayouzc.e2e.core.view.webview.DyWebViewManager;
import com.dayouzc.e2e.core.view.webview.WebViewParam;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R2;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerHelpCenterComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HelpCenterContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.Api;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.HelpCenterPresenter;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;


import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 *
 * @Description: 帮助中心
 * @Author qc
 * ================================================
 */

@Route(path = "/activity/helpCenter")
public class HelpCenterActivity extends BaseActivity<HelpCenterPresenter> implements HelpCenterContract.View {


    @BindView(R2.id.title)
    TextView title;

    @BindView(R2.id.fl_helper_center_content)
    FrameLayout content;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerHelpCenterComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_help_center; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        title.setText(getResources().getString(R.string.tv_help_center_name));


        WebViewParam webViewParam = new WebViewParam(Api.helpCenterPath);
        webViewParam.setJavaObject(new WebViewParam.JavaObject("YZYZJsInterface", new JsInterfaceExtend()));
        DyWebViewManager.showWeb(this, R.id.fl_helper_center_content, webViewParam);
//
//        DyWebViewActivity.show(HelpCenterActivity.this, webViewParam);


    }


    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        ArmsUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        ArmsUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    private class JsInterfaceExtend {
        public JsInterfaceExtend() {

        }

        @JavascriptInterface
        public void methodToArtificial(String mcId, String currToken) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    JsInterfaceExtend.this.startActivity(new Intent(HelpCenterActivity.this, CertificateActivity.class));
                }
            });
//            ToastUtils.showToast(HelpCenterActivity.this,"成功");

//            startActivity(new Intent(HelpCenterActivity.this, CertificateActivity.class));
        }
    }
}
