package org.addonation.kidsui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private static final int STORAGE_PERMISSION_CODE  = 101;

    private ImageButton toysBtn;
    private ImageButton songsBtn;
    private ImageButton petsBtn;
    private ImageButton worldTravleBtn;
    private ImageButton schoolLifeBtn;
    private ImageButton animationBtn;
    private ImageButton friendsBtn;
    private ImageButton educationBtn;

    private ImageButton cameraBtn;
    private ImageButton videoBtn;
    private ImageButton settingsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        if (ContextCompat.checkSelfPermission(MainActivity.this, permission) == PackageManager.PERMISSION_DENIED) {

            // Requesting the permission
            ActivityCompat.requestPermissions(MainActivity.this, new String[] { permission }, STORAGE_PERMISSION_CODE);
        }

        toysBtn = (ImageButton)findViewById(R.id.toysButton);
        toysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Toys");
                intent.putExtra("number", 1);
                startActivity(intent);
            }
        });

        songsBtn = (ImageButton)findViewById(R.id.songsButton);
        songsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Songs");
                intent.putExtra("number", 2);
                startActivity(intent);
            }
        });

        petsBtn = (ImageButton)findViewById(R.id.petsButton);
        petsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Pets");
                intent.putExtra("number", 3);
                startActivity(intent);
            }
        });

        worldTravleBtn = (ImageButton)findViewById(R.id.worldTravelButton);
        worldTravleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "World Travel");
                intent.putExtra("number", 4);
                startActivity(intent);
            }
        });

        schoolLifeBtn = (ImageButton)findViewById(R.id.schoolLifeButton);
        schoolLifeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "School Life");
                intent.putExtra("number", 5);
                startActivity(intent);
            }
        });

        animationBtn = (ImageButton)findViewById(R.id.animationButton);
        animationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Animation");
                intent.putExtra("number", 6);
                startActivity(intent);
            }
        });

        friendsBtn = (ImageButton)findViewById(R.id.friendsButton);
        friendsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Friends");
                intent.putExtra("number", 7);
                startActivity(intent);
            }
        });

        educationBtn = (ImageButton)findViewById(R.id.educationsButton);
        educationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GalleryActivity.class);
                intent.putExtra("title", "Education");
                intent.putExtra("number", 8);
                startActivity(intent);
            }
        });

        cameraBtn = (ImageButton)findViewById(R.id.cameraButton);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        });

        videoBtn = (ImageButton)findViewById(R.id.videoButton);
        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        });

        settingsBtn = (ImageButton)findViewById(R.id.settingButton);
        settingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent dialogIntent = new Intent(android.provider.Settings.ACTION_SETTINGS);
                dialogIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(dialogIntent);
            }
        });

    }
}