package org.addonation.kidsui;

import android.graphics.Bitmap;

public class VideoModel {
    // string course_name for storing course_name
    // and imgid for storing image id.
    private String title;
    private Bitmap thumbnail;
    private int category_id;

    public VideoModel(String title, Bitmap thumbnail) {
        this.title = title;
        this.thumbnail = thumbnail;
    }

    public String getVideoTitle() {
        return title;
    }

    public void setVideoTitle(String title) {
        this.title = title;
    }

    public Bitmap getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Bitmap thumbnail) {
        this.thumbnail = thumbnail;
    }
}
