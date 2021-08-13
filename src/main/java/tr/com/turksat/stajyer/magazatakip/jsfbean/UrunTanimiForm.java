package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTipiService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@RequestScoped
public class UrunTanimiForm implements Serializable {
    UrunTipiService urunTipiService = new UrunTipiService();
    UrunTanimiService urunTanimiService = new UrunTanimiService();
    List<UrunTanimi> urunTanimlari = new ArrayList();
    private UrunTanimi urunTanimi;
    private String urunTanimiId="";
    List<UrunTipi> urunTipleri = new ArrayList();
    private UrunTipi urunTipi;
    private String selected;

    public UrunTanimiForm() {

    }

    //bu method sayfa ilk geldiği anda görüntülemeyi sağlar.
    @PostConstruct
    public void init() {
     urunTanimi=new UrunTanimi();

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


    public List<UrunTipi> getUrunTipleri() {
        return  urunTipiService.getUrunTipleri();
    }

    public UrunTipi getUrunTipi() {
        return urunTipi;
    }

    public void setUrunTipi(UrunTipi urunTipi) {
        this.urunTipi = urunTipi;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }
}
