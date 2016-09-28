package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

/**
 * Created by Tayyaba on 9/27/2016.
 */
public class ByCategory_DataModel_Exp {

    private String categoryName,amount;

    public ByCategory_DataModel_Exp()
    {

    }

    public ByCategory_DataModel_Exp(String categoryName, String amount)
    {
        this.categoryName=categoryName;
        this.amount=amount;
    }
    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
