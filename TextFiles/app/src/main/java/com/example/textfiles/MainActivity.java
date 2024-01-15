package com.example.textfiles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText ed1 = (EditText) findViewById(R.id.ed1);
    Button read = (Button) findViewById(R.id.b1);
    Button write = (Button) findViewById(R.id.b2);
    TextView tv1 = (TextView) findViewById(R.id.tv1);
    String file_name = "file.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String data = ed1.getText().toString();
                try{
                    FileOutputStream fos = openFileOutput(file_name,MODE_PRIVATE);
                    fos.write(data.getBytes());
                    fos.close();
                    Toast.makeText(MainActivity.this, "File Saved", Toast.LENGTH_SHORT).show();
                } catch (FileNotFoundException e){
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = " ";
                try{
                    FileInputStream fis = openFileInput(file_name);
                    int size = fis.available();
                    byte[]buffer= new byte[size];
                    fis.read(buffer);
                    text = new String(buffer);
                    fis.close();

                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                tv1.setText(text);
            }
        });



    }
}