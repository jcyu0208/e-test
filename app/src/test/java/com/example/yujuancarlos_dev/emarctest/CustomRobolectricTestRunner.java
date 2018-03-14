package com.example.yujuancarlos_dev.emarctest;

import java.lang.reflect.Method;
import org.junit.runners.model.InitializationError;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by yujuancarlos_dev on 13/03/2018.
 */

public class CustomRobolectricTestRunner extends RobolectricTestRunner {

  // This value should be changed as soon as Robolectric will support newer api.
  private static final int SDK_EMULATE_LEVEL = 26;
  /**
   * Creates a runner to run {@code testClass}. Looks in your working directory for your
   * AndroidManifest.xml file
   * and res directory by default. Use the {@link Config} annotation to configure.
   *
   * @param testClass the test class to be run
   * @throws InitializationError if junit says so
   */
  public CustomRobolectricTestRunner(Class<?> testClass) throws InitializationError {
    super(testClass);
  }

  @Override public Config getConfig(Method method) {
    final Config defaultConfig = super.getConfig(method);
    return new Config.Implementation(
        new int[]{SDK_EMULATE_LEVEL},
        defaultConfig.minSdk(),
        defaultConfig.maxSdk(),
        defaultConfig.manifest(),
        defaultConfig.qualifiers(),
        defaultConfig.packageName(),
        defaultConfig.abiSplit(),
        defaultConfig.resourceDir(),
        defaultConfig.assetDir(),
        defaultConfig.buildDir(),
        defaultConfig.shadows(),
        defaultConfig.instrumentedPackages(),
        ApplicationTest.class, // Here is the trick, we change application class to one with mocks.
        defaultConfig.libraries(),
        defaultConfig.constants() == Void.class ? BuildConfig.class : BuildConfig.class
    );
  }
}
