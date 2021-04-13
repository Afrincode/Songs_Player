package com.example.songsplayer;

import android.widget.ArrayAdapter;

public class Song{
    private String song_name;
    private String author;
    private int imageId;
    private int songId;
    public Song(String name,String author,int image,int songid)
    {
        this.song_name=name;
        this.author=author;
        this.imageId=image;
        this.songId=songid;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getAuthor() {
        return author;
    }

    public int getImageId() {
        return imageId;
    }
    public int getSongId() {
        return songId;
    }
}
