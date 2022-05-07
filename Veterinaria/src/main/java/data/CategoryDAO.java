/*
 *  
 */

package data;

import model.Category;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class CategoryDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM category";
    public static final String insertSQL = "INSERT INTO category (cat) VALUES (?)";
    public static final String updateSQL = "UPDATE category SET cat = ? WHERE id_cat = ?";
    public static final String deleteSQL = "DELETE FROM category WHERE id_cat = ? ";
    
    public ArrayList<Category> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Category cat = null;
         
        ArrayList<Category> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String nom = rs.getString(2);

                cat = new Category(id, nom);

                lista.add(cat);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Category cat) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, cat.getCategory());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Category cat, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, cat.getCategory());
            
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
