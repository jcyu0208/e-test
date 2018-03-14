package com.example.yujuancarlos_dev.emarctest.rx;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

public class AppSchedulerProvider implements SchedulerProvider {

  @Override public Scheduler ui() {
    return AndroidSchedulers.mainThread();
  }

  @Override public Scheduler io() {
    return Schedulers.io();
  }

  @Override public Scheduler computation() {
    return Schedulers.computation();
  }
}
