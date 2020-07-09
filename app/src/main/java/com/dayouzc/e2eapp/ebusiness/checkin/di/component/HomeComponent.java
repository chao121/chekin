package com.dayouzc.e2eapp.ebusiness.checkin.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.di.module.HomeModule;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.activity.HomeActivity;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.HomeContract;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 首页
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = HomeModule.class, dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        HomeComponent.Builder view(HomeContract.View view);

        HomeComponent.Builder appComponent(AppComponent appComponent);

        HomeComponent build();
    }
}