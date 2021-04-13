package com.example.songsplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends ArrayAdapter<Song>{
    private ArrayList<Song> songsList;
    public SongAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Song> objects) {
        super(context, resource, objects);
        this.songsList=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        ImageView imageView=convertView.findViewById(R.id.imageVView);
        TextView songTextview=convertView.findViewById(R.id.song_textView);
        TextView authorTextview=convertView.findViewById(R.id.author_textView);

        imageView.setImageResource(songsList.get(position).getImageId());
        songTextview.setText(songsList.get(position).getSong_name());
        authorTextview.setText(songsList.get(position).getAuthor());
        return convertView;
    }
}
