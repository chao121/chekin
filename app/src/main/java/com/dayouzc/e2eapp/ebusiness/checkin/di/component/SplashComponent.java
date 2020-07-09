package com.dayouzc.e2eapp.ebusiness.checkin.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.di.module.SplashModule;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.activity.SplashActivity;
import com.dayouzc.e2eapp.ebusiness.checkin.mvp.contract.SplashContract;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: Splash页
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = SplashModule.class, dependencies = AppComponent.class)
public interface SplashComponent {
    void inject(SplashActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        SplashComponent.Builder view(SplashContract.View view);

        SplashComponent.Builder appComponent(AppComponent appComponent);

        SplashComponent build();
    }
}