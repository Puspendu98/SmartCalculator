package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import org.joda.time.Period;
import org.joda.time.PeriodType;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivityAgeC extends AppCompatActivity {

    private Button dobbtn, calculatebtn;
    private TextView todaytxt, dobtxt, agetxt;
    String mbirthday, mtoday;
    DatePickerDialog.OnDateSetListener dateSetListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_age_c);

       todaytxt = findViewById(R.id.tvtoday);
        dobtxt = findViewById(R.id.tvdob);
        agetxt = findViewById(R.id.tvage);

        dobbtn = findViewById(R.id.btndob);
        calculatebtn = findViewById(R.id.btnresult);

        Calendar calendar = Calendar.getInstance();

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        mtoday = simpleDateFormat.format(Calendar.getInstance().getTime());
        todaytxt.setText("Today: "+mtoday);

        dobbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(view.getContext(),dateSetListener,year,month,day);
                datePickerDialog.getDatePicker().setMaxDate(new Date().getTime());
                datePickerDialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                month = month + 1;
                mbirthday = dayOfMonth +"/" + month + "/" + year;
                dobtxt.setText("Birthday: "+mbirthday);
            }
        };
        calculatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mbirthday == null) {
                    Toast.makeText(getApplicationContext(),"please enter your date of birth", Toast.LENGTH_SHORT).show();
                } else {
                    SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("dd/MM/yyyy");
                    try {
                        Date date1 = simpleDateFormat1.parse(mbirthday);
                        Date date2 = simpleDateFormat1.parse(mtoday);

                        long startDate = date1.getTime();
                        long endDate = date2.getTime();

                        Period period = new Period(startDate, endDate, PeriodType.yearMonthDay());
                        int years = period.getYears();
                        int months = period.getMonths();
                        int days = period.getDays();

                        agetxt.setText("You are " + years + " years " + months + " months " + days + " days old");

                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                }

        });

    }
}