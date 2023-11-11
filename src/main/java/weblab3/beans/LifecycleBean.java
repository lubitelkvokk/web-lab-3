package weblab3.beans;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.PhaseEvent;
import jakarta.faces.event.PhaseId;
import jakarta.inject.Named;

@Named("helloBean")
@ApplicationScoped
public class LifecycleBean {
    public LifecycleBean() {
        System.out.println("SDASADASDSAD");
    }

    public String getMessage() {
        return "Hello, world";
    }

    public void phaseTest(PhaseEvent evt) throws Exception {
        try {
            if (PhaseId.APPLY_REQUEST_VALUES.equals(evt.getPhaseId())) {
                System.out.println("Phase is " + PhaseId.APPLY_REQUEST_VALUES);
            }
            if (PhaseId.INVOKE_APPLICATION.equals(evt.getPhaseId())) {
                System.out.println("Phase is " + PhaseId.INVOKE_APPLICATION);
            }
            if (PhaseId.RENDER_RESPONSE.equals(evt.getPhaseId())) {
                System.out.println("Phase is " + PhaseId.RENDER_RESPONSE);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public String actionSubmit() {
        System.out.println("Нажатие на кнопку Submit");
        return "wellcome.xhtml";
    }
}