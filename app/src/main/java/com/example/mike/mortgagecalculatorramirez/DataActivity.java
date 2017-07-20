package com.example.mike.mortgagecalculatorramirez;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class DataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);
        updateView();
    }

    public void updateView() {

        Mortgage mortgage = MainActivity.mortgage;

        if (mortgage.getYears() == 10) {

            RadioButton rb10 = (RadioButton) findViewById(R.id.ten_radio_button);
            rb10.setChecked(true);
        } else if (mortgage.getYears() == 15) {

            RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen_radio_button);
            rb15.setChecked(true);
        }

        EditText amountEditText = (EditText) findViewById(R.id.data_mortgage_amount_edit_text);
        amountEditText.setText("" + mortgage.getAmount());

        EditText rateEditText = (EditText) findViewById(R.id.data_rate_edit_text);
        rateEditText.setText("" + mortgage.getRate());
    }

    public void updateMortgageObject() {
        Mortgage mortgage = MainActivity.mortgage;
        RadioButton rb10 = (RadioButton) findViewById(R.id.ten_radio_button);
        RadioButton rb15 = (RadioButton) findViewById(R.id.fifteen_radio_button);

        int years = 30;
        if (rb10.isChecked()) {
            years = 10;
        } else if (rb15.isChecked()) {
            years = 15;
        }

        mortgage.setYears(years);

        EditText amountEditText = (EditText) findViewById(R.id.data_mortgage_amount_edit_text);
        String amountString = amountEditText.getText().toString();

        EditText rateEditText = (EditText) findViewById(R.id.data_rate_edit_text);
        String rateString = rateEditText.getText().toString();

        try {
            float amount = Float.parseFloat(amountString);
            mortgage.setAmount(amount);

            float rate = Float.parseFloat(rateString);
            mortgage.setRate(rate);

        } catch (NumberFormatException nfe) {
            mortgage.setAmount((1000000.0f));
            mortgage.setRate(.035f);
        }
    }

    public void goBack(View v) {
        updateMortgageObject();
        this.finish();
    }


}

