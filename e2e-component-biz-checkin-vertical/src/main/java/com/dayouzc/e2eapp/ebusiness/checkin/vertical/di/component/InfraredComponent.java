package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.InfraredModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.InfraredContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.InfraredFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 红外
 * @Author qc
 * ================================================
 */
@FragmentScope
@Component(modules = InfraredModule.class, dependencies = AppComponent.class)
public interface InfraredComponent {
    void inject(InfraredFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        InfraredComponent.Builder view(InfraredContract.View view);

        InfraredComponent.Builder appComponent(AppComponent appComponent);

        InfraredComponent build();
    }
}