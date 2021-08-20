package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Musteri;
import tr.com.turksat.stajyer.magazatakip.service.MusteriService;
import tr.com.turksat.stajyer.magazatakip.service.MusteriService;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("musteriConverter")
@ManagedBean
public class MusteriConverter implements Converter {

    MusteriService musteriService =new MusteriService();
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }
        try {
            return musteriService.findMusteri(Integer.valueOf(submittedValue));
        }
        catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Musteri ID"), e);
        }

    }
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return ""; // Never return null here!
        }

        if (modelValue instanceof Musteri) {
            return String.valueOf(((Musteri) modelValue).getId());
        }
        else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Musteri"));
        }

    }


}

