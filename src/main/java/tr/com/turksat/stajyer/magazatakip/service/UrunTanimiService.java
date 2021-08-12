package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.UrunTanimiDao;
import tr.com.turksat.stajyer.magazatakip.dao.UrunTipiDao;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTanimi;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.util.List;

public class UrunTanimiService {

    UrunTanimiDao urunTanimiDao;
    public UrunTanimiService() {
        urunTanimiDao=new UrunTanimiDao();
    }

    public List<UrunTanimi> getUrunTanimlari() {
        return urunTanimiDao.getUrunTanimlari();
    }

    public String urunTanimiEkle(UrunTanimi urunTanimi) {

        return urunTanimiDao.urunTanimiEkle(urunTanimi);
    }

    public boolean urunTanimiSil(UrunTanimi urunTanimi) {

        return urunTanimiDao.urunTanimiSil(urunTanimi);
    }

}
