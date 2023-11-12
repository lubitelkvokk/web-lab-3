package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;


import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("rowBean")
@SessionScoped
public class RowBean implements Serializable {
    private double x;
    private double y;
    private double r;
    private String currentTime;
    private String scriptRuntime;
    private String isHit;

    public String getMessage() {
        return "pacsss o";
    }

    private final String message = "SLAVE GAY";

    @Inject
    private TableBean tableBean;

    public RowBean() {
        System.out.println("SLAVA GAY FROM ROW BEAN");
    }

    public RowBean(double x, double y, double r, String currentTime, String scriptRuntime, String isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.scriptRuntime = scriptRuntime;
        this.isHit = isHit;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public String getScriptRuntime() {
        return scriptRuntime;
    }

    public void setScriptRuntime(String scriptRuntime) {
        this.scriptRuntime = scriptRuntime;
    }

    public String getIsHit() {
        return isHit;
    }

    public void setIsHit(String isHit) {
        this.isHit = isHit;
    }

    public void addToTable() {
        RowBean row = new RowBean(x, y, r, currentTime, scriptRuntime, isHit);
        tableBean.addToTable(row);
    }

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }
}