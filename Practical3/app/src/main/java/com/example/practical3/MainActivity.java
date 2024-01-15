package com.example.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CheckBox bread, butter, jam, cheese;
        Button b1;

        bread = (CheckBox) findViewById(R.id.checkBox1);
        butter = (CheckBox) findViewById(R.id.checkBox2);
        jam = (CheckBox) findViewById(R.id.checkBox3);
        cheese = (CheckBox) findViewById(R.id.checkBox4);
        b1 = (Button) findViewById(R.id.b1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int totalItems = 0;
                StringBuilder result = new StringBuilder();
                result.append("Selected Items: ");
                if(bread.isChecked()){
                    result.append("\nYou ordered Bread");
                    totalItems+=1;
                }
                if (butter.isChecked()) {
                    result.append("\nYou ordered Butter");
                    totalItems+=1;
                }
                if (jam.isChecked()) {
                    result.append("\nYou ordered Jam");
                    totalItems+=1;
                }
                if (cheese.isChecked()) {
                    result.append("\nYou ordered Cheese");
                    totalItems+=1;
                }
                result.append("\nTotal Items Ordered: " + totalItems);
                Toast.makeText(getApplicationContext(),result.toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}