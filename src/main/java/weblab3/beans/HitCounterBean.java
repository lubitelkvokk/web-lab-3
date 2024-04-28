package weblab3.beans;

import jakarta.enterprise.context.Dependent;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import weblab3.dao.HitDao;
import weblab3.models.HitStatistic;

import java.io.Serializable;

@Named
@Dependent
public class HitCounterBean implements Serializable {

    private int generalHitCount;
    private int missHitCount;

    @Inject
    public HitCounterBean(HitDao hitDao) {
        HitStatistic hitStatistic = hitDao.getHitCount();
        generalHitCount = hitStatistic.getHitCount();
        missHitCount = hitStatistic.getMissHitCound();
    }

    public int getGeneralHitCount() {
        return generalHitCount;
    }

    public void setGeneralHitCount(int generalHitCount) {
        this.generalHitCount = generalHitCount;
    }

    public void incGeneralHitCount() {
        this.generalHitCount++;
    }

    public int getMissHitCount() {
        return missHitCount;
    }

    public void setMissHitCount(int missHitCount) {
        this.missHitCount = missHitCount;
    }


    public void incMissHitCount() {
        this.missHitCount++;
        incGeneralHitCount();
    }
}
