package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEnterNumber;
    TextView tvValue;
    RelativeLayout reConvert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEnterNumber = findViewById(R.id.et_enter_number);
        reConvert = findViewById(R.id.reConvert);
        tvValue = findViewById(R.id.tv_value);

        reConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationSuccess()){
                    ConvertFromKiloToPound();
                }
            }
        });
    }

    // this method is converted the Value to String
    private void ConvertFromKiloToPound() {
        // converting the Value to String
        String valueEnteredInKilo = etEnterNumber.getText().toString();
        // converting the string to number(double)
        double kilo = Double.parseDouble(valueEnteredInKilo);
        double pounds = kilo * 2.205;
        // displaying the number to the TextView(tvValue)
        tvValue.setText(""+pounds);
    }

    /*validation of reConverter*/
    private boolean validationSuccess() {
        if(etEnterNumber.getText().toString().equalsIgnoreCase("")){
            LayoutInflater layoutInflater = getLayoutInflater();
            View layout = layoutInflater.inflate(R.layout.toast,(ViewGroup) findViewById(R.id.toast_id));

            TextView textView = (TextView) layout.findViewById(R.id.toast_mes);
            textView.setText("Please Enter The Value...");

            Toast toast = new Toast(getApplicationContext());
            toast.setGravity(Gravity.BOTTOM,0,0);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();

            return false;
        }
        return true;
    }
}