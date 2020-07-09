package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckSuccessContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CheckSuccessModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 核验成功
 * @Author qc
 * ================================================
 */
@Module
public abstract class CheckSuccessModule {

    @Binds
    abstract CheckSuccessContract.Model bindCheckSuccessModel(CheckSuccessModel model);
}