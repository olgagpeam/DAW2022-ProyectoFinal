/*
 *  
 */
package data;

import model.ProdUpdate;
import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ProdUpdateDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM prod_updates";
    public static final String insertSQL = "INSERT INTO prod_updates (r_prod, prod_updated_at, r_user_prod, notes_prod) VALUES (?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE prod_updates SET r_id = ?, prod_updated_at = ?, r_user_prod = ?, notes_prod = ? WHERE id_produ = ?";
    public static final String deleteSQL = "DELETE FROM prod_updates WHERE id_produ = ? ";

    public ArrayList<ProdUpdate> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ProdUpdate prod = null;

        ArrayList<ProdUpdate> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String r_id = rs.getString(2);
                Timestamp updatedAt = rs.getTimestamp(3);
                String r_user = rs.getString(4);
                String notes = rs.getString(5);
                prod = new ProdUpdate(id, r_id, updatedAt, r_user, notes);

                lista.add(prod);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(ProdUpdate prod) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, prod.getR_prod());
            st.setTimestamp(2, prod.getUpdatedAt());
            st.setString(3, prod.getR_user());
            st.setString(4, prod.getNotes());
            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(ProdUpdate prod, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, prod.getR_prod());
            st.setTimestamp(2, prod.getUpdatedAt());
            st.setString(3, prod.getR_user());
            st.setString(4, prod.getNotes());

            st.setInt(5, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public int delete(int id) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            ArrayList<ProdUpdate> prod = select();
            for (ProdUpdate search : prod) {
                if (search.getId() == id) {
                    conn = DBConnection.getConnection();
                    st = conn.prepareStatement(deleteSQL);
                    st.setInt(1, id);

                    st.executeUpdate();

                    DBConnection.close(st, conn);
                    return 0;
                }
            }
            return 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
