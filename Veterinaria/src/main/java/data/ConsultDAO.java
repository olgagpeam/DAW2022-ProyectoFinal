/*
 *  
 */

package data;

import model.Consult;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ConsultDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM consult";
    public static final String insertSQL = "INSERT INTO consult (consult) VALUES (?)";
    public static final String updateSQL = "UPDATE consult SET consult = ? WHERE id_consult = ?";
    public static final String deleteSQL = "DELETE FROM consult WHERE id_consult = ? ";
    
    public ArrayList<Consult> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Consult cons = null;
         
        ArrayList<Consult> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);

                cons = new Consult(id, nom);

                lista.add(cons);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Consult cons) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, cons.getTypeConsult());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Consult cons, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, cons.getTypeConsult());
            
            st.setInt(2, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(deleteSQL);
            st.setInt(1, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
