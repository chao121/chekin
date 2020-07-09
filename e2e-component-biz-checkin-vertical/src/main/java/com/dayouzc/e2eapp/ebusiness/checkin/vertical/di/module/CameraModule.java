package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CameraContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CameraModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 摄像
 * @Author qc
 * ================================================
 */
@Module
public abstract class CameraModule {

    @Binds
    abstract CameraContract.Model bindCameraModel(CameraModel model);
}