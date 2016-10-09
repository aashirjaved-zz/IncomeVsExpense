package com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewIncome;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_Income_Category {

    private String catName, def_val;

    DataModel_Income_Category()
    {

    }

    public DataModel_Income_Category(String catName, String def_val)
    {
        this.catName=catName;
        this.def_val=def_val;
    }

    public String getDef_val() {
        return def_val;
    }

    public void setDef_val(String def_val) {
        this.def_val = def_val;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
