package com.example.yujuancarlos_dev.emarctest.dagger;

import android.app.Application;

/**
 * Created by yujuancarlos_dev on 12/03/2018.
 */

public abstract class DaggerApp<T> extends Application {

  private T mainComponent;

  @Override public void onCreate() {
    super.onCreate();
    initializeDagger();
  }

  protected void initializeDagger() {
    mainComponent = buildMainComponent();
  }

  T getMainComponent() {
    if (mainComponent == null) {
      throw new RuntimeException("Did you forget to initialize Dagger? Properly extend initializeDagger and call it.");
    }

    return mainComponent;
  }

  protected abstract T buildMainComponent();
}
