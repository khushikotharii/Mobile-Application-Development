package com.example.assignment1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = findViewById(R.id.rg);
    }
    public void Checked(View view) {
        int rid = rg.getCheckedRadioButtonId();
        rb = findViewById(rid);
        Toast.makeText(this, rb.getText(), Toast.LENGTH_LONG).show();

    }
    }