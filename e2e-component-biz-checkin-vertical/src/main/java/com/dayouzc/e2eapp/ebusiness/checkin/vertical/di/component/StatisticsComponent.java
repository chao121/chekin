package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.StatisticsModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.StatisticsContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.StatisticsActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 预约统计
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = StatisticsModule.class, dependencies = AppComponent.class)
public interface StatisticsComponent {
    void inject(StatisticsActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        StatisticsComponent.Builder view(StatisticsContract.View view);

        StatisticsComponent.Builder appComponent(AppComponent appComponent);

        StatisticsComponent build();
    }
}