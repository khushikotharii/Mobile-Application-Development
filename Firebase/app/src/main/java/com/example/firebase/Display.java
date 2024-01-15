package com.example.firebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.cert.PolicyNode;
import java.util.ArrayList;

public class Display extends AppCompatActivity {

    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        lv = findViewById(R.id.lv);

        final ArrayList<String> list = new ArrayList<>();
        ArrayAdapter ad = new ArrayAdapter(this,R.layout.items_list,R.id.tv,list);
        lv.setAdapter(ad);
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("updatehelper");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot parent) {
                list.clear();

                for(DataSnapshot child : parent.getChildren()){
                    updatehelper info = child.getValue(updatehelper.class);
                    String txt = info.getName()+":"+info.getNumber()+":"+info.getDept();
                    list.add(txt);
                }
                ad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}