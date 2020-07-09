package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.CameraModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.CameraContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.CameraFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 摄像
 * @Author qc
 * ================================================
 */
@FragmentScope
@Component(modules = CameraModule.class, dependencies = AppComponent.class)
public interface CameraComponent {
    void inject(CameraFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        CameraComponent.Builder view(CameraContract.View view);

        CameraComponent.Builder appComponent(AppComponent appComponent);

        CameraComponent build();
    }
}