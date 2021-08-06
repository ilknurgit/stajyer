package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.UrunTipi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/*
 * @author iuysal
 * @since  6.08.2021
 */
public class UrunTipiDao {

    public List<UrunTipi> getUrunTipleri() {


        Connection con = null;
        PreparedStatement ps = null;
        List<UrunTipi> kullaniciList = new ArrayList<>();
        try {

            con = Database.getInstance().getConnection();
            ps = con.prepareStatement(
                    "select id, type from stajyer.urun_tipi ");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                UrunTipi urunTipi = new UrunTipi();

                Long id  = rs.getLong("id");
                String name = rs.getString("type");
                urunTipi.setId(Integer.valueOf(id!=null?id.toString():"null"));
                urunTipi.setUrunTipi(name);
                kullaniciList.add(urunTipi);

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
