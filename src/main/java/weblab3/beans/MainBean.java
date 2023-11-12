package weblab3.beans;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;

// Аннотации managed bean компонента
@Named("main") // определение managed bean и его наименования
@ApplicationScoped          // определение времени жизни - request
public class MainBean
{

    public void validateY(FacesContext context, UIComponent component, Object value) {
        double yValue = (Double) value;
        if (yValue < -5 || yValue > 3) {
            FacesMessage message = new FacesMessage("Неверное значение! Введите число от -5 до 3.");
            throw new ValidatorException(message);
        }
    }
}