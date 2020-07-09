package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.InfraredContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.InfraredModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 红外
 * @Author qc
 * ================================================
 */
@Module
public abstract class InfraredModule {

    @Binds
    abstract InfraredContract.Model bindInfraredModel(InfraredModel model);
}