package com.example.yujuancarlos_dev.emarctest.dagger;

import com.example.yujuancarlos_dev.emarctest.network.NetworkModule;
import com.example.yujuancarlos_dev.emarctest.rx.RxModule;
import com.example.yujuancarlos_dev.emarctest.views.ViewComponent;
import dagger.Component;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Singleton
@Component(
    modules = {
        AppModule.class,
        NetworkModule.class,
        RxModule.class
    })
public interface AppComponent {
    ViewComponent getViewComponent();
}
