package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CertificateContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.CertificateModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: 核验
 * @Author qc
 * ================================================
 */
@Module
public abstract class CertificateModule {

    @Binds
    abstract CertificateContract.Model bindCertificateModel(CertificateModel model);
}