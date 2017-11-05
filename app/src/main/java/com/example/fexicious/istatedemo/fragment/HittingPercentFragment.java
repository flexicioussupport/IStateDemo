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
import com.flexicious.nestedtreedatagrid.valueobjects.FontInfo;



public class HittingPercentFragment extends Fragment {

    public HittingPercentFragment() {
        // Required empty public constructor
    }


    public static Fragment newInstance() {
        HittingPercentFragment fragment = new HittingPercentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hitting_percent, container, false);
        FlexDataGrid grid = (FlexDataGrid)view.findViewById(R.id.hittingPercentGridView);
        grid.delegate = this;
        grid.buildFromXml(Utill.getStringFromResource(R.raw.grid_hitting_percent));
        grid.styleName = new FontInfo("cursive",10, 0);
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
