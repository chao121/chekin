package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckOkCardContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CheckOkCardModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 核验成功卡
 * @Author qc
 * ================================================
 */
@Module
public abstract class CheckOkCardModule {

    @Binds
    abstract CheckOkCardContract.Model bindCheckOkCardModel(CheckOkCardModel model);
}