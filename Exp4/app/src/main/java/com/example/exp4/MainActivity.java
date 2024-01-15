package com.example.exp4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    String vegetables[] = {"Brinjal", "Onion", "Cabbage", "Carrot"};
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    int images[] = {R.drawable.brinjal, R.drawable.onion, R.drawable.cabbage, R.drawable.carrot};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDatePicker();
        dateButton = findViewById(R.id.btn_1);
        dateButton.setText(getTodaysDate());

        ListView listView = findViewById(R.id.lv1);
        List<HashMap<String,String>> li = new ArrayList<>();

        for (int i = 0; i < vegetables.length; i++) {
            HashMap<String, String> hm = new HashMap<>();
            hm.put("name", vegetables[i]);
            hm.put("image", images[i] + "");
            li.add(hm);
        }

        String[] from = {"name", "image"};
        int[] to = {R.id.tv1, R.id.img_view}; // Corrected IDs

        SimpleAdapter SA = new SimpleAdapter(this, li, R.layout.items_list, from, to);
        listView.setAdapter(SA);
    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month+1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(dayOfMonth,month,year);

    }

    private String makeDateString(int dayOfMonth, int month, int year) {
        return getMonthFormat(month) +" "+dayOfMonth+" "+year;

    }

    private String getMonthFormat(int month) {
        if(month==1){
            return "JAN";
        }
        if(month==2){
            return "FEB";
        }
        if(month==3){
            return "MAR";
        }
        if(month==4){
            return "APR";
        }
        if(month==5){
            return "MAY";
        }
        if(month==6){
            return "JUN";
        }
        if(month==7){
            return "JUL";
        }
        if(month==8){
            return "AUG";
        }
        if(month==9){
            return "SEP";
        }
        if(month==10){
            return "OCT";
        }
        if(month==11){
            return "NOV";
        }
        if(month==12){
            return "DEC";
        }
        return "JAN";
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dsl = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = makeDateString(dayOfMonth, month, year);
                dateButton.setText(date);

            }
        };
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this,dsl,year,month,dayOfMonth);



    }
    public void startDatePicker(View view){
        datePickerDialog.show();
    }
}
