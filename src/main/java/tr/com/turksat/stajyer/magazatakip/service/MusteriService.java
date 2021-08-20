package tr.com.turksat.stajyer.magazatakip.service;


import tr.com.turksat.stajyer.magazatakip.dao.MusteriDao;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.Musteri;

import java.util.List;


/*
 * @author iuysal
 * @since  20.08.2021
 */
public class MusteriService {
    MusteriDao musteriDao;

    public MusteriService() {
        musteriDao=new MusteriDao();
    }

    public String musteriEkle(Musteri musteri) {
        return musteriDao.musteriEkle(musteri);
    }

    public List<Musteri> getMusteriler() {

        return musteriDao.getMusteriler();
    }

    public Musteri findMusteri(Integer id)
    {
        return musteriDao.findMusteri(id);
    }
}
