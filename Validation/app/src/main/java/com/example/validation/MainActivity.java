package com.example.validation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b = (Button) findViewById(R.id.b1);
        EditText ed = (EditText) findViewById(R.id.ed1);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = ed.getText().toString();
                if(s.length()==0){
                    ed.requestFocus();
                    ed.setError("Field cannot be empty!");
                } else if(!s.matches("[a-zA-Z]+")) {
                    ed.requestFocus();
                    ed.setError("Alphabetical Characters should be used.");
                } else
                {
                    Toast.makeText(MainActivity.this,"Validation Done",Toast.LENGTH_LONG).show();
                }

            }
        });

    }
}

