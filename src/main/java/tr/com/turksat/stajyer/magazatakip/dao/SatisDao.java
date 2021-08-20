package tr.com.turksat.stajyer.magazatakip.dao;

import tr.com.turksat.stajyer.magazatakip.domain.Musteri;
import tr.com.turksat.stajyer.magazatakip.domain.Satis;

import java.sql.Connection;
import java.sql.PreparedStatement;

/*
 * @author iuysal
 * @since  20.08.2021
 */
public class SatisDao {
    PreparedStatement ps = null;
    Connection con = null;
    Integer id = -1;
    int i = 0;
    String errorMessage;
    public String satisYap(Satis satis) {
        try {
            con = Database.getInstance().getConnection();
            ps = con.prepareStatement("INSERT INTO stajyer.satis(musteri_id,urun_id,satis_tarihi) VALUES(?, ?, ?)");
            ps.setInt(1, satis.getMusteri().getId());
            ps.setInt(2, satis.getUrun().getId());
            ps.setString(3, satis.getSatisTarihi());

            i = ps.executeUpdate();

        } catch (Exception exception) {
            System.out.println(exception);
            setErrorMessage(exception.toString());
        } finally {
            try {
                if (con != null) {
                    con.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception sqlException) {
                System.out.println(sqlException);
            }
        }
        if (i > 0) {
            return "basarili?faces-redirect=true";
        } else {
            return "basarisiz?faces-redirect=true";
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
