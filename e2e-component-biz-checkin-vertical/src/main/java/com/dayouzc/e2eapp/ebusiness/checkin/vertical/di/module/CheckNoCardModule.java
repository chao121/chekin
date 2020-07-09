package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckNoCardContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CheckNoCardModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 核验失败卡
 * @Author qc
 * ================================================
 */
@Module
public abstract class CheckNoCardModule {

    @Binds
    abstract CheckNoCardContract.Model bindCheckNoCardModel(CheckNoCardModel model);
}