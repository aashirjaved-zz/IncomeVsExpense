package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;



/**
 * Created by tayyabataimur on 10/6/16.
 */

public class ByCategory_DataModelChild_Exp  {

    private String date, description,amount;

    public ByCategory_DataModelChild_Exp()
    {



    }


    public ByCategory_DataModelChild_Exp(String date,String description, String amount) {

        this.date=date;
        this.description=description;
        this.amount=amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
