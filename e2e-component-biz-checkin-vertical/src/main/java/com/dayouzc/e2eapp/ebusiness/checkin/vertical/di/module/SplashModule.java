package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.SplashContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.SplashModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: Splash
 * @Author qc
 * ================================================
 */
@Module
public abstract class SplashModule {

    @Binds
    abstract SplashContract.Model bindSplashModel(SplashModel model);
}