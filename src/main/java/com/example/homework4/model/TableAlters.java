package com.example.homework4.model;

import com.example.homework4.data.AddData;
import com.example.homework4.data.TableData;
import java.util.Vector;

public class TableAlters {
    public static boolean checkValidAdd(TableData table, AddData info) {
        boolean isvalid = true;
        Vector<AddData> list = table.getTabledata();
        for (int i = 0; i < list.size() && isvalid; i++) {
            if (list.elementAt(i).getUsername().equals(info.getUsername()))
                isvalid = false;
        }
        return isvalid;
    }

    // 更新指定元素
    public static boolean alterElem(TableData table, AddData info) {
        int index = -1;
        Vector<AddData> list = table.getTabledata();
        for (int i = 0; i < list.size() && -1 == index; i++) {
            if (list.elementAt(i).getUsername().equals(info.getUsername()))
                index = i;
        }

        if (index != -1) { //如果找到了 就替换该元素
            list.set(index, info);
            return true;
        } else {
            return false;
        }
    }

    public static void deleteElem(TableData table, int index) {
        table.getTabledata().remove(index);
    }
}
