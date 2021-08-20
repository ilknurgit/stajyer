package tr.com.turksat.stajyer.magazatakip.service;


import tr.com.turksat.stajyer.magazatakip.dao.MusteriDao;
import tr.com.turksat.stajyer.magazatakip.dao.SatisDao;
import tr.com.turksat.stajyer.magazatakip.domain.Musteri;
import tr.com.turksat.stajyer.magazatakip.domain.Satis;


/*
 * @author iuysal
 * @since  20.08.2021
 */
public class SatisService {
    SatisDao satisDao;

    public SatisService() {
        satisDao=new SatisDao();
    }

    public String satisYap(Satis satis) {
        return satisDao.satisYap(satis);
    }


}
