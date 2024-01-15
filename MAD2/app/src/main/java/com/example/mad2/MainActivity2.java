package com.example.mad2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvv1 = (TextView) findViewById(R.id.result);
        Intent I2 = getIntent();
        int fi = I2.getIntExtra(MainActivity.EM,0);
        if(fi%2==0){
            tvv1.setText("Even Number!"+"");
        }
        else {
            tvv1.setText("Odd Number!");
        }
    }
}