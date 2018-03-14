package com.example.yujuancarlos_dev.emarctest.rx;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

@Singleton @Module
public class RxModule {

  @Provides
  @Singleton
  protected SchedulerProvider providesSchedulerProvider() {
    return new AppSchedulerProvider();
  }
}
