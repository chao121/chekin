package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.NfcCheckModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.NfcCheckContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.NfcCheckFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: nfc
 * @Author qc
 * ================================================
 */
@FragmentScope
@Component(modules = NfcCheckModule.class, dependencies = AppComponent.class)
public interface NfcCheckComponent {
    void inject(NfcCheckFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        NfcCheckComponent.Builder view(NfcCheckContract.View view);

        NfcCheckComponent.Builder appComponent(AppComponent appComponent);

        NfcCheckComponent build();
    }
}