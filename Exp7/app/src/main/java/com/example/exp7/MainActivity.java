package com.example.exp7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String Name = "name";
    public static final String Dept = "department";
    public static final String Dob = "dob";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText ed1 = findViewById(R.id.ed1);
        EditText ed2 = findViewById(R.id.ed2);
        Button b1 = findViewById(R.id.b1);
        TextView tv1 = findViewById(R.id.tv1);
        DatePicker datePicker = findViewById(R.id.datepicker);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get the values from the EditText fields and DatePicker
                String name = ed1.getText().toString().trim();
                String department = ed2.getText().toString().trim();
                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth() + 1;
                int year = datePicker.getYear();
                String dob = String.format("%02d/%02d/%04d", day, month, year);

                //Validation
                if (name.isEmpty()) {
                    ed1.setError("Name is required");
                    ed1.requestFocus();
                } else if (department.isEmpty()) {
                    ed2.setError("Department is required");
                    ed2.requestFocus();
                } else {
                    Intent i = new Intent(MainActivity.this, MainActivity2.class);
                    i.putExtra(Name, name);
                    i.putExtra(Dept, department);
                    i.putExtra(Dob, dob);
                    startActivity(i);
                }
            }
        });

    }
}