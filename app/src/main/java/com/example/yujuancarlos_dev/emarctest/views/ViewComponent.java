package com.example.yujuancarlos_dev.emarctest.views;

import com.example.yujuancarlos_dev.emarctest.views.carousel.FullImageActivity;
import com.example.yujuancarlos_dev.emarctest.views.main.MainActivity;
import dagger.Subcomponent;

/**
 * Created by yujuancarlos_dev on 12/03/2018.
 */
@ViewScope
@Subcomponent(
    modules = {
        ViewModelModule.class
    }
)
public interface ViewComponent {
  void inject(MainActivity activity);
  void inject(FullImageActivity activity);
}
