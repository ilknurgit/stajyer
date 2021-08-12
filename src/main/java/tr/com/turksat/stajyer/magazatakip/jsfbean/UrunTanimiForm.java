package tr.com.turksat.stajyer.magazatakip.jsfbean;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UrunTanimiForm implements Serializable {
    UrunTanimiService urunTanimiService = new UrunTanimiService();
    List<UrunTanimi> urunTanimleri = new ArrayList();
    private String urunTanimiId="";
    private UrunTanimi urunTanimi;


    public UrunTanimiForm() {
    }

    //bu method sayfa ilk geldiği anda görüntülemeyi sağlar.
    @PostConstruct
    public void init() {
        urunTanimi = new UrunTanimi();
        urunTanimleri = urunTanimiService.getUrunTanimleri();
    }

    public String urunTanimiEkle() {
        urunTanimiService.urunTanimiEkle(urunTanimi);
        return "formUrunTanimi";

    }

    public String urunTanimiSil() {
        urunTanimiService.urunTanimiSil(urunTanimi);
        return "listeUrunTanimi";
    }

    public void urunTanimiTemizle() {
        this.urunTanimi = null;
    }

    public String guncelle() {
//        urunTanimi = service.getUrunTanimi(urunTanimiid);
        return null;
    }

    public List<UrunTanimi> getUrunTanimleri() {
        return  urunTanimiService.getUrunTanimleri();
    }

    public void setUrunTanimleri(List<UrunTanimi> urunTanimleri) {
        this.urunTanimleri = urunTanimleri;
    }

    public UrunTanimi getUrunTanimi() {
        return urunTanimi;
    }

    public void setUrunTanimi(UrunTanimi urunTanimi) {
        this.urunTanimi = urunTanimi;
    }

    public String getUrunTanimiId() {
        return urunTanimiId;
    }

    public void setUrunTanimiId(String urunTanimiId) {
        this.urunTanimiId = urunTanimiId;
    }
}