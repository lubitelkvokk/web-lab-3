package weblab3.beans;


import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@Named("clock")
@RequestScoped
public class Clock {
    public String redirect() {
        return "success";
    }
}
