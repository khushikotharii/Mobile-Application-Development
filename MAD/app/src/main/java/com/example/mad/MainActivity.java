package com.example.mad;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b1 = findViewById(R.id.btn1);
        Button b2 = findViewById(R.id.btn2);
        Button b3 = findViewById(R.id.btn3);
        Button b4 = findViewById(R.id.btn4);
        Button b = (Button) findViewById(R.id.btn1);
        EditText edt1 = (EditText) findViewById(R.id.edt1);
        EditText edt2 = (EditText) findViewById(R.id.edt2);
        TextView tv1  = (TextView) findViewById(R.id.tv1);
        TextView tv2  = (TextView) findViewById(R.id.tv2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int sum = n1 + n2;
                tv2.setText(sum+" ");
                Toast.makeText(MainActivity.this,"Addition Successful",Toast.LENGTH_LONG).show();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int sub = n1 - n2;
                tv2.setText(sub+" ");
                Toast.makeText(MainActivity.this,"Subtraction Successful",Toast.LENGTH_LONG).show();
            }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int mul = n1 * n2;
                tv2.setText(mul+" ");
                Toast.makeText(MainActivity.this,"Multiplication Successful!",Toast.LENGTH_LONG).show();
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int n1 = Integer.parseInt(edt1.getText().toString());
                int n2 = Integer.parseInt(edt2.getText().toString());
                int div = n1 / n2;
                tv2.setText(div+" ");
                Toast.makeText(MainActivity.this,"Division Successful!",Toast.LENGTH_LONG).show();
            }
        });
    }
}