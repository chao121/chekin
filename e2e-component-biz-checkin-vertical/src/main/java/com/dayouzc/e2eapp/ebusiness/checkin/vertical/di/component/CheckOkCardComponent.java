package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CheckOkCardModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckOkCardContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CheckOkCardActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;

/**
 * ================================================
 *
 * @Description: 和验成功卡
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = CheckOkCardModule.class, dependencies = AppComponent.class)
public interface CheckOkCardComponent {
    void inject(CheckOkCardActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CheckOkCardComponent.Builder view(CheckOkCardContract.View view);

        CheckOkCardComponent.Builder appComponent(AppComponent appComponent);

        CheckOkCardComponent build();
    }
}