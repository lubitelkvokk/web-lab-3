package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import weblab3.models.Hit;
import weblab3.util.GetGson;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {
    private final List<Hit> table;

    public TableBean() {
        table = new ArrayList<>();
    }

    public List<Hit> getTable() {
        return table;
    }

    public void addToTable(Hit row) {
        table.add(row);
    }


    public String getTableAsJson(){

        return GetGson.getGson().toJson(table);
    }
}