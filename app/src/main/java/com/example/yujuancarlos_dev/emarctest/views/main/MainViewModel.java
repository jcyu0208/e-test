package com.example.yujuancarlos_dev.emarctest.views.main;

import android.databinding.ObservableBoolean;
import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import com.example.yujuancarlos_dev.emarctest.rx.SchedulerProvider;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class MainViewModel {

  private NetworkRepository networkRepository;
  private PublishSubject<List<String>> images = PublishSubject.create();
  private CompositeDisposable disposables = new CompositeDisposable();
  private SchedulerProvider scheduler;
  private int page = 0;

  ObservableBoolean isLoading = new ObservableBoolean(false);
  List<String> imageUrls = new ArrayList<>();

  public MainViewModel(NetworkRepository repository, SchedulerProvider scheduler) {
    this.networkRepository = repository;
    this.scheduler = scheduler;
  }

  void requestImages() {
    if (!isLoading.get() && page != -1) {
      isLoading.set(true);
      requestImages(++page);
    }
  }

  Observable<List<String>> observeImages() {
    return images.subscribeOn(scheduler.io()).observeOn(scheduler.ui());
  }

  void start() {
    requestImages();
  }

  void stop() {
    if (disposables != null) disposables.dispose();
  }

  private void requestImages(int page) {
    Disposable disposable = networkRepository.getImages(page)
        .subscribeOn(scheduler.io())
        .observeOn(scheduler.ui())
        .subscribe(this::logImages, this::logError);

    disposables.add(disposable);
  }

  protected void logImages(List<String> imageList) {
    isLoading.set(false);
    if (imageList != null && !imageList.isEmpty()) {
      imageUrls.addAll(imageList);
      images.onNext(imageList);
    }
  }

  protected void logError(Throwable throwable) {
    isLoading.set(false);
    page = -1;
  }
}
