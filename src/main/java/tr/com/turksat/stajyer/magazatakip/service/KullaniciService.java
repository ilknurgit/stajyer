package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.KullaniciDao;
import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scinkir on 25.06.2015.
 */
public class KullaniciService {
    KullaniciDao kullaniciDao;

    public KullaniciService() {
        kullaniciDao=new KullaniciDao();
    }

    public boolean kullaniciGiris(Kullanici kullanici) {
        return kullaniciDao.girisYap(kullanici);
    }

    public List<Kullanici> getKullanicilar() {

        return kullaniciDao.getKullanicilar();
    }


    public List<UrunTipi> urunTipiList() {


        return kullaniciDao.getUrunTipleri();
    }
}