package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private Button one, two, three, four, five, six, seven, eight, nine, zero, plus, minus, multi, devision;
    private Button clear, back, equal, point;
    private TextView textview;
    private final char ADDITION='+', SUBTRACTION='-', MULTIPLICATION='x', DEVISION='/', EQUAL= '=';
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        setupUIView();

        zero.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + "9");
            }
        });
        point.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                textview.setText(textview.getText().toString() + ".");
            }
        });

        plus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = ADDITION;
                textview.setText(String.valueOf(val1));
                textview.setText(null);
            }
        });
        multi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = MULTIPLICATION;
                textview.setText(String.valueOf(val1));
                textview.setText(null);
            }
        });
        minus.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = SUBTRACTION;
                textview.setText(String.valueOf(val1));
                textview.setText(null);
            }
        });
        devision.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = DEVISION;
                textview.setText(String.valueOf(val1));
                textview.setText(null);
            }
        });
        equal.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION = EQUAL;
                textview.setText(String.valueOf(val1));

            }
        });
        back.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textview.getText().length()>0)
                {
                    CharSequence name = textview.getText().toString();
                    textview.setText(name.subSequence(0, name.length()-1));
                }
                else
                {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    textview.setText(null);
                }
            }
        });
        clear.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                val1 = Double.NaN;
                val2 = Double.NaN;
                textview.setText(null);
            }
        });


    }

    private void setupUIView()
    {
        one = (Button) findViewById(R.id.buttonid1);
        two = (Button) findViewById(R.id.buttonid2);
        three = (Button) findViewById(R.id.buttonid3);
        four = (Button) findViewById(R.id.buttonid4);
        five = (Button) findViewById(R.id.buttonid5);
        six = (Button) findViewById(R.id.buttonid6);
        seven = (Button) findViewById(R.id.buttonid7);
        eight = (Button) findViewById(R.id.buttonid8);
        nine = (Button) findViewById(R.id.buttonid9);
        zero = (Button) findViewById(R.id.buttonid0);
        plus = (Button) findViewById(R.id.buttonidAdd);
        minus = (Button) findViewById(R.id.buttonidSub);
        multi = (Button) findViewById(R.id.buttonidMultiplication);
        devision = (Button) findViewById(R.id.buttonidDevision);
        clear = (Button) findViewById(R.id.buttonidClear);
        back = (Button) findViewById(R.id.buttonidBack);
        equal = (Button) findViewById(R.id.buttonidEqual);
        point = (Button) findViewById(R.id.buttonidPoint);
        textview = (TextView) findViewById(R.id.viewid);
    }

    private void compute()
    {

        if(!Double.isNaN(val1))
        {
            val2 = Double.parseDouble (textview.getText().toString());

            switch (ACTION)
            {
                case ADDITION:
                     val1 = val1 + val2;
                    break;
                case MULTIPLICATION:
                     val1 = val1 * val2;
                    break;
                case SUBTRACTION:
                     val1 = val1 - val2;
                    break;
                case DEVISION:
                    val1 = val1 / val2;
                    break;
                case EQUAL:
                    textview.setText(String.valueOf(val1));
                    textview.setText(null);
                    break;
            }
        }
        else
        {
            val1 = Double.parseDouble(textview.getText().toString());
        }
    }



}