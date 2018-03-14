package com.example.yujuancarlos_dev.emarctest.rx;

import io.reactivex.Scheduler;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

public interface SchedulerProvider {
  Scheduler ui();
  Scheduler io();
  Scheduler computation();
}
