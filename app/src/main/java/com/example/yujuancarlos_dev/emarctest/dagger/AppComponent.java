package com.example.yujuancarlos_dev.emarctest.dagger;

import com.example.yujuancarlos_dev.emarctest.ImageApplication;
import com.example.yujuancarlos_dev.emarctest.ViewModelModule;
import com.example.yujuancarlos_dev.emarctest.network.NetworkModule;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Singleton
@Component(
    modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ViewModelModule.class
    })
public interface AppComponent extends AndroidInjector<ImageApplication> {
}
