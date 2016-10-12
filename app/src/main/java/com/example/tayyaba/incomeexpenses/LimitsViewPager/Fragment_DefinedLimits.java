package com.example.tayyaba.incomeexpenses.LimitsViewPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tayyaba.incomeexpenses.LimitsViewPager.RecycleViewDefinedLimits.DefinedLimitsAdapter;
import com.example.tayyaba.incomeexpenses.R;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits.DatabaseHandlerLimits;
import com.example.tayyaba.incomeexpenses.SqliteDatabaseClasses.SqliteDatabaseClasses.AddLimits.LimitDataModel;

import java.util.ArrayList;

import static com.example.tayyaba.incomeexpenses.LimitsViewPager.RecycleViewDefinedLimits.DefinedLimitsAdapter.definedLimits;

/**
 * Created by Tayyaba on 9/26/2016.
 */
public class Fragment_DefinedLimits  extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";

    private int mPage;

    public static Fragment_DefinedLimits newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        Fragment_DefinedLimits fragment = new Fragment_DefinedLimits();
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

        View view = inflater.inflate(R.layout.fragment_defined_limits, container, false);
        DefinedLimitsAdapter adapter = new DefinedLimitsAdapter();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleView_definedLimits);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        definedLimits.clear();

        DatabaseHandlerLimits db = new DatabaseHandlerLimits(getContext());
        ArrayList<LimitDataModel> list = db.listoflimits();
        for(LimitDataModel model : list)
        {
            definedLimits.add(model);
            adapter.notifyDataSetChanged();
        }

        //  TextView tvTitle = (TextView) view.findViewById(R.id.tvTitle);
        //  tvTitle.setText("Fragment #" + mPage);
        return view;
    }

}
