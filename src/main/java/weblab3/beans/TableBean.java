package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import weblab3.dao.HitDao;
import weblab3.models.Hit;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Named("table")
@SessionScoped
public class TableBean implements Serializable {
    private List<Hit> tablePage;

    private List<Hit> currentResults = new ArrayList<>();
    private Integer pageNumber = 1;

    private Integer pageSize = 10;
    private HitDao hitDao;

    public List<Hit> getTablePage() {
        return tablePage;
    }

    public void setTablePage(List<Hit> tablePage) {
        this.tablePage = tablePage;
    }

    public List<Hit> getCurrentResults() {
        return currentResults;
    }

    public void setCurrentResults(List<Hit> currentResults) {
        this.currentResults = currentResults;
    }


    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }


    @Inject
    public TableBean(HitDao hitDao) {
        this.hitDao = hitDao;
        tablePage = hitDao.getPaginationHitList(10, 1);
    }

    public TableBean() {
    }


    public void loadPage() {
        tablePage = hitDao.getPaginationHitList(pageSize, pageNumber);
    }

    public Integer getPageNumber() {

        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void addToCurrentResults(Hit hit) {
        currentResults.add(hit);
    }
}