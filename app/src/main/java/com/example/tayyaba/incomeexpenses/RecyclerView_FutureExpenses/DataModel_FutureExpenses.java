package com.example.tayyaba.incomeexpenses.RecyclerView_FutureExpenses;

/**
 * Created by tayyabataimur on 10/8/16.
 */

public class DataModel_FutureExpenses {

    private String desc, month, date,days,amount,catName;

    DataModel_FutureExpenses()
    {

    }

    DataModel_FutureExpenses(String desc,String month,String date,String days,String amount)
    {
        this.desc=desc;
        this.month=month;
        this.date=date;
        this.catName=catName;
        this.days=days;
        this.amount=amount;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
