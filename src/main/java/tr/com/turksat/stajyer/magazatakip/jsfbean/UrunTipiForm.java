package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */

@ManagedBean
//Controller classlarımız
public class UrunTipiForm implements Serializable {

    UrunTipiService urunTipiService = new UrunTipiService();
    List<UrunTipi> urunTipleri = new ArrayList();
    private UrunTipi urunTipi;
    private String urunTipiId="";

    public UrunTipiForm() {

    }

    //bu method sayfa ilk geldiği anda görüntülemeyi sağlar.
    @PostConstruct
    public void init() {
        urunTipi = new UrunTipi();
        urunTipleri=urunTipiService.getUrunTipleri();

    }

    public String urunTipiEkle() {


         urunTipiService.urunTipiEkle(urunTipi);

        return "";
    }


    public String urunTipiSil() {
        urunTipiService.urunTipiSil(urunTipi);
        return "";
    }

    public void urunTipiTemizle() {
        this.urunTipi = null;
    }

    public String guncelle() {
//        uruntipi = service.getUrunTipi(urunTipiid);
        return null;
    }

    public List<UrunTipi> getUrunTipleri() {
        return urunTipleri;
    }

    public void setUrunTipleri(List<UrunTipi> urunTipleri) {
        this.urunTipleri = urunTipleri;
    }


    public UrunTipi getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(UrunTipi urunTipi) {
        this.urunTipi = urunTipi;
    }

    public String getUrunTipiId() {
        return urunTipiId;
    }

    public void setUrunTipiId(String urunTipiId) {
        this.urunTipiId = urunTipiId;
    }
}
