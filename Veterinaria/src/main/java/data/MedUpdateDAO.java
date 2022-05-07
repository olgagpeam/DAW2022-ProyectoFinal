/*
 *  
 */

package data;

import data.DBConnection;
import model.MedUpdate;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class MedUpdateDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM med_updates";
    public static final String insertSQL = "INSERT INTO med_updates (r_id, med_updated_at, r_user_med, updates) VALUES (?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE med_updates SET r_id = ?, med_updated_at = ?, r_user_med = ?, updates = ? WHERE id_medu = ?";
    public static final String deleteSQL = "DELETE FROM med_updates WHERE id_medu = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    public ArrayList<MedUpdate> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        MedUpdate med = null;
         
        ArrayList<MedUpdate> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                int r_id = rs.getInt(2);
                Timestamp updatedAt = rs.getTimestamp(3);
                String r_user = rs.getString(4);
                String updates = rs.getString(5);

                med = new MedUpdate(id, r_id, updatedAt, r_user, updates);

                lista.add(med);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(MedUpdate med) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setInt(1, med.getR_id());
            st.setTimestamp(2, med.getUpdated_at());
            st.setString(3, med.getR_user());
            st.setString(4, med.getUpdates());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(MedUpdate med, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setInt(1, med.getR_id());
            st.setTimestamp(2, med.getUpdated_at());
            st.setString(3, med.getR_user());
            st.setString(4, med.getUpdates());
            
            st.setInt(5, id);

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
