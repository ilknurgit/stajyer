package tr.com.turksat.stajyer.magazatakip.jsfbean;

/**.
 * Created by iuysal on 05.08.2021
 */


import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.UrunService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.persistence.Entity;


@FacesConverter("urunTipiConverter")
@ManagedBean
public class UrunTipiConverter implements Converter {

    UrunTipiService urunTipiService = new UrunTipiService();

    public UrunTipiConverter() {
    }

    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return urunTipiService.findUrunTipi(Long.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Warehouse ID"), e);
        }

    }
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return ""; // Never return null here!
        }

        if (modelValue instanceof UrunTipi) {
            return String.valueOf(((UrunTipi) modelValue).getId());
        } else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid UrunTipi"));
        }
    }
    //test

}