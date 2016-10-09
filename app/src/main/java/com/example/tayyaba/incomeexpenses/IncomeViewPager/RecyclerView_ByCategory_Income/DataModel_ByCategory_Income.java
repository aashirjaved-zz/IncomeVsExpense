package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_ByCategory_Income {

    private String catName, amount;

    DataModel_ByCategory_Income()
    {

    }

    DataModel_ByCategory_Income(String catName,String amount)
    {
        this.catName=catName;
        this.amount=amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
