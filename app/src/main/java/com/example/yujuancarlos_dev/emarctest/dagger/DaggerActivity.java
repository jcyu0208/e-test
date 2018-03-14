package com.example.yujuancarlos_dev.emarctest.dagger;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yujuancarlos_dev on 12/03/2018.
 */

public abstract class DaggerActivity<SUB, PARENT> extends AppCompatActivity {

  protected SUB subComponent;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  protected abstract void initializeDagger(PARENT parentComponent, SUB containingComponent);

  protected abstract SUB getSubComponent(PARENT parentComponent);

  protected DaggerApp getDaggerApp() {
    return (DaggerApp) getApplication();
  }
}
