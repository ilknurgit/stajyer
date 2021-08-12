package tr.com.turksat.stajyer.magazatakip.jsfbean;

/**.
 * Created by iuysal on 05.08.2021
 */


import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("urunTipiConverter")
@ManagedBean
public class UrunTipiConverter implements Converter {

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
    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        UrunTipi urunTipi = (UrunTipi) value;
    return urunTipi.getUrunTipi() != null ? String.valueOf(urunTipi.getId()) : null;
    }
    //test

}