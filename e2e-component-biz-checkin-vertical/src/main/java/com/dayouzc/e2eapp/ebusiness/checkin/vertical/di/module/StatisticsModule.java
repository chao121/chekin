package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.StatisticsContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.StatisticsModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 预约统计
 * @Author qc
 * ================================================
 */
@Module
public abstract class StatisticsModule {

    @Binds
    abstract StatisticsContract.Model bindStatisticsModel(StatisticsModel model);
}