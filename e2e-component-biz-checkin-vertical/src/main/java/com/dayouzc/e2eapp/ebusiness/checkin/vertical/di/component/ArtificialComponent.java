package com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.component;

import com.dayouzc.e2eapp.ebusiness.checkin.vertical.di.module.ArtificialModule;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.contract.ArtificialContract;
import com.dayouzc.e2eapp.ebusiness.checkin.vertical.mvp.ui.fragment.ArtificialFragment;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.BindsInstance;
import dagger.Component;


/**
 * ================================================
 *
 * @Description: 人工
 * @Author qc
 * ================================================
 */
@FragmentScope
@Component(modules = ArtificialModule.class, dependencies = AppComponent.class)
public interface ArtificialComponent {
    void inject(ArtificialFragment fragment);

    @Component.Builder
    interface Builder {
        @BindsInstance
        ArtificialComponent.Builder view(ArtificialContract.View view);

        ArtificialComponent.Builder appComponent(AppComponent appComponent);

        ArtificialComponent build();
    }
}