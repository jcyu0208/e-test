package com.example.yujuancarlos_dev.emarctest.network;

import io.reactivex.Single;
import java.util.List;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public interface ImageApi {

  @GET("images/{page}")
  Single<List<String>> getImageList(@Path("page") int page);
}
