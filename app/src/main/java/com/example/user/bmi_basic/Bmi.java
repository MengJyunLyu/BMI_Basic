package com.example.user.bmi_basic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class Bmi extends AppCompatActivity {
    private Button button;
    private EditText fieldHeight;
    private EditText fieldWeight;
    private TextView result;
    private TextView fieldSuggest;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.framelayout);
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        findViews();

        button.setOnClickListener(listener);
    }

    private void findViews() {
        button = (Button)findViewById(R.id.submit);
        fieldHeight = (EditText) findViewById(R.id.height);
        fieldWeight = (EditText) findViewById(R.id.weight);
        result = (TextView)findViewById(R.id.result);
        fieldSuggest = (TextView)findViewById(R.id.suggest);
    }

    // 按鈕事件:使用匿名內部類別
    View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // System.out.println("使用匿名內部類別Listener!!");
            try {
                double bmi = caclBMI();
                showResult(bmi);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    private double caclBMI() {
        double height = Double.parseDouble(String.valueOf(fieldHeight.getText())) / 100;
        double weight = Double.parseDouble(String.valueOf(fieldWeight.getText()));
        double bmi = weight / Math.pow(height, 2);
        return bmi;
    }

    private void showResult(double bmi) {
        DecimalFormat nf = new DecimalFormat("0.00");
        result.setText("Your BMI is " + nf.format(bmi));

        if (bmi > 25) {
            fieldSuggest.setText(R.string.advice_heavy);
        } else if (bmi < 20) {
            fieldSuggest.setText(R.string.advice_light);
        } else {
            fieldSuggest.setText(R.string.advice_average);
        }
    }



    // 按鈕事件:XML自訂android:onClick屬性，建立監聽器，需implements View.OnClickListener
//    @Override
//    public void onClick(View v) {
//        System.out.println("使用具名的Listener!!");
//
//    }

    // 按鈕事件:XML自訂android:onClick屬性，不須實作
//    public void onClick(View view) {
//        System.out.println("按下按鈕!!");
//    }





}
