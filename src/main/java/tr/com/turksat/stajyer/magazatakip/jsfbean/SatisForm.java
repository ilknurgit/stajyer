package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.*;
import tr.com.turksat.stajyer.magazatakip.service.*;

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
public class SatisForm implements Serializable {

    private Urun urun;
    private Kullanici kullanici;
    private Musteri musteri;
    private Satis satis;
    SatisService satisService=new SatisService();
    UrunService urunService =new UrunService();
    MusteriService musteriService =new MusteriService();
    UrunTanimiService urunTanimiService=new UrunTanimiService();
    UrunTipiService urunTipiService=new UrunTipiService();
    List<Urun> urunler = new ArrayList();
    List<Musteri> musteriler = new ArrayList();


    public SatisForm() {

    }

    @PostConstruct
    public void init() {
        satis = new Satis();
    }

    public String satisYap(Satis satis) {
        satisService.satisYap(satis);
        urunService.urunSil(satis.getUrun());
        urunTanimiService.urunTanimiSil(satis.getUrun().getUrunTanimi());
        urunTipiService.urunTipiSil(satis.getUrun().getUrunTanimi().getUrunTipi());

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_WARN,
                        "Satış yapılmıştır",
                        ""));
        return "formSatis";
    }




    public Urun getUrun() {
        return urun;
    }

    public void setUrun(Urun urun) {
        this.urun = urun;
    }

    public Kullanici getKullanici() {
        return kullanici;
    }

    public void setKullanici(Kullanici kullanici) {
        this.kullanici = kullanici;
    }

    public Satis getSatis() {
        return satis;
    }

    public void setSatis(Satis satis) {
        this.satis = satis;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public List<Urun> getUrunler() {
        return urunService.getUrunler();
    }

    public void setUrunler(List<Urun> urunler) {
        this.urunler = urunler;
    }

    public List<Musteri> getMusteriler() {
        return musteriService.getMusteriler();
    }

    public void setMusteriler(List<Musteri> musteriler) {
        this.musteriler = musteriler;
    }
}