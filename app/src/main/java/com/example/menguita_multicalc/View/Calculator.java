package com.example.menguita_multicalc.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.menguita_multicalc.Controller.CalculatorController;
import com.example.menguita_multicalc.R;

public class Calculator extends AppCompatActivity {

    private CalculatorController cc;

    public EditText slot1, slot2, slot3;
    public TextView title, s1, s2, s3, output1, output2, o1, o2;
    public Button calculateBtn;
    public String kind, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
        Intent intent = getIntent();
        kind = intent.getStringExtra("kind");
        type = intent.getStringExtra("type");

        //EditText
        slot1 = findViewById(R.id.slot1);
        slot2 = findViewById(R.id.slot2);
        slot3 = findViewById(R.id.slot3);

        //TextView
        title = findViewById(R.id.formulaTitle);
        s1 = findViewById(R.id.slot1Text);
        s2 = findViewById(R.id.slot2Text);
        s3 = findViewById(R.id.slot3Text);
        output1 = findViewById(R.id.output1);
        output2 = findViewById(R.id.output2);
        o1 = findViewById(R.id.output1Text);
        o2 = findViewById(R.id.output2Text);

        //Button
        calculateBtn = findViewById(R.id.calculateButton);

        cc = new CalculatorController(this);
        cc.setCalc(kind, type);

        calculateBtn.setOnClickListener(view -> {
            double num1 = Double.parseDouble(slot1.getText().toString());
            double num2 = Double.parseDouble(slot2.getText().toString());
            double num3 = Double.parseDouble(slot3.getText().toString());
            cc.solve(kind, type, num1, num2, num3);
        });

    }
}