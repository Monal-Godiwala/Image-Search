package com.mg.imagegallery.ui.imageLIst;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mg.imagegallery.R;
import com.mg.imagegallery.data.network.ApiInterface;
import com.mg.imagegallery.data.network.ImageResponse;
import com.mg.imagegallery.ui.imageDetail.ImageDetailActivity;

import java.util.List;

class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageViewHolder> {

    Activity activity;
    List<ImageResponse.Data> images;

    public ImageListAdapter(Activity activity, List<ImageResponse.Data> images) {
        this.activity = activity;
        this.images = images;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.list_item_image, parent, false);
        return new ImageViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageViewHolder holder, int position) {
        holder.bindItems(activity, images.get(position));
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    static class ImageViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView = itemView.findViewById(R.id.image_view);
        private TextView textTitle = itemView.findViewById(R.id.text_title);
        String imageUrl;

        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void bindItems(Activity activity, ImageResponse.Data imageDetail) {

            if (imageDetail != null) {
                /** Fetch Image URL */
                if (imageDetail.getCover() != null) {
                    imageUrl = ApiInterface.IMAGE_URL + imageDetail.getCover() + ".jpg";
                } else {
                    imageUrl = imageDetail.getLink();
                }

                /** Resize image to display in list */
                if (imageUrl != null) {
                    RequestOptions options = new RequestOptions()
                            .centerCrop()
                            .override(100, 100)
                            .placeholder(R.drawable.image_load);

                    Glide.with(activity).load(imageUrl).apply(options)
                            .into(imageView);
                }

                /** Set image title */
                textTitle.setText(imageDetail.getTitle());

                /** Redirect to Image Detail screen */
                itemView.setOnClickListener(view -> {
                    Intent intent = new Intent(activity, ImageDetailActivity.class);
                    intent.putExtra("imageObject", imageDetail);
                    activity.startActivity(intent);
                });

            }


        }

    }
}
