package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.SettingContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.SettingModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 设置
 * @Author qc
 * ================================================
 */
@Module
public abstract class SettingModule {

    @Binds
    abstract SettingContract.Model bindSettingModel(SettingModel model);
}