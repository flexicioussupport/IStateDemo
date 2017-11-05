package com.example.fexicious.istatedemo.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fexicious.istatedemo.R;
import com.example.fexicious.istatedemo.Utill;
import com.example.fexicious.istatedemo.utills.StyleManager;
import com.flexicious.nestedtreedatagrid.FlexDataGrid;
import com.flexicious.nestedtreedatagrid.interfaces.IFlexDataGridCell;
import com.flexicious.nestedtreedatagrid.valueobjects.FontInfo;


public class PointsScoredFragment extends Fragment {

    FlexDataGrid grid;
    public PointsScoredFragment() {

    }


    public static PointsScoredFragment newInstance() {
        PointsScoredFragment fragment = new PointsScoredFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_points_scored, container, false);
        grid = (FlexDataGrid)view.findViewById(R.id.pointScoredGridView);
        grid.delegate = this;
        grid.buildFromXml(Utill.getStringFromResource(R.raw.grid_points_scored));
        grid.verticalGridLineThickness = 3;
        grid.horizontalGridLineThickness = 3;
        grid.horizontalGridLineColor = StyleManager.instance().getUIColorObjectFromHexString("0x355c99");
        grid.verticalGridLineColor = StyleManager.instance().getUIColorObjectFromHexString("0x000000");
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
