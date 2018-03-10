package com.example.yujuancarlos_dev.emarctest;

import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import dagger.Module;
import dagger.Provides;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Module
public class ViewModelModule {

  @Provides MainViewModel providesMainViewModel(NetworkRepository repository) {
    return new MainViewModel(repository);
  }
}
