package com.hktstudio.vd.activities;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.hktstudio.vd.R;
import com.hktstudio.vd.dataloaders.SongLoader;
import com.hktstudio.vd.models.Song;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity{
    Button btnPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addPermission();
    }

    void setControl(){
        btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phatNhac();
            }
        });
    }

    void phatNhac(){
//        MediaPlayer mediaPlayer = MediaPlayer.create(this,R.raw.tancungnoinho);
//        mediaPlayer.start();
        List<Song> list = SongLoader.getListSongs(this);
        Song song = list.get(2);
        String path = song.getPath();
        MediaPlayer mediaPlayer = MediaPlayer.create(this, Uri.parse(path));
        mediaPlayer.start();
    }

    void addPermission() {
        ActivityCompat.requestPermissions(MainActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                1);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    setControl();

                } else {

                    Toast.makeText(MainActivity.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                }

                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

}