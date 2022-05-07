/*
 *  
 */

package data;

import model.Owner;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class OwnerDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM owners";
    public static final String insertSQL = "INSERT INTO users (ine, name_ownr, bdate_ownr, addr_ownr, cel_ownr, tel_uownr, email_ownr) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE users SET name_ownr = ?, bdate_ownr = ? addr_ownr = ?, cel_ownr = ?, tel_uownr = ?, email_ownr = ? WHERE ine = ?";
    public static final String deleteSQL = "DELETE FROM users WHERE id_usr = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    
    public ArrayList<Owner> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Owner ownr = null;
         
        ArrayList<Owner> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String ine = rs.getString(1);
                String name = rs.getString(2);
                Date bdate = new Date(df.parse(rs.getString(3)).getTime());
                String addr = rs.getString(4);
                String tel = rs.getString(5);
                String cel = rs.getString(6);
                String email = rs.getString(7);

                ownr = new Owner(ine, name, bdate, addr, tel, cel, email);

                lista.add(ownr);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Owner ownr) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, ownr.getIne());
            st.setString(2, ownr.getName());
            st.setDate(3, ownr.getBdate());
            st.setString(4, ownr.getAddr());
            st.setString(5, ownr.getTel());
            st.setString(6, ownr.getCel());
            st.setString(7, ownr.getEmail());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Owner ownr, String ine) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, ownr.getName());
            st.setDate(2, ownr.getBdate());
            st.setString(3, ownr.getAddr());
            st.setString(4, ownr.getTel());
            st.setString(5, ownr.getCel());
            st.setString(6, ownr.getEmail());
            
            st.setString(7, ine);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String ine) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(deleteSQL);
            st.setString(1, ine);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}