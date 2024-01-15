package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tvv = findViewById(R.id.tvv);
        File path = getApplication().getFilesDir();
        String s = path+"/"+"data";
        tvv.setText("Database Path"+s);
        try{
            db = this.openOrCreateDatabase("data",MODE_PRIVATE,null);
            db.close();
        } catch (SQLException e){
            tvv.append("Exception occurred" + e.getMessage());
        }

    }
}