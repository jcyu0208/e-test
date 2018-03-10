package com.example.yujuancarlos_dev.emarctest.dagger;

import com.example.yujuancarlos_dev.emarctest.MainActivity;
import com.example.yujuancarlos_dev.emarctest.MainViewModel;
import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Module
public abstract class AppModule {
  @ContributesAndroidInjector
  abstract MainActivity contributesActivityInjector();
}
