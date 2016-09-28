package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_Details_Expenses;

/**
 * Created by Tayyaba on 9/28/2016.
 */
public class Details_DataModel_Expenses {

    private String description,amount,catName,date;

    public Details_DataModel_Expenses()
    {

    }

    public Details_DataModel_Expenses(String description, String amount, String catName,String date)
    {
        this.description=description;
        this.amount=amount;
        this.catName=catName;
        this.date=date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}