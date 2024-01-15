package com.example.audiovideofiles;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b3 = findViewById(R.id.b3);
        VideoView vv1 = findViewById(R.id.vv1);
        mp = MediaPlayer.create(this,R.raw.sampleaudio);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String path = "android.resource://" + getPackageName() +"/"+ R.raw.samplevideo;
                vv1.setVideoURI(Uri.parse(path));
                vv1.start();
            }
        });

    }

    public void start(View view){
        mp.start();
    }

    public void stop(View view){
        mp.stop();
        mp = MediaPlayer.create(this,R.raw.sampleaudio);
    }
}