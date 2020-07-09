package com.dayouzc.e2eapp.ebusiness.checkin.mvp.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dayouzc.e2e.core.E2EAppClientContext;
import com.dayouzc.e2e.core.E2EContextManager;
import com.dayouzc.e2e.core.bean.E2EConfiguration;
import com.dayouzc.e2eapp.ebusiness.checkin.BuildConfig;
import com.dayouzc.e2eapp.ebusiness.checkin.R;
import com.dayouzc.e2eapp.ebusiness.checkin.di.component.DaggerSplashComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.SplashContract;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.model.Api;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.presenter.SplashPresenter;
import com.dayouzc.e2eapp.mcard.sdk.McardOrderSDK;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;

import static com.jess.arms.utils.Preconditions.checkNotNull;


/**
 * ================================================
 *
 * @Description: 启动页
 * @Author qc
 * ================================================
 */
public class SplashActivity extends BaseActivity<SplashPresenter> implements SplashContract.View
        , E2EAppClientContext.OnFinishListener {

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerSplashComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_splash; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hideBottomUIMenu();
        //设置参数
        E2EConfiguration configuration = new E2EConfiguration();
        configuration.setIserverSN("SC00216300100014772");
        configuration.setIserverName("大有集结号");
//        configuration.setIserverIp("jjh.test.dayouzc.com");
        configuration.setIserverIp("172.16.2.221");
        configuration.setIserverPort("80");
        configuration.setIserverType("1");
        configuration.setIserverCDNType("OCDN");
        configuration.setOnFinishListener(this);

        E2EAppClientContext e2eAppClientContext = E2EAppClientContext.getInstance(this.getApplication());
        e2eAppClientContext.init("aaa1234", "有证验证", BuildConfig.VERSION_NAME, configuration);//APPID appName APPVersion

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

    @Override
    public void onFinish(String code, String msg) {
        //初始化sdk
        McardOrderSDK.getInstance(Api.ip, Api.port, Api.path);
        startActivity(new Intent(this, HomeActivity.class));
//        ARouter.getInstance().build("/activity/home").navigation();
        finish();
    }

    @Override
    public void onError(String code, String msg) {

    }

    /**
     * 隐藏虚拟按键，并且设置成全屏
     */
    protected void hideBottomUIMenu() {
        if (Build.VERSION.SDK_INT >= 19) {
            //for new api versions.
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                    | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                    | View.SYSTEM_UI_FLAG_IMMERSIVE;
            decorView.setSystemUiVisibility(uiOptions);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }
}
