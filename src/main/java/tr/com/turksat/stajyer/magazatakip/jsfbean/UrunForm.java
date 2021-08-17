package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.UrunService;
import tr.com.turksat.stajyer.magazatakip.service.UrunTanimiService;

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
public class UrunForm implements Serializable {

    UrunService urunService = new UrunService();
    UrunTanimiService urunTanimiService = new UrunTanimiService();
    List<Urun> urunler = new ArrayList();
    List<UrunTanimi> urunTanimlari = new ArrayList();
    private Urun urun;
    private String urunId = "";
    private UrunTanimi urunTanimi;
    public UrunForm() {

    }

    @PostConstruct
    public void init() {
        urun = new Urun();
    }

    public String urunEkle() {

        urunService.urunEkle(urun);
        return "formUrun";
    }

    public String urunSil() {
        urunService.urunSil(urun);
        return "listeUrun";
    }

    public void urunTemizle() {
        this.urun = null;
    }

    public String guncelle() {
//        urun = service.getUrun(urunid);
        return null;
    }

    public List<Urun> getUrunler() {
        return urunService.getUrunler();
    }

    public void setUrunler(List<Urun> urunler) {
        this.urunler = urunler;
    }

    public UrunService getUrunService() {
        return urunService;
    }

    public void setUrunService(UrunService urunService) {
        this.urunService = urunService;
    }

    public UrunTanimiService getUrunTanimiService() {
        return urunTanimiService;
    }

    public void setUrunTanimiService(UrunTanimiService urunTanimiService) {
        this.urunTanimiService = urunTanimiService;
    }

    public List<UrunTanimi> getUrunTanimlari() {
        return urunTanimlari;
    }

    public void setUrunTanimlari(List<UrunTanimi> urunTanimlari) {
        this.urunTanimlari = urunTanimlari;
    }

    public String getUrunId() {
        return urunId;
    }

    public void setUrunId(String urunId) {
        this.urunId = urunId;
    }

    public UrunTanimi getUrunTanimi() {
        return urunTanimi;
    }

    public void setUrunTanimi(UrunTanimi urunTanimi) {
        this.urunTanimi = urunTanimi;
    }

    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }
}
