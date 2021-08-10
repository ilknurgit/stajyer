package tr.com.turksat.stajyer.magazatakip.service;


import tr.com.turksat.stajyer.magazatakip.dao.UrunTipiDao;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */

// iş mantıkları - ekle ,sil, güncelle
public class UrunTipiService {
    UrunTipiDao urunTipiDao;
    public UrunTipiService() {
        urunTipiDao=new UrunTipiDao();
    }

    public List<UrunTipi> getUrunTipleri() {
        return urunTipiDao.getUrunTipleri();
    }

    public String urunTipiEkle(UrunTipi urunTipi) {
        return urunTipiDao.urunTipiEkle(urunTipi);
    }
    public boolean urunTipiSil(UrunTipi urunTipi) {
        return urunTipiDao.urunTipiSil(urunTipi);
    }
}
