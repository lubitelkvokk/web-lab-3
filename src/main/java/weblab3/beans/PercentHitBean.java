package weblab3.beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named
@RequestScoped
public class PercentHitBean implements Serializable {

    @Inject
    private HitCounterBean hitCounterBean;

    public double getHitPercent() {
        return (double) (hitCounterBean.getGeneralHitCount() - hitCounterBean.getMissHitCount()) / hitCounterBean.getGeneralHitCount() * 100;
    }

}
