/*
 *  
 */

package data;

import model.Sex;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class SexDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM sex";
    public static final String insertSQL = "INSERT INTO sex (id_sex, sex) VALUES (?, ?)";
    public static final String updateSQL = "UPDATE sex SET sex = ? WHERE id_sex = ?";
    public static final String deleteSQL = "DELETE FROM sex WHERE id_sex = ? ";
    
    public ArrayList<Sex> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Sex sex = null;
         
        ArrayList<Sex> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String idS = rs.getString(1);
                char id = idS.charAt(0);
                String sexx = rs.getString(2);

                sex = new Sex(id, sexx);

                lista.add(sex);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Sex sex) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, sex.getId() + "");
            st.setString(2, sex.getSex());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Sex sex, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, sex.getSex());
            
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
