package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddFutureExpense;

/**
 * Created by aashi on 10/9/2016.
 */

public class FutureExpenseDataModel {
    String description;
    Integer amount;

    public String getDescription() {
        return description;
    }

    public FutureExpenseDataModel(String description, Integer amount, String date, String type, String category) {
        this.description = description;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.category = category;
    }
    public FutureExpenseDataModel()
    {}

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    String date;
    String type;
    String category;


}
