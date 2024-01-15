package com.example.arrayadaptor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity2 extends AppCompatActivity {

    String details[] = {"Khushi Kothari","9559999750", "kkothari0803@gmail.com","BTech CE", "STME", "NMIMS NAVI MUMBAI"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ListView lv1 = findViewById(R.id.lv);
        ArrayAdapter<String> add = new ArrayAdapter<>(this,R.layout.itemlist,R.id.tv3,details);
        lv1.setAdapter(add);

    }
}