package com.example.yujuancarlos_dev.emarctest.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by yujuancarlos_dev on 13/03/2018.
 */

public abstract class BaseInjectedActivity<SUB> extends DaggerActivity<SUB, AppComponent> {
  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AppComponent appComponent = (AppComponent) getDaggerApp().getMainComponent();
    subComponent = getSubComponent(appComponent);
    initializeDagger((AppComponent) getDaggerApp().getMainComponent(), subComponent);
  }
}
