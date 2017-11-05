package com.example.fexicious.istatedemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fexicious.istatedemo.R;
import com.example.fexicious.istatedemo.Utill;
import com.flexicious.nestedtreedatagrid.FlexDataGrid;
import com.flexicious.nestedtreedatagrid.interfaces.IFlexDataGridCell;

public class SkillSummaryFragment extends Fragment {


    public SkillSummaryFragment() {
    }


    public static SkillSummaryFragment newInstance() {
        SkillSummaryFragment fragment = new SkillSummaryFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_summary, container, false);
        FlexDataGrid grid = (FlexDataGrid) view.findViewById(R.id.skillSummaryGridView);
        grid.delegate = this;
        grid.buildFromXml(Utill.getStringFromResource(R.raw.grid_skill_summary));
        grid.setDataProviderJson(Utill.getStringFromResource(R.raw.istate_data));
        return view;
    }

    public Object getCellBackgroundColor(IFlexDataGridCell cell){
       return Utill.getCellBackgroundColor(cell);
    }

    public int getCellTextColor(IFlexDataGridCell cell){
        return Utill.getCellTextColor(cell);
    }
}
