package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_Details_Income;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_Details_Income {

   private String desc,catName,date,amount;

    public DataModel_Details_Income()
    {}

    public DataModel_Details_Income(String desc, String catName, String date, String amount)
    {
        this.desc=desc;
        this.catName=catName;
        this.date=date;
        this.amount=amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
