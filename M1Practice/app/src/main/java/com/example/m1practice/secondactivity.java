package com.example.m1practice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class secondactivity extends AppCompatActivity {

    String details[] = {"jkgdf", "shbf","hjhs"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondactivity);

        ListView lv1 = (ListView) findViewById(R.id.lv);
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this,R.layout.itemlist,R.id.tv3,details);
        lv1.setAdapter(ad);
    }
}