package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CheckSuccessModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckSuccessContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CheckSuccessActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 和验成功
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = CheckSuccessModule.class, dependencies = AppComponent.class)
public interface CheckSuccessComponent {
    void inject(CheckSuccessActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CheckSuccessComponent.Builder view(CheckSuccessContract.View view);

        CheckSuccessComponent.Builder appComponent(AppComponent appComponent);

        CheckSuccessComponent build();
    }
}