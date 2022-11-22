package com.rafaellibrero.programacionmultimedia.ui.help;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.rafaellibrero.programacionmultimedia.DrawerNavigation;
import com.rafaellibrero.programacionmultimedia.MainActivity;
import com.rafaellibrero.programacionmultimedia.R;

public class HelpActivity extends AppCompatActivity {

    private VideoView videoView;
    private MediaController mediaController;
    private Button iniciar, volver;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        videoView = findViewById(R.id.videoview);
        iniciar = findViewById(R.id.btIniciar);
        volver = findViewById(R.id.btVolver);

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

        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelpActivity.this, MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}