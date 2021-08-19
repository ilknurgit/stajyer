package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.UrunTanimiDao;
import tr.com.turksat.stajyer.magazatakip.dao.UrunTipiDao;
import tr.com.turksat.stajyer.magazatakip.dao.UrunDao;
import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;
import tr.com.turksat.stajyer.magazatakip.domain.Urun;
import java.util.List;

public class UrunService {

    UrunDao urunDao;
    public UrunService(){
        urunDao = new UrunDao();
    }

//    public List<Urun> getUrunler(){
//        return  urunDao.getUrunler();
//    }

    public String urunEkle(Urun urun, UrunTanimi urunTanimi, Kullanici kullanici){
        return urunDao.urunEkle(urun, urunTanimi,kullanici);
    }

    public boolean urunSil(Urun urun){
        return urunDao.urunSil(urun);
    }

}