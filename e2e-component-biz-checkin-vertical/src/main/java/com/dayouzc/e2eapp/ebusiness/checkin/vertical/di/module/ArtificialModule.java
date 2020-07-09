package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.ArtificialContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.ArtificialModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 人工
 * @Author qc
 * ================================================
 */
@Module
public abstract class ArtificialModule {

    @Binds
    abstract ArtificialContract.Model bindArtificialModel(ArtificialModel model);
}