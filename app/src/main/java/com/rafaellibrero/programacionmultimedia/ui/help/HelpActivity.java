package com.rafaellibrero.programacionmultimedia.ui.help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.rafaellibrero.programacionmultimedia.R;

public class HelpActivity extends AppCompatActivity {

    VideoView videoView;
    MediaController mediaController;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        videoView = findViewById(R.id.videoview);

        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.videoplayback));
        videoView.start();

        this.mediaController = new MediaController(HelpActivity.this);

        this.videoView.setMediaController(mediaController);

        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {

                    videoView.start();


                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i1) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
    }
}