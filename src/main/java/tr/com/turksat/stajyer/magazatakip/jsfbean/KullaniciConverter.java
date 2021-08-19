package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;

import javax.annotation.ManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;


@FacesConverter("kullaniciConverter")
@ManagedBean
public class KullaniciConverter  implements Converter {

      KullaniciService kullaniciService =new KullaniciService();
    public Object getAsObject(FacesContext context, UIComponent component, String submittedValue) {
        if (submittedValue == null || submittedValue.isEmpty()) {
            return null;
        }

        try {
            return kullaniciService.findKullanici(Integer.valueOf(submittedValue));
        } catch (NumberFormatException e) {
            throw new ConverterException(new FacesMessage(submittedValue + " is not a valid Kullanici ID"), e);
        }

    }
    public String getAsString(FacesContext context, UIComponent component, Object modelValue) {
        if (modelValue == null) {
            return ""; // Never return null here!
        }

        if (modelValue instanceof Kullanici) {
            return String.valueOf(((Kullanici) modelValue).getId());
        }
        else {
            throw new ConverterException(new FacesMessage(modelValue + " is not a valid Kullanici"));
        }

    }


}

