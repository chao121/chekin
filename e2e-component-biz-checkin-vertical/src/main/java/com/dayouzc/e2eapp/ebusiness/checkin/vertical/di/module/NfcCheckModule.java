package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module;


import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.NfcCheckContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.model.NfcCheckModel;

import dagger.Binds;
import dagger.Module;


/**
 * ================================================
 *
 * @Description: nfc
 * @Author qc
 * ================================================
 */
@Module
public abstract class NfcCheckModule {

    @Binds
    abstract NfcCheckContract.Model bindNfcCheckModel(NfcCheckModel model);
}