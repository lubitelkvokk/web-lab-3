package weblab3.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Entity
@Table(name = "hit")
@Data
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
