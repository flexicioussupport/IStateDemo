package com.example.fexicious.istatedemo;

import android.graphics.Color;

import com.example.fexicious.istatedemo.utills.StyleManager;
import com.flexicious.nestedtreedatagrid.interfaces.IFlexDataGridCell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Utill {

    public static String getStringFromResource(int resouceId) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(App.getAppContext().getResources().openRawResource(resouceId)));
        StringBuilder builder = new StringBuilder();
        String aux = "";
        try {
            while ((aux = reader.readLine()) != null) {
                builder.append(aux);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder.toString();
    }

    public static Object getCellBackgroundColor(IFlexDataGridCell cell) {

        if(cell.getRowInfo().getIsColumnGroupRow().booleanValue()){
            if(cell.getColumn()!=null && cell.getColumn().getColIndex() %2 == 0){
                return Color.parseColor("#444949");
            }
            return Color.parseColor("#707272");
        }
        if(cell.getRowInfo().getIsHeaderRow().booleanValue() ||cell.getRowInfo().getIsFooterRow().booleanValue() ){
            if(cell.getColumn()!=null && cell.getColumn().getColIndex() %2 == 0){
                return Color.parseColor("#444949");
            }
            return Color.parseColor("#707272");
        }
        if(cell.getColumn()!= null && cell.getColumn().getDataField()!=null && cell.getColumn().getDataField().toLowerCase().endsWith("percent")){
            if(cell.getRowInfo().rowPositionInfo.rowIndex %2 == 0){
                return Color.parseColor("#3460a8");
            }else{
                return Color.parseColor("#349ca8");
            }
        }else if(cell.getColumn()!= null && cell.getColumn().getColIndex()==0){
            if(cell.getRowInfo().rowPositionInfo.rowIndex %2 == 0){
                return Color.parseColor("#e8e8e8");
            }else{
                return Color.parseColor("#d1d1d1");
            }
        }else if(cell.getColumn()!= null && cell.getColumn().getColIndex() %2 == 0){
            return Color.parseColor("#f9f9f9");
        }else {
            return Color.parseColor("#f2f2f2");
        }
    }

    public static int getCellTextColor(IFlexDataGridCell cell) {
        if(cell.getRowInfo().getIsHeaderRow().booleanValue() || cell.getRowInfo().getIsColumnGroupRow().booleanValue() || cell.getRowInfo().getIsFooterRow().booleanValue() || (cell.getColumn() !=null && cell.getColumn().getDataField()!= null && cell.getColumn().getDataField().toLowerCase().endsWith("percent"))){
            return StyleManager.instance().getUIColorObjectFromHexString(
                    "0xfcfcfc");
        }
        return StyleManager.instance().getUIColorObjectFromHexString(
                "0x0a0c0c");
    }
}
