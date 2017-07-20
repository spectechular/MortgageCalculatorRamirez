package com.example.mike.mortgagecalculatorramirez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Mortgage  mortgage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mortgage = new Mortgage();
        setContentView(R.layout.activity_main);
    }

    public void onStart() {
        super.onStart();
        updateView();
    }

    public void updateView() {

        TextView amountTextView = (TextView) findViewById(R.id.mortgage_amount_text_view);
        amountTextView.setText(mortgage.getFormattedAmount());

        TextView yearsTextView = (TextView) findViewById(R.id.years_text_view);
        yearsTextView.setText("" + mortgage.getYears());

        TextView rateTextView = (TextView) findViewById(R.id.rate_text_view);
        rateTextView.setText("" + mortgage.getRate() + "%");

        TextView monthlyTextView = (TextView) findViewById(R.id.monthly_payment_text_view);
        monthlyTextView.setText(mortgage.formattedMonthlyPayment());

        TextView totalTextView = (TextView) findViewById(R.id.total_payment_text_view);
        totalTextView.setText(mortgage.formattedTotalPayment());
    }

    public void modifyData(View V) {

        Intent myIntent = new Intent(this, DataActivity.class);
        this.startActivity(myIntent);
    }
}
