package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    EditText del_id;
    Button btnDelete;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        del_id = findViewById(R.id.del_id);
        btnDelete = findViewById(R.id.delete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String idString = del_id.getText().toString();

                if (!idString.isEmpty()) {
                    int ID = Integer.parseInt(idString);
                    deleteUser(ID);
                } else {
                    Toast.makeText(Delete.this, "Please enter a valid ID", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void deleteUser(int ID) {
        try {
            SQLiteDatabase db = openOrCreateDatabase("usersDatabase", MODE_PRIVATE, null);
            int rowsDeleted = db.delete("bookDetails", "ID=?", new String[]{String.valueOf(ID)});
            if (rowsDeleted > 0) {
                Toast.makeText(Delete.this, "Record deleted successfully", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(Delete.this, "No record with this ID found", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(Delete.this, "An error occurred while deleting the record", Toast.LENGTH_SHORT).show();
        }
    }

}
