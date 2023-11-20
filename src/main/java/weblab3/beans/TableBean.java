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
    private Integer pages;

    public TableBean(){
        table = new ArrayList<>();
        pageSize = 10;
    }
    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    private Integer pageSize;
    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
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