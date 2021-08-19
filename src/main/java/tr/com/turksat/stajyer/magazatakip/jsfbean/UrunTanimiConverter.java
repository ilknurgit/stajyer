package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.ManagedBean;
import javax.faces.convert.FacesConverter;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

@FacesConverter("urunTanimiConverter")
@ManagedBean
public class UrunTanimiConverter implements Converter {

    UrunTanimiService urunTanimiService = new UrunTanimiService();

    public UrunTanimiConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return urunTanimiService.findUrunTanimi(Integer.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid UrunTanimi ID"), e);
        }

    }
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return ""; // Never return null here!
        }

        if (modelValue instanceof UrunTanimi) {
            return String.valueOf(((UrunTanimi) modelValue).getId());
        }
        else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid UrunTipi"));
        }

    }

}