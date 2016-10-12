package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits;

/**
 * Created by aashi on 10/11/2016.
 */

public class LimitDataModel {
    public String getCategoryName() {
        return categoryName;
    }

    public LimitDataModel(String categoryName, Integer amount, String to, String from) {
        this.categoryName = categoryName;
        Amount = amount;
        this.to = to;
        this.from = from;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getAmount() {
        return Amount;
    }

    public void setAmount(Integer amount) {
        Amount = amount;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    String categoryName;
    Integer Amount;
    String to;
    String from;

}
