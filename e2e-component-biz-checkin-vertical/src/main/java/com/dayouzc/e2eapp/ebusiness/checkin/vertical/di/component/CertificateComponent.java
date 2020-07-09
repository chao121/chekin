package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CertificateModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CertificateContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CertificateActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 核验
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = CertificateModule.class, dependencies = AppComponent.class)
public interface CertificateComponent {
    void inject(CertificateActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CertificateComponent.Builder view(CertificateContract.View view);

        CertificateComponent.Builder appComponent(AppComponent appComponent);

        CertificateComponent build();
    }
}