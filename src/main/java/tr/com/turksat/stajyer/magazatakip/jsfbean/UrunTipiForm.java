package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.MarkaTipi;
import tr.com.turksat.stajyer.magazatakip.domain.ModelTipi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */

@ManagedBean
public class UrunTipiForm implements Serializable {

    UrunTipiService urunTipiService = new UrunTipiService();
    List<UrunTipi> urunTipleri = new ArrayList();
    private String silinecekUrunTipi = "";
    private String urunTipiid = "";
    private UrunTipi urunTipi;

    public UrunTipiForm() {

    }

    @PostConstruct
    public void init() {
        urunTipi = new UrunTipi();
        urunTipleri=urunTipiService.getUrunTipleri();

    }


    public UrunTipi getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(UrunTipi urunTipi) {
        this.urunTipi = urunTipi;
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



    public String urunTipiEkle() {
        if (urunTipi.getId() == -1) {
            KullaniciService service = new KullaniciService();
//            service.UruntipEkle(uruntipi);
        } else {
            KullaniciService service = new KullaniciService();
//            service.UruntipGuncelle(uruntipi);
        }
        urunTipi = new UrunTipi();
        return null;
    }


    public String sil() {
        System.out.println("urunTipi" + silinecekUrunTipi);
        KullaniciService service = new KullaniciService();
//        service.urunTipiSil(silinecekUrunTipi);
        return null;
    }

    public void urunTipiTemizle() {
        this.urunTipi = null;
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
}
