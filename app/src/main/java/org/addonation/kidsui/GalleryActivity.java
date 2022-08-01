package org.addonation.kidsui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    private ImageButton backBtn;

    private RecyclerView recyclerView;
    private ArrayList<VideoModel> recyclerDataArrayList;
    private static final int STORAGE_PERMISSION_CODE = 101;
    private String categoryIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        this.categoryIndex = String.valueOf(bundle.getInt("number"));
        TextView titleView = (TextView) findViewById(R.id.titleText);
        titleView.setText(title);

        backBtn = (ImageButton)findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        recyclerView=findViewById(R.id.videoGrid);

        // created new array list..
        recyclerDataArrayList=new ArrayList<>();

        File sdCard = new File(Environment.getExternalStoragePublicDirectory("Videos").toString());
        searchVid(sdCard);

        // added data from arraylist to adapter class.
        RecyclerViewAdapter adapter=new RecyclerViewAdapter(recyclerDataArrayList, new RecyclerViewAdapter.OnItemClickListener() {
            @Override public void onItemClick(VideoModel item) {
                Intent intent = new Intent(getApplicationContext(), VideoPlayerActivity.class);
                intent.putExtra("filename", item.getVideoTitle());
                startActivity(intent);
            }
        });

        // setting grid layout manager to implement grid view.
        // in this method '2' represents number of columns to be displayed in grid view.
        GridLayoutManager layoutManager=new GridLayoutManager(this,4);

        // at last set adapter to recycler view.
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }
    public void searchVid(File dir) {
        String pattern = ".mp4";
        //Get the listfile of that flder
        final File listFile[] = dir.listFiles();

        if (listFile != null) {
            for (int i = 0; i < listFile.length; i++) {
                if (listFile[i].isFile()) {
                    if (listFile[i].getName().endsWith(pattern) && listFile[i].getName().contains(this.categoryIndex+"_")) {
                        // Do what ever u want, add the path of the video to the list
                        Bitmap bitmap = this.loadVideoThumbnail(listFile[i].getAbsolutePath().toString());
                        recyclerDataArrayList.add(new VideoModel(listFile[i].getName(),bitmap));
                    }
                }
            }
        }
    }

    public static Bitmap loadVideoThumbnail(String path)
    {
        Bitmap bitmap = null;
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        try
        {
            retriever.setDataSource(path);
            byte[] data = retriever.getEmbeddedPicture();
            if (data != null)
            {
                bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            }
            if (bitmap == null)
            {
                bitmap = retriever.getFrameAtTime();
            }
        } catch (IllegalArgumentException e)
        {
            Log.e("Error!", "MediaMetadataRetriever.setDataSource() fail:" + e.getMessage());
        }
        retriever.release();
        return bitmap;
    }
}