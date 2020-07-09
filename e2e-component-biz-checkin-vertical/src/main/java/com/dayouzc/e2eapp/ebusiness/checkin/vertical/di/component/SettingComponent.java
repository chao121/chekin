package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.SettingModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.SettingContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.SettingActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 设置
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = SettingModule.class, dependencies = AppComponent.class)
public interface SettingComponent {
    void inject(SettingActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        SettingComponent.Builder view(SettingContract.View view);

        SettingComponent.Builder appComponent(AppComponent appComponent);

        SettingComponent build();
    }
}