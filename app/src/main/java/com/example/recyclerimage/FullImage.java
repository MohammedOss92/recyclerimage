package com.example.recyclerimage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

public class FullImage extends AppCompatActivity {
    int [] imageId;
    String [] result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_image);
        Intent i = getIntent();
        int titleID = i.getExtras().getInt("id");
//        PicAdapter imageAdapter = new PicAdapter(this);
//        ImageView im=(ImageView)findViewById(R.id.imageView);
//        im.setImageResource(imageAdapter.osImages[titleID]);
        ViewPager viewPager = findViewById(R.id.viewPager);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);
    }}