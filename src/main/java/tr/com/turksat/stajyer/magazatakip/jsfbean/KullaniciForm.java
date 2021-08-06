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

@ManagedBean
public class KullaniciForm implements Serializable {

    KullaniciService kullaniciService = new KullaniciService();
    UrunTipiService urunTipiService = new UrunTipiService();
    List<UrunTipi> urunTipleri = new ArrayList();
    List<Kullanici> kullanicilar = new ArrayList<>();
    private Kullanici kullanici;
    private String silinecekUrunTipi = "";
    private String urunTipiid = "";
    private UrunTipi uruntipi;


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


    //URUN TİP SET VE GET
    public UrunTipi getUruntipi() {
        return uruntipi;
    }

    public void setUruntipi(UrunTipi uruntipi) {
        this.uruntipi = uruntipi;
    }


    //SİLİNECEK URUNUNTİPİNİN SET VE GET
    public String getSilinecekUrunTipi() {
        return silinecekUrunTipi;
    }

    public void setSilinecekUrunTipi(String silinecekUrunTipi) {
        this.silinecekUrunTipi = silinecekUrunTipi;
    }


    //URUN TİPİ IDSİ SET VE GET
    public String getId() {
        return urunTipiid;
    }

    public void setId(String id) {
        this.urunTipiid = id;
    }


    //GİRİŞ YAP
    public String kullaniciGiris() {
//        KullaniciService service = new KullaniciService();
//        if (service.kullaniciGiris(kullanici)) {
//            return "anaekran/anaekran";
//        }
        return "uruntanimi";
    }

    public String urunTipiEkle() {
        if (uruntipi.getId() == -1) {
            KullaniciService service = new KullaniciService();
//            service.UruntipEkle(uruntipi);
        } else {
            KullaniciService service = new KullaniciService();
//            service.UruntipGuncelle(uruntipi);
        }
        uruntipi = new UrunTipi();
        return null;
    }

    public String kullaniciKaydet() {
        KullaniciService service = new KullaniciService();
//        service.kullaniciKaydet(kullanici);
        return null;
    }

    public String sil() {
        System.out.println("urunTipi" + silinecekUrunTipi);
        KullaniciService service = new KullaniciService();
//        service.urunTipiSil(silinecekUrunTipi);
        return null;
    }

    public void urunTipiTemizle() {
        this.uruntipi = null;
    }

    public String guncelle() {
        System.out.println("urunTipi" + silinecekUrunTipi);
        KullaniciService service = new KullaniciService();
//        uruntipi = service.getUrunTipi(urunTipiid);
        return null;
    }

    public List<UrunTipi> getUrunTipleri() {
        return urunTipleri;
    }

    public void setUrunTipleri(List<UrunTipi> urunTipleri) {
        this.urunTipleri = urunTipleri;
    }

    public void filtreMarka() {
        if (uruntipi != null && uruntipi.getId() != -1) ;
//            markalar=new KullaniciService().getMarkalar(uruntipi);
    }

    public void filtreMarka2(AjaxBehaviorEvent event) {
        if (uruntipi != null) ;
//            markalar=new KullaniciService().getMarkalar(uruntipi);

    }

    public List<Kullanici> getKullanicilar() {
        return kullanicilar;
    }
}