package com.example.yujuancarlos_dev.emarctest.network;

import android.content.Context;
import com.example.yujuancarlos_dev.emarctest.network.ImageApi;
import com.example.yujuancarlos_dev.emarctest.network.NetworkRepository;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

@Singleton @Module
public class NetworkModule {

  @Provides
  @Singleton
  protected Retrofit providesRetrofit() {
    OkHttpClient client = new OkHttpClient.Builder().build();
    return new Retrofit.Builder()
        .client(client)
        .baseUrl("https://lit-earth-91645.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build();
  }

  @Provides
  @Singleton
  protected ImageApi providesImageApi(Retrofit retrofit) {
    return retrofit.create(ImageApi.class);
  }

  @Provides
  @Singleton
  protected NetworkRepository providesRepository(ImageApi imageApi, Context context) {
    return new NetworkRepository(imageApi);
  }
}
