package tr.com.turksat.stajyer.magazatakip.jsfbean;

/**
 * Created by scinkir on 10.07.2015.
 */


import tr.com.turksat.stajyer.magazatakip.domain.MarkaTipi;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("markaTipiConverter")
public class MarkaTipiConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                MarkaTipi urunTipi = new MarkaTipi();
                urunTipi.setMarkatipi("cep");
                return urunTipi;
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object == null || object.equals("")) {
            return "";
        } else {
            if(object instanceof String)
                return (String) object;
            if (object != null) {
                return String.valueOf(((MarkaTipi) object).getMarkatipi());
            }
        }
        return "-1";
    }
}