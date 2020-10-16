package com.example.mybuttons;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    TextView show;
    String compute;
    Integer number = 0;
    Integer lastNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linear_layout);

        show = (TextView) findViewById(R.id.show);
        show.setText(number.toString());
    }

    public void setNumber(View view) {
        Button button = (Button) view;
        Integer onclickNumber = Integer.valueOf(button.getText().toString());

        if (onclickNumber == 0 && number == 0) {
            show.setText("0");
        } else {
            Integer numberTmp = Integer.valueOf(number.toString() + onclickNumber.toString());
            number = numberTmp;
            show.setText(numberTmp.toString());
        }
    }

    public void compute(View view) {
        Button button = (Button) view;
        compute = button.getText().toString();

        switch (button.getText().toString()) {
            case "+" :
                if (lastNumber != 0) {
                    lastNumber += number;
                    number = 0;
                    show.setText(lastNumber.toString());
                } else {
                    lastNumber = number;
                    number = 0;
                }
                break;
        };
    }

    public void equal(View view) {
        switch (compute) {
            case "+" :
                if (lastNumber != 0) {
                    lastNumber += number;
                    number = 0;
                    show.setText(lastNumber.toString());
                } else {
                    lastNumber = number;
                    number = 0;
                }
                break;
        };
    }

    public void back(View view) {
        Button button = (Button) view;
        String number = show.getText().toString();

        if (number.length() - 1 <= 0) {
            show.setText(number);
        } else {
            show.setText(number.substring(0, number.length() - 1));
        }
    }

    public void clear(View view) {
        number = 0;
        lastNumber = 0;
        show.setText(number);
    }
}