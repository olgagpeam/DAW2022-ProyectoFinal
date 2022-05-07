/*
 *  
 */

package data;

import data.DBConnection;
import model.Service;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ServiceDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM service";
    public static final String insertSQL = "INSERT INTO service (service) VALUES (?)";
    public static final String updateSQL = "UPDATE service SET service = ? WHERE id_service = ?";
    public static final String deleteSQL = "DELETE FROM service WHERE id_service = ? ";
    
    public ArrayList<Service> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Service ser = null;
         
        ArrayList<Service> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);

                ser = new Service(id, nom);

                lista.add(ser);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Service ser) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, ser.getService());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Service ser, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, ser.getService());
            
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
