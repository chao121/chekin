package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckChooseContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CheckChooseModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 核验选择
 * @Author qc
 * ================================================
 */
@Module
public abstract class CheckChooseModule {

    @Binds
    abstract CheckChooseContract.Model bindCheckChooseModel(CheckChooseModel model);
}