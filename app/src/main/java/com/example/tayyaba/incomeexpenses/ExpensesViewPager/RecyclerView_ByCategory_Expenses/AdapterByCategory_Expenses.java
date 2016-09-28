package com.example.tayyaba.incomeexpenses.ExpensesViewPager.RecyclerView_ByCategory_Expenses;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

    import com.example.tayyaba.incomeexpenses.R;

import java.util.ArrayList;

/**
 * Created by Tayyaba on 9/27/2016.
 */
public class AdapterByCategory_Expenses extends RecyclerView.Adapter<AdapterByCategory_Expenses.ViewHolder> {

    private ArrayList<ByCategory_DataModel_Exp>  catData =new ArrayList<>();

    Context context;
    public AdapterByCategory_Expenses(ArrayList<ByCategory_DataModel_Exp> catData) {
      this.catData = catData;
      }

    public AdapterByCategory_Expenses(Context context)
    {

        this.context=context;
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));
catData.add(new ByCategory_DataModel_Exp("Hello ","Data"));

    }


@Override
   public AdapterByCategory_Expenses.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    // create a new view
    View itemLayoutView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.item_bycategory_expenses, null);


    ViewHolder viewHolder = new ViewHolder(itemLayoutView);
    return viewHolder;
      }

          @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

     // - get data from your itemsData at this position
      // - replace the contents of the view with that itemsData

       viewHolder.catName_Exp.setText(catData.get(position).getCategoryName());
      viewHolder.catAmount_Exp.setText(catData.get(position).getAmount());


        }

          public static class ViewHolder extends RecyclerView.ViewHolder {

              public TextView catName_Exp,catAmount_Exp;

               public ViewHolder(View itemLayoutView) {
           super(itemLayoutView);
           catName_Exp = (TextView) itemLayoutView.findViewById(R.id.catName_exp);
           catAmount_Exp = (TextView) itemLayoutView.findViewById(R.id.catAmount_exp);}
       }


    @Override
   public int getItemCount() {
        return catData.size();
       }
}