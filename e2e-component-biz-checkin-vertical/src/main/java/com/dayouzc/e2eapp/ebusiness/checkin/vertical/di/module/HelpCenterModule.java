package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HelpCenterContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.HelpCenterModel;

import dagger.Binds;
import dagger.Module;

/**
 * ================================================
 *
 * @Description: 帮助中心
 * @Author qc
 * ================================================
 */
@Module
public abstract class HelpCenterModule {

    @Binds
    abstract HelpCenterContract.Model bindHelpCenterModel(HelpCenterModel model);
}