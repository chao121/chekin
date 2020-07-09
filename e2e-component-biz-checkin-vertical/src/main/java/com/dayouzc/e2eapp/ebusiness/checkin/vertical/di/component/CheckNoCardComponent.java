package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CheckNoCardModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CheckNoCardContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.CheckNoCardActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 核验结果卡
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = CheckNoCardModule.class, dependencies = AppComponent.class)
public interface CheckNoCardComponent {
    void inject(CheckNoCardActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CheckNoCardComponent.Builder view(CheckNoCardContract.View view);

        CheckNoCardComponent.Builder appComponent(AppComponent appComponent);

        CheckNoCardComponent build();
    }
}