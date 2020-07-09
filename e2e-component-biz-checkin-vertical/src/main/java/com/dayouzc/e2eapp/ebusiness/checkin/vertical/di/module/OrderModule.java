package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.OrderContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.OrderModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 入园统计
 * @Author qc
 * ================================================
 */
@Module
public abstract class OrderModule {

    @Binds
    abstract OrderContract.Model bindOrderModel(OrderModel model);
}