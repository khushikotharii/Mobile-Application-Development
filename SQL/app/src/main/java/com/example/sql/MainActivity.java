package com.example.sql;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnInsert,btnDisplay,btnDelete,btnUpdate;
    SQLiteDatabase db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnDisplay = (Button) findViewById(R.id.displayBtn);
        btnDelete = (Button) findViewById(R.id.deleteBtn);
        btnUpdate = (Button) findViewById(R.id.updateButton);
        btnInsert = (Button) findViewById(R.id.insertBtn);

        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db1 = openOrCreateDatabase("usersDatabase", MODE_PRIVATE, null);
                try {
                    String selectQuery = "SELECT * FROM bookDetails";
                    Cursor cursor = db1.rawQuery(selectQuery, null);
                    if (cursor.getCount() == 0) {
                        showMessage("Error", "No records found");
                        return;
                    }
                    StringBuffer buffer = new StringBuffer();
                    while (cursor.moveToNext()) {
                        String n = cursor.getString(0);
                        String no = cursor.getString(1);
                        String de = cursor.getString(2);

                        buffer.append("Name " + n + "\n");
                        buffer.append("ID " + no + "\n");
                        buffer.append("Genre " + de + "\n");
                    }
                    showMessage("Book Details", buffer.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                    showMessage("Error", "An error occurred while fetching records");
                } finally {
                    db1.close(); // Close the database connection when done.
                }
            }

            public void showMessage(String title, String message) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle(title);
                builder.setMessage(message);
                builder.show();
            }
        });


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SaveandInsert.class);
                startActivity(intent);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_d = new Intent(MainActivity.this,Delete.class);
                startActivity(i_d);
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Update.class);
                startActivity(intent1);
            }
        });

    }
}

