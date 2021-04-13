package com.example.songsplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void poplist(View view)
    {
        Intent in=new Intent(this,PopActivity.class);
        startActivity(in);
    }

    public void coollist(View view) {
        Intent in=new Intent(this,CoolActivity.class);
        startActivity(in);
    }
}
