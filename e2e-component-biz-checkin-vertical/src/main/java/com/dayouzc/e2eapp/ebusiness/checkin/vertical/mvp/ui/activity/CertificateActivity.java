package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.R2;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component.DaggerCertificateComponent;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CertificateContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.Api;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.presenter.CertificatePresenter;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.adapter.CertificateAdapter;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.ArtificialFragment;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.CameraFragment;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.InfraredFragment;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.NfcCheckFragment;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.utils.NfcUtils;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.utils.SoundUtils;
import com.dayouzc.e2eapp.mcard.dto.McardRecordDTO;
import com.dayouzc.e2eplatform.core.dto.common.ResponseData;
import com.google.android.material.tabs.TabLayout;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.ArmsUtils;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;

import static com.jess.arms.utils.Preconditions.checkNotNull;

/**
 * ================================================
 *
 * @Description: 入园验证
 * @Author qc
 * ================================================
 */
@Route(path = "/activity/certificate")
public class CertificateActivity extends BaseActivity<CertificatePresenter> implements CertificateContract.View {


    @BindView(R2.id.tab_certificate)
    TabLayout tabLayout;
    @BindView(R2.id.vp_certificate)
    ViewPager vpCertificate;
    @BindView(R2.id.title)
    TextView title;
    @BindView(R2.id.back)
    ImageView back;
    private String[] titles = new String[]{"NFC", "红外", "摄像头", "人工录入"};
    private SoundUtils sd;
    private int page;

    @Override
    public void setupActivityComponent(@NonNull AppComponent appComponent) {
        DaggerCertificateComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .view(this)
                .build()
                .inject(this);
    }

    @Override
    public int initView(@Nullable Bundle savedInstanceState) {
        return R.layout.activity_certificate; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(@Nullable Bundle savedInstanceState) {
        init();
    }

    private void init() {

        title.setText(getResources().getString(R.string.tv_certificate_title));
//        page = getIntent().getIntExtra("page", 0);

        back.setVisibility(View.VISIBLE);
        sd = new SoundUtils(this);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new NfcCheckFragment());
        fragmentList.add(new InfraredFragment());
        fragmentList.add(new CameraFragment());
        fragmentList.add(new ArtificialFragment());
        vpCertificate.setAdapter(new CertificateAdapter(getSupportFragmentManager(), this, fragmentList, titles));
        vpCertificate.setCurrentItem(page);
        vpCertificate.setOffscreenPageLimit(0);
        tabLayout.setupWithViewPager(vpCertificate);//此方法就是让tabLayout和ViewPager联动


    }

    @Override
    public void onResume() {
        super.onResume();

        if (vpCertificate.getCurrentItem() == 0) {
            NfcUtils utils = new NfcUtils(this);
            if (NfcUtils.mNfcAdapter == null) {
                return;
            }
            // 得到是否检测到ACTION_TECH_DISCOVERED触发
            NfcUtils.mNfcAdapter.enableForegroundDispatch(this, NfcUtils.mPendingIntent, NfcUtils.mIntentFilter, NfcUtils.mTechList);
        } else {
            NfcUtils.mNfcAdapter.disableForegroundDispatch(this);
        }

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
    protected void onDestroy() {
        super.onDestroy();

    }

    /**
     * 读取NFC信息数据
     *
     * @param intent
     */
    @SuppressLint("NewApi")
    private void processIntent(Intent intent) {

        Tag tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);

        String cardUid = toHexString(tag.getId());
        String cardicid = cardUid.replace(" ", "");
        // 区分拉卡拉（10位）与手持pos（8位）读卡的区别
        if (cardicid.length() == 10 && cardicid.startsWith("00")) {
            cardicid = cardicid.substring(2, 10);
        }
        String cardNum = cardicid;
        //卡核验数据
        mPresenter.getData(cardNum);
    }


    private String toHexString(byte[] buffer) {

        StringBuilder bufferString = new StringBuilder();

        if (buffer != null) {

            for (int i = 0; i < buffer.length; i++) {

                String hexChar = Integer.toHexString(buffer[i] & 0xFF);
                if (hexChar.length() == 1) {
                    hexChar = "0" + hexChar;
                }

                bufferString.append(hexChar.toUpperCase(Locale.US)).append(" ");
            }
        }

        return bufferString.toString();
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (NfcAdapter.ACTION_TECH_DISCOVERED.equals(intent.getAction())) {
            // 处理该intent
            processIntent(intent);
        }

    }

    @OnClick({R2.id.back})
    public void OnClick(View view) {
        if (view.getId() == R.id.back) {
            finish();
        }
    }

    @Override
    public void setData(ResponseData<McardRecordDTO> response) {
        if (Api.PARAM_SUCCESS.equals(response.getStatus())) {
            sd.playSound(1);
            startActivity(new Intent(this, CheckOkCardActivity.class).putExtra("mCardRecord", response));
        } else if (Api.PARAM_ERROR.equals(response.getStatus())) {
            sd.playSound(2);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.PARAM_CARD_NOT_EXIST.equals(response.getStatus())) {
            sd.playSound(7);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_UNSOLD.equals(response.getStatus())) {
            sd.playSound(5);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_UNBIND.equals(response.getStatus())) {
            sd.playSound(11);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_OVERDUR.equals(response.getStatus())) {
            sd.playSound(4);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_FROZEN.equals(response.getStatus())) {//冻结
            sd.playSound(8);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_LOST.equals(response.getStatus())) {
            sd.playSound(13);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.CARD_UNVALID.equals(response.getStatus())) {
            sd.playSound(6);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.MC_NOTMATCH.equals(response.getStatus())) {
            sd.playSound(10);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        } else if (Api.MC_NO_NUMBER.equals(response.getStatus())) {
            sd.playSound(12);
            startActivity(new Intent(this, CheckNoCardActivity.class));
        }
        NfcUtils.mNfcAdapter.disableForegroundDispatch(this);
    }
}
