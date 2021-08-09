package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**.
 * Created by iuysal on 05.08.2021
 */
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
//        KullaniciService service = new KullaniciService();
//        if (service.kullaniciGiris(kullanici)) {
//            return "anaekran/anaekran";
//        }
        return "uruntanimi";
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