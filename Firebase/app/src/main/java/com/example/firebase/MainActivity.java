package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    String empName, empNum,empDept;
    Button btnSave,btnDisplay,btnUpdate,btnDelete;
    FirebaseDatabase db;
    DatabaseReference reference;

    EditText ed1,ed2,ed3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed1= findViewById(R.id.ed1);
        ed2= findViewById(R.id.ed2);
        ed3= findViewById(R.id.ed3);
        btnSave=findViewById(R.id.b1);
        btnDisplay=findViewById(R.id.b2);
        btnUpdate=findViewById(R.id.b3);
        btnDelete=findViewById(R.id.b4);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                empName = ed1.getText().toString();
                empNum= ed2.getText().toString();
                empDept=ed3.getText().toString();
                if(!empName.isEmpty() && !empNum.isEmpty() && !empDept.isEmpty()){
                    updatehelper uh = new updatehelper(empName,empNum,empDept);
                    db = FirebaseDatabase.getInstance();
                    reference =db.getReference("updatehelper");
                    reference.child(empName).setValue(uh).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            ed1.setText("");
                            ed2.setText("");
                            ed3.setText("");
                            Toast.makeText(MainActivity.this,"Data Added",Toast.LENGTH_LONG).show();
                        }
                    });

                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,Update.class);
                startActivity(i);
            }
        });




    }
}