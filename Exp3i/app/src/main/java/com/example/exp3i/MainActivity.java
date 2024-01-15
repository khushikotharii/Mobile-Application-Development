package com.example.exp3i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String EM = "number";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = (Button) findViewById(R.id.b1);
        EditText ed1 = (EditText) findViewById(R.id.ed1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent I = new Intent(MainActivity.this,MainActivity2.class);
                int num = Integer.parseInt(ed1.getText().toString());
                I.putExtra(EM,num);
                startActivity(I);
            }
        });

    }
}