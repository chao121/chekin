package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HomeContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.HomeModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 首页
 * @Author qc
 * ================================================
 */
@Module
public abstract class HomeModule {

    @Binds
    abstract HomeContract.Model bindHomeModel(HomeModel model);
}