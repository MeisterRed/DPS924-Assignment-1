package com.example.assignment1;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Calculator calculator = new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CalcInput(View view) {
        TextView tempView = (TextView)findViewById(R.id.textview1);
        String displayTemp = tempView.getText() + " " + ((Button) view).getText().toString();
        calculator.push(((Button) view).getText().toString());
        tempView.setText(displayTemp);
    }

    public void equalsClick(View view) {
        TextView tempView = (TextView)findViewById(R.id.textview1);
        try {
            int result = calculator.calculate();
            String displayTemp = tempView.getText() + " " + ((Button) view).getText().toString() + " " + result;
            tempView.setText(displayTemp);
        }
        catch (Exception e) {
            String displayTemp = tempView.getText() + " " + ((Button) view).getText().toString() + " Not an Operator";
            tempView.setText(displayTemp);
        }
    }

    public void clearDisplay(View view) {
        TextView tempView = (TextView)findViewById(R.id.textview1);
        calculator.clear();
        tempView.setText("");
    }

    public void modeSwitch(View view) {
        Button mode = (Button)findViewById(R.id.button17);
        LinearLayout Sci_functions = (LinearLayout)findViewById(R.id.sci_functions);
        if (mode.getText().equals("Advance - Scientific")) {
            mode.setText("Standard");
            Sci_functions.setVisibility(View.VISIBLE);

        }
        else {
            mode.setText("Advance - Scientific");
            Sci_functions.setVisibility(View.GONE);

        }
    }

}