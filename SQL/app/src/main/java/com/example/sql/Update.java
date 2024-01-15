package com.example.sql;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class Update extends AppCompatActivity {
    private EditText u_id;
    private Button btnCheckID;
    SQLiteDatabase db;
    public static final String id = "ID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        u_id = findViewById(R.id.u_id);
        btnCheckID = findViewById(R.id.btnCheck);

        btnCheckID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = u_id.getText().toString();
                if (isIDExists(id)) {
                    Intent intent = new Intent(Update.this, Update2.class);
                    intent.putExtra("ID", id);
                    startActivity(intent);
                } else {
                    showMessage("Error", "ID does not exist");
                }
            }
        });
    }

    public boolean isIDExists(String id) {
        db = openOrCreateDatabase("usersDatabase", MODE_PRIVATE, null);
        String selectQuery = "SELECT * FROM bookDetails WHERE ID = ?";
        Cursor cursor = db.rawQuery(selectQuery, new String[]{id});
        return cursor.getCount() > 0;
    }

    // Show a message in an AlertDialog
    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
