package com.example.sql;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Update2 extends AppCompatActivity {
    private EditText Name, b_id, b_genre;
    private Button Update;
    private SQLiteDatabase db;

    @SuppressLint("Range")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update2);

        Name = findViewById(R.id.ed1);
        b_id = findViewById(R.id.ed2);
        b_genre = findViewById(R.id.ed3);
        Update = findViewById(R.id.b_update);

        final String id = getIntent().getStringExtra("ID");

        db = openOrCreateDatabase("usersDatabase", MODE_PRIVATE, null);
        String selectQuery = "SELECT * FROM bookDetails WHERE ID = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{id});

        if (cursor.moveToFirst()) {
            Name.setText(cursor.getString(cursor.getColumnIndex("Name")));
            b_id.setText(cursor.getString(cursor.getColumnIndex("ID")));
            b_genre.setText(cursor.getString(cursor.getColumnIndex("Genre")));
        }

        Update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = Name.getText().toString();
                String bid = b_id.getText().toString();
                String genre = b_genre.getText().toString();

                ContentValues values = new ContentValues();
                values.put("Name", name);
                values.put("ID", bid);
                values.put("Genre", genre);

                int rowsAffected = db.update("bookDetails", values, "ID = ?", new String[]{id});

                if (rowsAffected > 0) {
                    showMessage("Success", "Record updated successfully");
                } else {
                    showMessage("Error", "Failed to update record");
                }
            }
        });
    }


    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
