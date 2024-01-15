package com.example.radiobuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioGroup rgg;
    RadioButton rbb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rgg = findViewById(R.id.rg);
    }
    public void Checked(View view){
        int rid= rgg.getCheckedRadioButtonId();
        rbb = findViewById(rid);
        Toast.makeText(this,"Radio Button Selected" + rbb.getText(),Toast.LENGTH_LONG).show();


    }
}