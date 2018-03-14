package com.example.yujuancarlos_dev.emarctest.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.TestScheduler;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

public class TestSchedulerProvider implements SchedulerProvider {

  private TestScheduler scheduler;

  public TestSchedulerProvider(TestScheduler scheduler) {
    this.scheduler = scheduler;
  }

  @Override public Scheduler ui() {
    return scheduler;
  }

  @Override public Scheduler io() {
    return scheduler;
  }

  @Override public Scheduler computation() {
    return scheduler;
  }
}
