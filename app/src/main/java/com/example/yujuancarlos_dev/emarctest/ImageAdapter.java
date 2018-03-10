package com.example.yujuancarlos_dev.emarctest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.telecom.Call;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yujuancarlos_dev on 10/03/2018.
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

  List<String> images = new ArrayList<>();
  Callback callback;

  public interface Callback {
    void onItemClicked(int position);
  }

  public ImageAdapter(List<String> urls, Callback callback) {
    this.images = new ArrayList<>(urls);
    this.callback = callback;
  }

  @Override public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
    return new ImageViewHolder(view);
  }

  @Override public void onBindViewHolder(ImageViewHolder holder, int position) {
    holder.setImageUrl(images.get(position));
    holder.itemView.setOnClickListener(v -> {
      if(callback != null)callback.onItemClicked(position);
    });
  }

  @Override public int getItemCount() {
    return images.size();
  }

  @Override public int getItemViewType(int position) {
    return R.layout.list_image;
  }

  public void add(List<String> imageUrls) {
    int currentSize = images.size();
    images.addAll(imageUrls);
    notifyDataSetChanged();
  }

  public void set(List<String> imageUrls) {
    images = new ArrayList<>(imageUrls);
    notifyDataSetChanged();
  }

  public static class ImageViewHolder extends RecyclerView.ViewHolder {

    private String imageUrl;

    public ImageViewHolder(View itemView) {
      super(itemView);
    }

    void setImageUrl(String imageUrl) {
      this.imageUrl = imageUrl;

      Glide.with(itemView)
          .load(imageUrl)
          .into((ImageView) itemView);
    }
  }
}
