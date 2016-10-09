package com.example.tayyaba.incomeexpenses.IncomeViewPager.Recyclerview_ByDay_Income;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_Child_ByDay_income {

private String desc,catName,amount;

    DataModel_Child_ByDay_income()
    {

    }

    DataModel_Child_ByDay_income(String desc,String catName,String amount)
    {
        this.desc=desc;
        this.catName=catName;
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

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }
}
