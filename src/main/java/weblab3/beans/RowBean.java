package weblab3.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import weblab3.dao.HitDao;
import weblab3.models.Hit;
import weblab3.util.Decimalise;
import weblab3.util.HitCheck;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.Date;


@Named("rowBean")
@SessionScoped
public class RowBean implements Serializable {

    @Inject
    private HitDao hitDao;


    private double x;
    private double y;
    private double r;
    private Date currentTime;
    private Boolean isHit;
    @Inject
    private TableBean tableBean;

    @Inject
    private HitCounterBean hitCounterBean;

    public RowBean() {
        x = 1;
        y = 1;
        r = 1;
    }

    public RowBean(double x, double y, double r, Date currentTime, Boolean isHit) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
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

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public Boolean getIsHit() {
        return isHit;
    }

    public void setIsHit(Boolean isHit) {
        this.isHit = isHit;
    }

    /**
     * Метод осуществляющий добавление попаданий из представления в хранилище
     */
    public void addToTable() {
        try {
            Date date = new Date();
            isHit = HitCheck.hitCheck(x, y, r);
            currentTime = date;

            Hit hit = new Hit(x, y, r,
                    date,
                    isHit);

            hitDao.addHit(hit);
            tableBean.addToCurrentResults(hit);
            if (isHit) hitCounterBean.incGeneralHitCount();
            else hitCounterBean.incMissHitCount();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    public TableBean getTableBean() {
        return tableBean;
    }

    public void setTableBean(TableBean tableBean) {
        this.tableBean = tableBean;
    }
}