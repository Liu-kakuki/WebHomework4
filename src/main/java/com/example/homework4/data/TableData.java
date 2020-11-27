package com.example.homework4.data;

import java.io.Serializable;
import java.util.Vector;

public class TableData implements Serializable {
    private Vector<AddData> tabledata;
    public TableData() {
        tabledata = new Vector<AddData>();
        tabledata.add(new AddData("迪卢克", "18888888888", "18888888888@qq.com", "蒙德城晨曦酒庄", "18888888888"));
        tabledata.add(new AddData("琴", "19999999999", "19999999999@qq.com", "蒙德城西风骑士团", "19999999999"));
        tabledata.add(new AddData("七七", "17777777777", "17777777777@qq.com", "璃月区不卜卢", "17777777777"));
    }

    public Vector<AddData> getTabledata() {
        return tabledata;
    }

    public void setTabledata(Vector<AddData> tabledata) {
        this.tabledata = tabledata;
    }
}
