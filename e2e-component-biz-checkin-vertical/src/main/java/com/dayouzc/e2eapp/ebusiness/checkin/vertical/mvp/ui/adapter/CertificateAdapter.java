package com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;
/**
 * ================================================
 *
 * @Description: 入园验证adapter
 * @Author qc
 * ================================================
 */
public class CertificateAdapter extends FragmentPagerAdapter {
    private Context context;
    private List<Fragment> fragmentList;
    private String[] titleList;

    public CertificateAdapter(@NonNull FragmentManager fm, Context context, List<Fragment> fragmentList, String[] titleList) {
        super(fm);

        this.context = context;
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return titleList.length;
    }

    /**
     * //此方法用来显示tab上的名字
     */
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList[position];
    }
}
