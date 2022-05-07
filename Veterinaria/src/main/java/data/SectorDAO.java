/*
 *  
 */

package data;

import model.Sector;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class SectorDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM sector";
    public static final String insertSQL = "INSERT INTO sector (id_sector, sector) VALUES (?, ?)";
    public static final String updateSQL = "UPDATE sector SET sector = ? WHERE id_sector = ?";
    public static final String deleteSQL = "DELETE FROM sector WHERE id_sector = ? ";
    
    public ArrayList<Sector> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Sector sec = null;
         
        ArrayList<Sector> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String idS = rs.getString(1);
                char id = idS.charAt(0);
                String sect = rs.getString(2);

                sec = new Sector(id, sect);

                lista.add(sec);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Sector sec) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, sec.getId() + "");
            st.setString(2, sec.getSector());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Sector sec, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, sec.getSector());
            
            st.setString(2, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(deleteSQL);
            st.setString(1, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
