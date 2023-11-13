package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import com.google.gson.Gson;
import weblab3.beans.util.GetGson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {
    private final List<RowBean> table;

    public TableBean() {
        table = new ArrayList<>();
        System.out.println("SLAVA GAY FROM TABLE BEAN");
    }

    public List<RowBean> getTable() {
        return table;
    }

    public void addToTable(RowBean row) {
        table.add(row);
    }

    public String getTableAsJson(){

        return GetGson.getGson().toJson(table);
    }
}