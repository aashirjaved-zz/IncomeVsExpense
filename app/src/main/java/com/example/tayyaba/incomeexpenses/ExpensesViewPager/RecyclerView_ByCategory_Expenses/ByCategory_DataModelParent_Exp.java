package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;


import java.util.List;

/**
 * Created by Tayyaba on 9/27/2016.
 */
public class ByCategory_DataModelParent_Exp  {

    private String categoryName,amount;
    private List<Object> mChildrenList;


    public ByCategory_DataModelParent_Exp(String categoryName, String amount)
    {

        this.categoryName=categoryName;
        this.amount=amount;
    }

//    public ByCategory_DataModelParent_Exp(View itemView) {
//        super(itemView);
//    }

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
