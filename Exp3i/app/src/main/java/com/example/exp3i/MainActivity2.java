package com.example.exp3i;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tvv1 = (TextView) findViewById(R.id.tv2);
        Intent I2 = getIntent();
        int n = I2.getIntExtra(MainActivity.EM, 0);
        if (n > 0) {
            double sum = calculateSeriesSum(n);
            tvv1.setText(String.format("Sum of the series: %.2f", sum));
        }

    }
    private double calculateSeriesSum(int n) {
        double sum = 0.0;
        for (int i = 1; i <= n; i++) {
            sum += 1.0 / i;
        }
        return sum;
    }
}