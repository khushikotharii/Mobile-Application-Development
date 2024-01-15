package com.example.sql;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class SaveandInsert extends AppCompatActivity {

    private EditText b_name, b_no, b_genre;
    SQLiteDatabase db;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saveand_insert);

        // Initialize your database
        db = openOrCreateDatabase("usersDatabase", MODE_PRIVATE, null);

        b_name = findViewById(R.id.nameInput);
        b_no = findViewById(R.id.numberInput);
        b_genre = findViewById(R.id.genreInput);
        btnSave = findViewById(R.id.saveButton);

        if (btnSave != null) {
            btnSave.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    registerBook();
                }
            });
        }
    }

    public void registerBook() {
        String bookName;
        int bookNo;
        String bookGenre;
        bookName = b_name.getText().toString();
        bookNo = Integer.parseInt(b_no.getText().toString());
        bookGenre = b_genre.getText().toString();

        ContentValues values = new ContentValues();
        values.put("Name", bookName);
        values.put("ID", bookNo);
        values.put("Genre", bookGenre);

        long ID = db.insert("bookDetails", null, values);

        if (ID != -1) {
            Toast.makeText(SaveandInsert.this, "Record inserted with ID: " + ID, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(SaveandInsert.this, "Failed to insert record", Toast.LENGTH_SHORT).show();
        }
    }
}
