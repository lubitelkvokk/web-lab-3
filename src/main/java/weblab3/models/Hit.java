package weblab3.models;

import jakarta.persistence.*;
import lombok.Data;
import weblab3.util.Decimalise;

import java.text.ParseException;
import java.util.Date;


@Entity
@Table(name = "hit")

public class Hit {

    public Hit(Double x, Double y, Double r, Date currentTime, boolean hitResult) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.currentTime = currentTime;
        this.hitResult = hitResult;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hit_seq")
    @SequenceGenerator(name = "hit_seq", sequenceName = "hit_seq", allocationSize = 1)
    private Long id;


    public Double getX() throws ParseException {
        return Decimalise.decimalise(x);
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() throws ParseException {
        return Decimalise.decimalise(y);
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getR() throws ParseException {
        return Decimalise.decimalise(r);
    }

    public void setR(Double r) {
        this.r = r;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public boolean isHitResult() {
        return hitResult;
    }

    public void setHitResult(boolean hitResult) {
        this.hitResult = hitResult;
    }

    @Column(name = "x")
    private Double x;

    @Column(name = "y")
    private Double y;
    @Column(name = "r")
    private Double r;

    @Column(name = "currentTime")
    private Date currentTime;

    @Column(name = "hitResult")
    private boolean hitResult;

    public Hit() {
    }


}
