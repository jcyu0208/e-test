package com.example.yujuancarlos_dev.emarctest;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import com.example.yujuancarlos_dev.emarctest.databinding.ActivityMainBinding;
import dagger.android.AndroidInjection;
import io.reactivex.disposables.CompositeDisposable;
import java.util.List;
import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements ImageAdapter.Callback{

  @Inject MainViewModel mainViewModel;

  private ActivityMainBinding binding;
  private ImageAdapter imageAdapter;

  private CompositeDisposable disposables = new CompositeDisposable();

  private int previousTotal = 0;
  private int visibleThreshold = 5;
  int firstVisibleItem, visibleItemCount, totalItemCount;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    AndroidInjection.inject(this);
    binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
    setContentView(binding.getRoot());
    initializeUi();
    observe();
  }

  private void initializeUi() {
    GridLayoutManager glm = new GridLayoutManager(this, 3, LinearLayoutManager.VERTICAL, false);
    binding.imageList.setLayoutManager(glm);

    imageAdapter = new ImageAdapter(mainViewModel.imageUrls,this);
    binding.imageList.setAdapter(imageAdapter);

    binding.imageList.addOnScrollListener(new RecyclerView.OnScrollListener() {

      @Override
      public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        visibleItemCount = binding.imageList.getChildCount();
        totalItemCount = glm.getItemCount();
        firstVisibleItem = glm.findFirstVisibleItemPosition();

        if (!mainViewModel.isLoading.get() && (totalItemCount - visibleItemCount)
            <= (firstVisibleItem + visibleThreshold)) {
          // End has been reached

          Log.d("jcyu", "end called");

          // Do something
          mainViewModel.requestImages();
        }
      }
    });
  }

  private void observe() {
    disposables.add(mainViewModel.observeImages().subscribe(this::addImages));
  }

  @Override protected void onStart() {
    super.onStart();
    mainViewModel.start();
  }

  @Override protected void onStop() {
    super.onStop();
    mainViewModel.stop();
    disposables.dispose();
  }

  private void addImages(List<String> images) {
    imageAdapter.add(images);
  }

  @Override public void onItemClicked(int position) {
    startActivity(FullImageActivity.newIntent(mainViewModel.imageUrls, position, this));
  }
}
