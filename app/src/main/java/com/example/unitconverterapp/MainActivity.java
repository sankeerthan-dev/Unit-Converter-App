package com.example.unitconverterapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.resultText);
        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

       button.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String inputValue = editText.getText().toString();

               double convertedValue = Double.parseDouble(inputValue);
               double result = convert(convertedValue);
               String displayValue = String.valueOf(result) + " feet";
               textView.setText(displayValue);
           }
       });
    }

    public double convert(double value) {
        double convertedValue = value / 30.48;
        return convertedValue;
    }
}