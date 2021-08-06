package tr.com.turksat.stajyer.magazatakip.service;

import tr.com.turksat.stajyer.magazatakip.dao.UrunTipiDao;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */
public class UrunTipiService {

  private UrunTipiDao urunTipiDao;

    public List<UrunTipi> getUrunTipleri() {
        return urunTipiDao.getUrunTipleri();
    }
}
