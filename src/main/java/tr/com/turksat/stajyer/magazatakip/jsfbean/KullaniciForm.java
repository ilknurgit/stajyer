package tr.com.turksat.stajyer.magazatakip.jsfbean;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.MarkaTipi;
import tr.com.turksat.stajyer.magazatakip.domain.ModelTipi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.service.KullaniciService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
public class KullaniciForm implements Serializable {

    KullaniciService kullaniciService = new KullaniciService();
    List<MarkaTipi> markalar = new ArrayList();
    List<UrunTipi> urunTipleri = new ArrayList();
    List<Kullanici> kullanicilar = new ArrayList<>();
    private Kullanici kullanici;
    private String silinecekUrunTipi = "";
    private String urunTipiid = "";
    private UrunTipi uruntipi;
    private ModelTipi modeltipi = new ModelTipi();
    private MarkaTipi markatipi = new MarkaTipi();


    public KullaniciForm() {

    }

    @PostConstruct
    public void init() {
        uruntipi = new UrunTipi();
        kullanici = new Kullanici();
        modeltipi = new ModelTipi();
        markatipi = new MarkaTipi();
//        markalar= new KullaniciService().getMarkalar(uruntipi);
//        urunTipleri=new KullaniciService().getUrunTipleri();
//        UrunTipi urunTipi1 = new UrunTipi();
//        urunTipi1.setUruntipi("cep telefonu");
//        urunTipi1.setId(1);
//        UrunTipi urunTipi2 = new UrunTipi();
//        urunTipi2.setUruntipi("tablet");
//        urunTipi2.setId(2);
//        UrunTipi urunTipi3 = new UrunTipi();
//        urunTipi3.setUruntipi("bilgisayar");
//        urunTipi3.setId(3);
//        urunTipleri.add(urunTipi1);
//        urunTipleri.add(urunTipi2);
//        urunTipleri.add(urunTipi3);

          urunTipleri=kullaniciService.urunTipiList();

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

    //MODEL TİP SET VE GET
    public ModelTipi getModeltipi() {
        return modeltipi;
    }

    public void setModeltipi(ModelTipi modeltipi) {
        this.modeltipi = modeltipi;
    }

    //MARKA TİP SET GET
    public MarkaTipi getMarkatipi() {
        return markatipi;
    }

    public void setMarkatipi(MarkaTipi markatipi) {
        this.markatipi = markatipi;
    }


    //MODEL TİPLERİ LİSTESİ SET VE GET
    public List<ModelTipi> getModeltiplist() {
        return new ArrayList<>();
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

    public List<MarkaTipi> getMarkalar() {
        return markalar;
    }

    public void setMarkalar(List<MarkaTipi> markalar) {
        this.markalar = markalar;
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