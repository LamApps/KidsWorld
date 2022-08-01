package org.addonation.kidsui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(VideoModel item);
    }

    private ArrayList<VideoModel> videoArrayList;
    private final OnItemClickListener listener;

    public RecyclerViewAdapter(ArrayList<VideoModel> recyclerDataArrayList, OnItemClickListener listener) {
        this.videoArrayList = recyclerDataArrayList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        VideoModel recyclerData = videoArrayList.get(position);
        String filename = recyclerData.getVideoTitle();
        String title = filename.split("_")[1];
        title = title.replace(".mp4", "");
        Log.d("-------title", title);
        holder.itemTitle.setText(title);
        holder.itemThumbnail.setImageBitmap(recyclerData.getThumbnail());
        holder.bind(videoArrayList.get(position), listener);
    }

    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return videoArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView itemTitle;
        private ImageView itemThumbnail;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            itemTitle = itemView.findViewById(R.id.itemTitle);
            itemThumbnail = itemView.findViewById(R.id.itemThumbnail);
        }
        public void bind(final VideoModel item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }
    }
}
