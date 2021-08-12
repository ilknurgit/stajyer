package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Kullanici;
import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**.
 * Created by iuysal on 05.08.2021
 */
public class KullaniciDao {

    public boolean  girisYap(Kullanici kullanici){
        Connection con = null;
        PreparedStatement ps = null;
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select kullanici_adi, sifre from tb_kullanici where kullanici_adi= ? and sifre= ? ");
            ps.setString(1, kullanici.getKullaniciAdi());
            ps.setString(2, kullanici.getSifre());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {

                return true;
            }
            else {
                return false;
            }
        } catch (Exception ex) {
            System.out.println("hatalı giriş");
            return false;
        } finally {
            Database.close(con);
        }
    }

    public List<Kullanici> getKullanicilar() {
        Connection con = null;
        PreparedStatement ps = null;
        List<Kullanici> kullaniciList = new ArrayList<>();
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select * from stajyer.tb_kullanici ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                Kullanici kullanici = new Kullanici();

                Long id  = rs.getLong("id");
                String name = rs.getString("kullanici_adi");
                kullanici.setKullaniciAdi(id!=null?id.toString():"null");
                kullanici.setAdsoyad(name);
                kullaniciList.add(kullanici);

            }

        } catch (Exception ex) {
            System.out.println("hatalı giriş "+ex.getLocalizedMessage());
            return kullaniciList;
        } finally {
            Database.close(con);
        }


        return kullaniciList;
    }



}
