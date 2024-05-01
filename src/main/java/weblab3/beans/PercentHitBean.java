package weblab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import weblab3.util.ManagementUtil;

import java.io.Serializable;

@ApplicationScoped
@Named

public class PercentHitBean implements PercentHitMXBean, Serializable {

    @Inject
    private HitCounterBean hitCounterBean;

    public PercentHitBean(){
        try {
            ManagementUtil.registerBean(this);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public double getHitPercent() {
        return (double) (hitCounterBean.getGeneralHitCount() - hitCounterBean.getMissHitCount()) / hitCounterBean.getGeneralHitCount() * 100;
    }

}
