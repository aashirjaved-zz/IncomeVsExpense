package com.example.tayyaba.incomeexpenses.CategoriesViewPager.RecyclerViewExpenses;

/**
 * Created by tayyabataimur on 10/7/16.
 */

public class DataModel_expenses_Category {
    private String catName,defValue,type;

    DataModel_expenses_Category()
    {

    }

    public DataModel_expenses_Category(String catName, String defValue, String type)
    {
        this.catName=catName;
        this.defValue=defValue;
        this.type=type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDefValue() {
        return defValue;
    }

    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    public String getCatName() {
        return catName;
    }

    public void setCatName(String catName) {
        this.catName = catName;
    }
}
