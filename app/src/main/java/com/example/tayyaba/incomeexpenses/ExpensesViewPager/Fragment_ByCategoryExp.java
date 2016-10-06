package com.example.tayyaba.incomeexpenses.ExpensesViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.AdapterByCategory_Expenses;
import com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.ByCategory_DataModelParent_Exp;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.CategoryDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddCategory.DatabaseHandler;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.AddExpenseDataModel;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddExpense.DatabaseHandlerExpense;

import java.util.ArrayList;
import java.util.List;

import static com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses.AdapterByCategory_Expenses.catData;

/**
 * Created by Tayyaba on 9/25/2016.
 */
public class Fragment_ByCategoryExp extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private List<ByCategory_DataModelParent_Exp> catList = new ArrayList<>();

    RecyclerView recyclerViewCat_exp;
    AdapterByCategory_Expenses adapter_ByCategory_expenses;
    private int mPage;
   // private ArrayList<ByCategory_DataModel_Exp>categoriesList=new ArrayList<>();


    public static Fragment_ByCategoryExp newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_ByCategoryExp fragment = new Fragment_ByCategoryExp();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    // Inflate the fragment layout we defined above for this fragment
    // Set the associated text for the title
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bycategory_exp, container, false);



        showData(view);





//        AdapterByCategory_Expenses adapter_ByCategory_expenses =new AdapterByCategory_Expenses(getActivity());
//        recyclerViewCat_exp.setAdapter(adapter_ByCategory_expenses);



        return view;
    }

    private  ArrayList<ParentObject> generateCetogeries()
    {
        DatabaseHandler db = new DatabaseHandler(getContext());
        ArrayList<CategoryDataModel> categoryDataModels = db.listofCategories();

        DatabaseHandlerExpense db1 = new DatabaseHandlerExpense(getContext());
        ArrayList<AddExpenseDataModel> allExpenses = db1.getAllExpenses();
        ArrayList<ParentObject> parentObjects = new ArrayList<>();
        ArrayList<ByCategory_DataModelParent_Exp> expandableList = new ArrayList<>();
        for(CategoryDataModel categoryDataModel : categoryDataModels)
        {
            expandableList.add( new ByCategory_DataModelParent_Exp(categoryDataModel.getCategoryName().toString(),categoryDataModel.getCategoryValue().toString()));
        }

        for(ByCategory_DataModelParent_Exp model : expandableList)
        {
            for(AddExpenseDataModel model1 : allExpenses)
            {
                if(model1.getCategory().contains(model.getCategoryName()) )
                {
                    ArrayList<Object> childlist = new ArrayList<>();
                    childlist.add(new AddExpenseDataModel(model1.getAmount(),model1.getDescription()));
                    model.setChildObjectList(childlist);
                    parentObjects.add(model);

                }
            }

        }
        Log.v("RecycleviewData",parentObjects.toArray().toString());
        return parentObjects;
    }
    public void showData(View view)
    {
        recyclerViewCat_exp = (RecyclerView)view.findViewById(R.id.recyclerView_byCat_Expenses);
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewCat_exp.setLayoutManager(llm);
        AdapterByCategory_Expenses adapterByCategory_expenses = new AdapterByCategory_Expenses(getContext());
        recyclerViewCat_exp.setAdapter(adapterByCategory_expenses);
        catData.clear();
        DatabaseHandler db = new DatabaseHandler(getContext());
        ArrayList<CategoryDataModel> categoryDataModels = db.listofCategories();

        DatabaseHandlerExpense db1 = new DatabaseHandlerExpense(getContext());
        ArrayList<AddExpenseDataModel> expenseDataModels = db1.getAllExpenses();
        Integer totalamount =0;
        for(CategoryDataModel model: categoryDataModels)
        {

            for(AddExpenseDataModel expenseData : expenseDataModels)
            {
                if(model.getCategoryName().contains(expenseData.getCategory()))
                {
                    totalamount = totalamount+expenseData.getAmount();


                }



            }
            if(totalamount.equals(0))
            {            catData.add(new CategoryDataModel(model.getCategoryName(),model.getCategoryValue(),model.getCategoryType(),model.getCategoryNature(),model.getCategoryColor()));


            }
            else {
                catData.add(new CategoryDataModel(model.getCategoryName(), String.valueOf(totalamount), model.getCategoryType(), model.getCategoryNature(), model.getCategoryColor()));
                totalamount=0;
            }
            adapterByCategory_expenses.notifyDataSetChanged();
        }


    }

}