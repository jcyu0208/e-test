package com.example.yujuancarlos_dev.emarctest.rx;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yujuancarlos_dev on 14/03/2018.
 */

public class TestTrampolineSchedulerProvider implements SchedulerProvider {
  @Override public Scheduler ui() {
    return Schedulers.trampoline();
  }

  @Override public Scheduler io() {
    return Schedulers.trampoline();
  }

  @Override public Scheduler computation() {
    return Schedulers.trampoline();
  }
}
