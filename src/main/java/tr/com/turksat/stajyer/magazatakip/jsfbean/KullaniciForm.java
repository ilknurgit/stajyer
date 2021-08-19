package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;

import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class KullaniciForm implements Serializable {

    KullaniciService kullaniciService = new KullaniciService();
    List<Kullanici> kullanicilar = new ArrayList<>();
    private Kullanici kullanici;

    public KullaniciForm() {

    }

    @PostConstruct
    public void init() {
        kullanici = new Kullanici();


        kullanicilar = kullaniciService.getKullanicilar();
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    //KULLANICI SET
    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }



    //GİRİŞ YAP
    public String kullaniciGiris() {
        if (kullaniciService.kullaniciGiris(kullanici) == true){
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Başarılı giriş yapılmıştır.",
                            "Şifre ve Kullanıcı adı doğru."));
            return "kullaniciListesi";
        }
        else{
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Şifre ve Kullanıcı Adı hatalı.",
                            "Şifre ve Kullanıcı adı doğru."));
            return "yetkisizKullanici";
        }
    }



    public String kullaniciKaydet() {
        KullaniciService service = new KullaniciService();
//        service.kullaniciKaydet(kullanici);
        return null;
    }



    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }
}