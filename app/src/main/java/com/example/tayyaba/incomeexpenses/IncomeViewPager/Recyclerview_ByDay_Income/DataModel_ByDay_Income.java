package com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_ByDay_Income {

    private String day, amount;

    DataModel_ByDay_Income()
    {

    }
    DataModel_ByDay_Income(String day,String amount)
    {
        this.day=day;
        this.amount=amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }
}
