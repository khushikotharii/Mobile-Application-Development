package com.example.factorial;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edt1 = findViewById(R.id.edt1);
        TextView tv2 = findViewById(R.id.tv2);
        TextView tv3 = findViewById(R.id.tv3);
        Button bt1 = findViewById(R.id.b1);
        Button bt2 = findViewById(R.id.b2);

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Fetch the input number from the EditText field
                String inputText = edt1.getText().toString();

                if (!inputText.isEmpty()) {
                    int num = Integer.parseInt(inputText);
                    long f = 1;
                    for (int i = num; i > 0; i--) {
                        f = f * i;
                    }

                    tv2.setText("Factorial of " + num + " is " + f);
                } else {
                    tv2.setText("Enter a number!");
                }
            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText1 = edt1.getText().toString();
                if (!inputText1.isEmpty()) {
                    int num1 = Integer.parseInt(inputText1);
                    if (num1 % 2 == 0) {
                        tv3.setText(num1 + " is an Even Number!");
                    } else {
                        tv3.setText(num1 + " is an Odd Number!");
                    }
                }
            }
        });
    }
}





