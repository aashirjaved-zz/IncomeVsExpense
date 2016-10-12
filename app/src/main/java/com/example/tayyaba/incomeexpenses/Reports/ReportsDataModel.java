package com.example.tayyaba.incomeexpenses.Reports;

/**
 * Created by aashi on 10/11/2016.
 */

public class ReportsDataModel {
    String Category,date,amount;

    public ReportsDataModel(String category, String date, String amount) {
        Category = category;
        this.date = date;
        this.amount = amount;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
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
