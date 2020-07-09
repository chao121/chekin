package com.dayouzc.e2eapp.ebusiness.checkin.di.module;



import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.SplashContract;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.model.SplashModel;

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