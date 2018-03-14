package com.example.yujuancarlos_dev.emarctest;

import android.util.Log;
import com.example.yujuancarlos_dev.emarctest.dagger.DaggerAppComponent;
import com.example.yujuancarlos_dev.emarctest.rx.RxModule;
import com.example.yujuancarlos_dev.emarctest.rx.SchedulerProvider;
import com.example.yujuancarlos_dev.emarctest.rx.TestTrampolineSchedulerProvider;
import java.lang.reflect.Method;
import org.robolectric.TestLifecycleApplication;

/**
 * Created by yujuancarlos_dev on 13/03/2018.
 */

public class ApplicationTest extends ImageApplication implements TestLifecycleApplication {

  @Override public void onCreate() {
    // override Schedulers to test Rx
    super.onCreate();
  }

  @Override protected DaggerAppComponent.Builder prepareBuilder() {
    // Override modules here if needed https://artemzin.com/blog/how-to-mock-dependencies-in-unit-integration-and-functional-tests-dagger-robolectric-instrumentation/
    return super.prepareBuilder()
        .rxModule(new RxModule() {
          @Override protected SchedulerProvider providesSchedulerProvider() {
            return new TestTrampolineSchedulerProvider();
          }
        });
  }

  @Override public void beforeTest(Method method) {
    Log.d("jcyu", "before test");
  }

  @Override public void prepareTest(Object test) {
  }

  @Override public void afterTest(Method method) {

  }
}
