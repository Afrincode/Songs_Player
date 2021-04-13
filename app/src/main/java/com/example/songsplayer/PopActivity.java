package com.example.songsplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class PopActivity extends AppCompatActivity {
    MediaPlayer mplayer;
    MediaPlayer.OnCompletionListener onCompletionListener=new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop);

        final ArrayList<Song> pop_songs_list=new ArrayList<Song>();
        pop_songs_list.add(new Song("Go Crazy","Chris Brown-2020",R.drawable.go_crazy,R.raw.go_crazy));
        pop_songs_list.add(new Song("See You Again","Wiz Khalifa-2015",R.drawable.see_u_again,R.raw.see_you_again));
        pop_songs_list.add(new Song("Circles","Post Malone-2019",R.drawable.circles,R.raw.circles));
        pop_songs_list.add(new Song("Counting Stars","OneRepublic-2013",R.drawable.counting_stars,R.raw.counting_stars));
        pop_songs_list.add(new Song("Uptown Funk","Mark Ronson-2014",R.drawable.uptown_funk,R.raw.uptownfunk));

        ListView popslistview=(ListView)findViewById(R.id.poprootview);
        SongAdapter popsongAdapter=new SongAdapter(getApplicationContext(),R.layout.list_item,pop_songs_list);
        popslistview.setAdapter(popsongAdapter);
        popslistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mplayer=MediaPlayer.create(PopActivity.this,pop_songs_list.get(position).getSongId());
                mplayer.start();
                mplayer.setOnCompletionListener(onCompletionListener);
               // Toast.makeText(PopActivity.this,"list item clicked",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    public void releaseMediaPlayer()
    {
        if(mplayer!=null)
        {
            mplayer.release();
            mplayer=null;
        }
    }
}
