package com.example.yujuancarlos_dev.emarctest.network;

import io.reactivex.Single;
import java.util.List;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class NetworkRepository {

  private ImageApi imageApi;

  public NetworkRepository(ImageApi imageApi) {
    this.imageApi = imageApi;
  }

  public Single<List<String>> getImages(int page) {
    return imageApi.getImageList(page);
  }
}
