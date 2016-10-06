package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByDay_Expenses;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class ByDay_DataModelChild_Exp {
    private String description_byday,amount_byday,catName_byday;

    ByDay_DataModelChild_Exp()
    {

    }

    ByDay_DataModelChild_Exp(String description_byday,String amount_byday,String catName_byday)
    {
        this.description_byday=description_byday;
        this.amount_byday=amount_byday;
        this.catName_byday=catName_byday;
    }

    public String getDescription_byday() {
        return description_byday;
    }

    public void setDescription_byday(String description_byday) {
        this.description_byday = description_byday;
    }

    public String getAmount_byday() {
        return amount_byday;
    }

    public void setAmount_byday(String amount_byday) {
        this.amount_byday = amount_byday;
    }

    public String getCatName_byday() {
        return catName_byday;
    }

    public void setCatName_byday(String catName_byday) {
        this.catName_byday = catName_byday;
    }
}
