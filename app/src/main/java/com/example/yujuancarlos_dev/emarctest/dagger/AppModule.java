package com.example.yujuancarlos_dev.emarctest.dagger;

import android.content.Context;
import android.content.res.Resources;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Module
@Singleton
public class AppModule {
  private Context context;

  public AppModule(Context context) {
    this.context = context;
  }

  @Singleton
  @Provides
  public Context providesContext() {
    return context;
  }

  @Singleton
  @Provides
  public Resources providesResources() {
    return context.getResources();
  }
}
