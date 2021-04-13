package com.example.songsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class CoolActivity extends AppCompatActivity {
   MediaPlayer mplayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cool);
    }
    public void playSong(View view)
    {
        if(mplayer==null)
            mplayer=MediaPlayer.create(this,R.raw.musicbit);
        mplayer.start();
    }
    public void pauseSong(View view)
    {
        if(mplayer!=null)
            mplayer.pause();
    }
    public void stopSong(View view)
    {
        stopPlayer();
        //mplayer.stop();
    }
    private void stopPlayer()
    {
        if(mplayer!=null) {
            mplayer.release();
            mplayer=null;
            Toast.makeText(this,"Media player realeased",Toast.LENGTH_LONG).show();
        }
    }
}
