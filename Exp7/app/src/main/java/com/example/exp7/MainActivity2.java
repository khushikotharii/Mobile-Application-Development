package com.example.exp7;

import static com.example.exp7.MainActivity.Dept;
import static com.example.exp7.MainActivity.Dob;
import static com.example.exp7.MainActivity.Name;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    EditText ed3;
    Button read;
    Button write;
    TimePicker timePicker;
    TextView tv;
    String file_name = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Initialize your views here after setContentView
        ed3 = findViewById(R.id.ed3);
        read = findViewById(R.id.read);
        write = findViewById(R.id.write);
        timePicker = findViewById(R.id.timepicker);
        tv = findViewById(R.id.tv);

        Intent i2 = getIntent();
        String name = i2.getStringExtra(Name);
        String department = i2.getStringExtra(Dept);
        String dob = i2.getStringExtra(Dob);

        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour = timePicker.getHour();
                int minute = timePicker.getMinute();
                String time = String.format("%02d:%02d", hour, minute);
                String data = ed3.getText().toString().trim(); // Trim to remove leading/trailing whitespace

                //Validation
                if (data.isEmpty()) {
                    ed3.setError("Data cannot be empty");
                    ed3.requestFocus();
                } else {
                    String output = name + " " + department + " " + dob + " " + time + " " + data;
                    try {
                        FileOutputStream fos = openFileOutput(file_name, MODE_PRIVATE);
                        fos.write(output.getBytes());
                        fos.close();
                        Toast.makeText(MainActivity2.this, "File Saved", Toast.LENGTH_SHORT).show();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });


        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = " ";
                try {
                    FileInputStream fis = openFileInput(file_name);
                    int size = fis.available();
                    byte[] buffer = new byte[size];
                    fis.read(buffer);
                    text = new String(buffer);
                    fis.close();

                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                tv.setText(text);
            }
        });
    }
}
