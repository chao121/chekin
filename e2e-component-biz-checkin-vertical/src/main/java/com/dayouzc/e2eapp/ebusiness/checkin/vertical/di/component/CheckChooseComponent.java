package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CheckChooseModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckChooseContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CheckChooseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 核验选择
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = CheckChooseModule.class, dependencies = AppComponent.class)
public interface CheckChooseComponent {
    void inject(CheckChooseActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CheckChooseComponent.Builder view(CheckChooseContract.View view);

        CheckChooseComponent.Builder appComponent(AppComponent appComponent);

        CheckChooseComponent build();
    }
}