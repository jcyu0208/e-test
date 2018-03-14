package com.example.yujuancarlos_dev.emarctest;

import com.example.yujuancarlos_dev.emarctest.dagger.AppComponent;
import com.example.yujuancarlos_dev.emarctest.dagger.AppModule;
import com.example.yujuancarlos_dev.emarctest.dagger.DaggerAppComponent;
import com.example.yujuancarlos_dev.emarctest.dagger.DaggerApp;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class ImageApplication extends DaggerApp<AppComponent> {

  @Override protected AppComponent buildMainComponent() {
    return prepareBuilder()
        .build();
  }

  // We need this for Unit Tests
  protected DaggerAppComponent.Builder prepareBuilder() {
    return DaggerAppComponent.builder()
        .appModule(new AppModule(this));
  }
}
