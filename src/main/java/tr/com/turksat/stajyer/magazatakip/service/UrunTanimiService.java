package tr.com.turksat.stajyer.magazatakip.service;


import tr.com.turksat.stajyer.magazatakip.dao.UrunTanimiDao;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;

import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */

// iş mantıkları - ekle ,sil, güncelle
public class UrunTanimiService {
    UrunTanimiDao urunTanimiDao;
    public UrunTanimiService() {
        urunTanimiDao=new UrunTanimiDao();
    }

    public List<UrunTanimi> getUrunTanimleri() {
        return urunTanimiDao.getUrunTanimleri();
    }

    public String urunTanimiEkle(UrunTanimi urunTanimi) {
        return urunTanimiDao.urunTanimiEkle(urunTanimi);
    }
    public boolean urunTanimiSil(UrunTanimi urunTanimi) {
        return urunTanimiDao.urunTanimiSil(urunTanimi);
    }
}