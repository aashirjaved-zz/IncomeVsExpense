package com.example.tayyaba.incomeexpenses.IncomeViewPager.RecyclerView_ByCategory_Income;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DatModel_Child_ByCat_Income {

    private String date,desc,amount;

    DatModel_Child_ByCat_Income()
    {

    }

    DatModel_Child_ByCat_Income(String date,String desc,String amount)
    {
        this.date=date;
        this.desc=desc;
        this.amount=amount;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
