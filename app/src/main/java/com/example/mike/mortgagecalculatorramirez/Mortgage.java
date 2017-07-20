package com.example.mike.mortgagecalculatorramirez;

import java.text.DecimalFormat;

/**
 * Created by Mike on 7/19/2017.
 */

public class Mortgage {

    public final DecimalFormat MONEY = new DecimalFormat("#,##0.00");

    private float amount;
    private int years;
    private float rate;

    public Mortgage() {

        setAmount(100000.0f);
        setYears(30);
        setRate(0.035f);

    }

    public float monthlyPayment() {

        float mRate = rate / 12;
        double temp = Math.pow(1 / (1 + mRate), years * 12);
        return amount * mRate / (float) (1 - temp);

    }

    public void setAmount(float newAmount) {

        if (newAmount >= 0) {
            amount = newAmount;
        }
    }

    public float getAmount() {
        return amount;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int newYears) {

        if (newYears >= 0) {
            years = newYears;
        }
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float newRate) {
        if (newRate >=0){
            rate = newRate;
        }
    }

    public String getFormattedAmount() {

        return MONEY.format(amount);
    }

    public String formattedMonthlyPayment() {

        return MONEY.format(monthlyPayment());
    }

    public float totalPayment() {

        return monthlyPayment() * years * 12;
    }

    public String formattedTotalPayment() {
        return MONEY.format(totalPayment());
    }
}
