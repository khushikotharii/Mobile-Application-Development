package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class Update extends AppCompatActivity {

    EditText ed1,ed2,ed3;
    Button b1;
    String empName,empNo,empDept;

    FirebaseDatabase db;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        ed1=findViewById(R.id.ed1);
        ed2=findViewById(R.id.ed2);
        ed3=findViewById(R.id.ed3);
        b1=findViewById(R.id.update);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empName=ed1.getText().toString();
                empNo=ed2.getText().toString();
                empDept=ed3.getText().toString();
                updateData(empName,empNo,empDept);
            }

            private void updateData(String empName, String empNo, String empDept) {
                HashMap user = new HashMap<>();
                user.put("dept",empDept);
                user.put("name",empName);
                user.put("number",empNo);
                db = FirebaseDatabase.getInstance();
                reference =db.getReference("updatehelper");
                reference.child(empName).updateChildren(user).addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        ed1.setText("");
                        ed2.setText("");
                        ed3.setText("");
                        Toast.makeText(Update.this,"Data Updated",Toast.LENGTH_LONG).show();
                    }
                });

            }
        });

    }
}