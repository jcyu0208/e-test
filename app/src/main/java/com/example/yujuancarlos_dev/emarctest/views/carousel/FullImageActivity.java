package com.example.yujuancarlos_dev.emarctest.views.carousel;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import com.example.yujuancarlos_dev.emarctest.views.ImageAdapter;
import com.example.yujuancarlos_dev.emarctest.R;
import com.example.yujuancarlos_dev.emarctest.databinding.ActivityMainBinding;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class FullImageActivity extends AppCompatActivity {

  private static final String EXTRA_IMAGES = "images";
  private static final String EXTRA_POSITION = "position";
  private static final String EXTRAS = "extras";
  public static Intent newIntent(List<String> urls, int position, Context context) {
    Intent intent = new Intent(context, FullImageActivity.class);
    Bundle bundle = new Bundle();
    bundle.putSerializable(EXTRA_IMAGES, (ArrayList) urls);
    bundle.putInt(EXTRA_POSITION, position);
    intent.putExtras(bundle);
    return intent;
  }

  private ActivityMainBinding binding;
  private ImageAdapter imageAdapter;
  private List<String> urls = new ArrayList<>();
  private int position = 0;

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if(getIntent().getExtras() != null) {
      urls = (ArrayList<String>) getIntent().getExtras().getSerializable(EXTRA_IMAGES);
      position = getIntent().getExtras().getInt(EXTRA_POSITION);
    }


    binding = DataBindingUtil.inflate(getLayoutInflater(), R.layout.activity_main, null, false);
    setContentView(binding.getRoot());
    initializeUi();
  }

  private void initializeUi() {
    LinearLayoutManager llm = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
    binding.imageList.setLayoutManager(llm);

    imageAdapter = new ImageAdapter(urls, null);
    binding.imageList.setAdapter(imageAdapter);
    binding.imageList.getLayoutManager().scrollToPosition(position);
  }
}
