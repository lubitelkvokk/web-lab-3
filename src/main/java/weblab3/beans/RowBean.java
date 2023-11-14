package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import weblab3.dao.HitDao;
import weblab3.models.Hit;
import weblab3.util.HitCheck;

import java.io.Serializable;
import java.util.Date;

@Named("rowBean")
@SessionScoped
public class RowBean implements Serializable {
    //    private final String message = "SLAVE GAY";
    private double x;
    private double y;
    private double r;
    private Date currentTime;
    private Boolean isHit;
    @Inject
    private TableBean tableBean;

    public RowBean() {
    }

    public RowBean(double x, double y, double r, Date currentTime, Boolean isHit) {
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

    public Date getCurrentTime() {
        System.out.println(currentTime);
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
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
        try {
            Date date = new Date();
            isHit = HitCheck.hitCheck(x, y, r);
            currentTime = date;
            Hit hit = new Hit(x, y, r, date, HitCheck.hitCheck(x, y, r));

            HitDao hitDao = new HitDao();
            hitDao.addHit(hit);
            tableBean.addToTable(hit);
        } catch (NumberFormatException e) {

        }
    }

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }
}