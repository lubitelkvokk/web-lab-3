package weblab3.beans.models;

import jakarta.persistence.*;
import weblab3.beans.util.HibernateUtil;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


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
}
