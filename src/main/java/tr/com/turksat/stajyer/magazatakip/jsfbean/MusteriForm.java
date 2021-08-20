package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.Musteri;
import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.MusteriService;
import tr.com.turksat.stajyer.magazatakip.service.UrunService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class MusteriForm implements Serializable {


    private String name ;
    private String surname;
    MusteriService musteriService=new MusteriService();
    private Musteri musteri;

    public MusteriForm() {

    }

    @PostConstruct
    public void init() {
        musteri=new Musteri();
    }

    public String musteriEkle(Musteri musteri) {
        musteriService.musteriEkle(musteri);
        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Musteri  eklenmiştir",
                        "Müsteri eklenmiştir;"));
        return "formMusteri";
    }



    public String guncelle() {
//        urun = service.getUrun(urunid);
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }
}
