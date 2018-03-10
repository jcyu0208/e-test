package com.example.yujuancarlos_dev.emarctest;

import android.databinding.ObservableBoolean;
import android.util.Log;
import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class MainViewModel {

  private NetworkRepository networkRepository;
  private PublishSubject<List<String>> images = PublishSubject.create();
  public ObservableBoolean isLoading = new ObservableBoolean(false);
  public List<String> imageUrls = new ArrayList<>();
  private CompositeDisposable disposables = new CompositeDisposable();
  private int page = 0;

  public MainViewModel(NetworkRepository repository) {
    this.networkRepository = repository;
  }

  private void requestImages(int page) {
    disposables.add(networkRepository.getImages(page)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(this::logImages, this::logError));

    Log.d("jcyu", "image request page = " + page);
  }

  public Observable<List<String>> observeImages() {
    return images.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
  }

  public void requestImages() {
    if (!isLoading.get() && page != -1) {
      isLoading.set(true);
      requestImages(++page);
    }
  }

  public void start() {
    requestImages();
  }

  public void stop() {
    if (disposables != null) disposables.dispose();
  }

  private void logImages(List<String> imageList) {
    isLoading.set(false);
    if (imageList != null && !imageList.isEmpty()) {
      imageUrls.addAll(imageList);
      images.onNext(imageList);

      Log.d("jcyu", "image size = " + imageUrls.size());
    }
  }

  private void logError(Throwable throwable) {
    isLoading.set(false);
    page = -1;
  }
}
