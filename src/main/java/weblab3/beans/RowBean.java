package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import weblab3.beans.dao.HitDao;
import weblab3.beans.models.Hit;
import weblab3.beans.util.HitCheck;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Named("rowBean")
@SessionScoped
public class RowBean implements Serializable {
    //    private final String message = "SLAVE GAY";
    private double x;
    private double y;
    private double r;
    private String currentTime;
    private Boolean isHit;
    @Inject
    private TableBean tableBean;

    public RowBean() {
    }

    public RowBean(double x, double y, double r, String currentTime, Boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.isHit = isHit;
    }

    public String getMessage() {
        return "pacsss o";
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        System.out.println("SETTING X: " + x);
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
//        System.out.println(123);
        this.currentTime = currentTime;
    }

    public Boolean getIsHit() {
        return isHit;
    }

    public void setIsHit(Boolean isHit) {
        this.isHit = isHit;
    }

    public void addToTable() {
        RowBean row = new RowBean(x, y, r, currentTime, HitCheck.hitCheck(x, y, r));
        System.out.println(x);
        System.out.println(y);
        System.out.println(r);

        HitDao.addHit(new Hit(x, y, r, new Date(), HitCheck.hitCheck(x, y, r)));
        System.out.println(x);
        System.out.println(y);
        System.out.println(r);
        tableBean.addToTable(row);
    }

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }
}