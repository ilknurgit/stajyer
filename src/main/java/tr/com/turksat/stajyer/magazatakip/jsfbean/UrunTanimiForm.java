package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class UrunTanimiForm implements Serializable {

    UrunTanimiService urunTanimiService = new UrunTanimiService();
    List<UrunTanimi> urunTanimlari = new ArrayList();
    private UrunTanimi urunTanimi;
    private String urunTanimiId="";

    public UrunTanimiForm() {

    }

    //bu method sayfa ilk geldiği anda görüntülemeyi sağlar.
    @PostConstruct
    public void init() {
        urunTanimi = new UrunTanimi();
        urunTanimlari=urunTanimiService.getUrunTanimlari();

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
//        uruntanimi = service.getUrunTanimi(urunTanimiid);
        return null;
    }

    public List<UrunTanimi> getUrunTanimlari() {
        return  urunTanimiService.getUrunTanimlari();
    }

    public void setUrunTanimlari(List<UrunTanimi> urunTanimlari) {
        this.urunTanimlari = urunTanimlari;
    }


    public UrunTanimi getUrunTanimi() {
        return urunTanimi;
    }

    public void setUrunTanimi(UrunTanimi urunTanimi) {
        this.urunTanimi = urunTanimi;
    }

    public String getUrunTanimiIdId() {
        return urunTanimiId;
    }

    public void setUrunTanimiId(String urunTanimiId) {
        this.urunTanimiId = urunTanimiId;
    }

}
