package com.example.datepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp = (DatePicker) findViewById(R.id.dp);
        submit =(Button) findViewById(R.id.submitButton);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String day = "Day = " + dp.getDayOfMonth();
                String month = "Month = " + (dp.getMonth() + 1);
                String year = "Year = " + dp.getYear();

                Toast.makeText(getApplicationContext(), day+ "\n" + month + "\n" + year + "\n", Toast.LENGTH_LONG).show();

            }
        });
    }
}