package com.example.yujuancarlos_dev.emarctest;

import android.app.Activity;
import android.app.Application;
import com.example.yujuancarlos_dev.emarctest.dagger.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import javax.inject.Inject;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class ImageApplication extends Application implements HasActivityInjector {

  @Inject
  DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

  @Override public void onCreate() {
    super.onCreate();
    DaggerAppComponent.create().inject(this);
  }

  @Override public AndroidInjector<Activity> activityInjector() {
    return dispatchingAndroidInjector;
  }
}
