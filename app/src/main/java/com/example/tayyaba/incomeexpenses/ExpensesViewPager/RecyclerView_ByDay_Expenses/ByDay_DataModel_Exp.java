package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses;

/**
 * Created by Tayyaba on 9/28/2016.
 */
public class ByDay_DataModel_Exp{

    private String day,amount;

    public ByDay_DataModel_Exp()
    {

    }

    public ByDay_DataModel_Exp(String categoryName, String amount)
    {
        this.day=categoryName;
        this.amount=amount;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
