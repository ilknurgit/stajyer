package tr.com.turksat.stajyer.magazatakip.jsfbean;

/**.
 * Created by iuysal on 05.08.2021
 */


import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("urunTanimiConverter")
@ManagedBean
public class UrunTanimiConverter implements Converter {

    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && value.trim().length() > 0) {
            try {
                return Integer.valueOf(value);
            } catch (NumberFormatException e) {
                throw new ConverterException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conversion Error", "Not a valid theme."));
            }
        } else {
            return null;
        }
    }
    //test
    public String getAsString(FacesContext fc, UIComponent uic, Object object) {
        if (object == null || object.equals("")) {
            return "";
        } else {
            if(object instanceof String)
                return (String) object;
            if(object instanceof Integer)
                return String.valueOf(object);
            if (object != null) {
                return String.valueOf(((UrunTanimi) object).getId());
            }
        }
        return "-1";
    }
}