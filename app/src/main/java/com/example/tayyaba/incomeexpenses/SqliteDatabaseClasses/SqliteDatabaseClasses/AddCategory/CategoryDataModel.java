package com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory;

/**
 * Created by aashi on 10/6/2016.
 */

public class CategoryDataModel {
    String categoryName;
    String categoryValue;

    public Integer getCategoryColor() {
        return categoryColor;
    }

    public void setCategoryColor(Integer categoryColor) {
        this.categoryColor = categoryColor;
    }

    Integer categoryColor;

    public CategoryDataModel(String categoryName, String categoryValue, String categoryType, String categoryNature, Integer categoryColor) {
        this.categoryName = categoryName;
        this.categoryValue = categoryValue;
        this.categoryType = categoryType;
        this.categoryNature = categoryNature;
        this.categoryColor = categoryColor;
    }

    String categoryType;
    String categoryNature;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(String categoryType) {
        this.categoryType = categoryType;
    }

    public String getCategoryNature() {
        return categoryNature;
    }

    public void setCategoryNature(String categoryNature) {
        this.categoryNature = categoryNature;
    }
}
