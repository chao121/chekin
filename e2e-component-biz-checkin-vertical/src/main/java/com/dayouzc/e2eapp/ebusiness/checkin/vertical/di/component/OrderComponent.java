package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.OrderModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.OrderContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.activity.OrderActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 入园统计
 * @Author qc
 * ================================================
 */
@ActivityScope
@Component(modules = OrderModule.class, dependencies = AppComponent.class)
public interface OrderComponent {
    void inject(OrderActivity activity);

    @Component.Builder
    interface Builder {
        @BindsInstance
        OrderComponent.Builder view(OrderContract.View view);

        OrderComponent.Builder appComponent(AppComponent appComponent);

        OrderComponent build();
    }
}