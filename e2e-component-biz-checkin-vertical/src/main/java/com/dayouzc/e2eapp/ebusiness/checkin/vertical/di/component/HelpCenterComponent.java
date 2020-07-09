package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.HelpCenterModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.HelpCenterContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.HelpCenterActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * ================================================
 *
 * @Description: 帮助中心
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = HelpCenterModule.class, dependencies = AppComponent.class)
public interface HelpCenterComponent {
    void inject(HelpCenterActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        HelpCenterComponent.Builder view(HelpCenterContract.View view);

        HelpCenterComponent.Builder appComponent(AppComponent appComponent);

        HelpCenterComponent build();
    }
}