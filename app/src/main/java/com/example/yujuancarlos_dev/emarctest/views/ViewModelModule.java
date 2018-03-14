package com.example.yujuancarlos_dev.emarctest.views;

import com.example.yujuancarlos_dev.emarctest.rx.SchedulerProvider;
import com.example.yujuancarlos_dev.emarctest.views.main.MainViewModel;
import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Module
@ViewScope
public class ViewModelModule {

  @Provides
  @ViewScope MainViewModel providesMainViewModel(NetworkRepository repository, SchedulerProvider provider) {
    return new MainViewModel(repository, provider);
  }
}
