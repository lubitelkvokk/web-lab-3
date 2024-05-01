package weblab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import lombok.NoArgsConstructor;
import weblab3.dao.HitDao;
import weblab3.models.HitStatistic;
import weblab3.util.ManagementUtil;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;
import java.io.Serializable;

@Named
@ApplicationScoped
@NoArgsConstructor
public class HitCounterBean extends NotificationBroadcasterSupport implements HitCounterMXBean, Serializable {

    private int generalHitCount;
    private int missHitCount;

    @Inject
    public HitCounterBean(HitDao hitDao) {
        HitStatistic hitStatistic = hitDao.getHitCount();
        generalHitCount = hitStatistic.getHitCount();
        missHitCount = hitStatistic.getMissHitCount();
        try {
            ManagementUtil.registerBean(this);
        } catch (Exception e){
            e.printStackTrace();
        }
        checkAndSendNotification();
    }

    public int getGeneralHitCount() {
        return generalHitCount;
    }

    public void setGeneralHitCount(int generalHitCount) {
        this.generalHitCount = generalHitCount;
    }

    public void incGeneralHitCount() {
        this.generalHitCount++;
        checkAndSendNotification();
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

    private synchronized void checkAndSendNotification() {
        if (generalHitCount % 10 == 0) {
            Notification notification = new Notification(
                    "HitCountNotification",
                    this,
                    System.currentTimeMillis(),
                    "Total hit count is now a multiple of 10: " + generalHitCount
            );
            sendNotification(notification);
        }
    }
}

