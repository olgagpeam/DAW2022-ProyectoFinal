/*
 *  
 */

package data;

import model.Product;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ProductDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM products";
    public static final String insertSQL = "INSERT INTO products (id_product, name_prod, description, in_stock, min_stock, price_in, price_out, r_category, created_at, updated_at, is_active) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE products SET name_prod = ?, description = ?, in_stock = ?, min_stock = ?, price_in = ?, price_out = ?, r_category = ?, created_at = ?, updated_at = ?, is_active = ? WHERE id_product = ?";
    public static final String deleteSQL = "DELETE FROM products WHERE id_product = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    public ArrayList<Product> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Product prod = null;
         
        ArrayList<Product> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String id = rs.getString(1);
                String name = rs.getString(2);
                String description = rs.getString(3);
                int inStock = rs.getInt(4);
                int minStock = rs.getInt(5);
                float priceIn = rs.getFloat(6);
                float priceOut = rs.getFloat(0);
                int r_category = rs.getInt(7);
                Timestamp createdAt = rs.getTimestamp(8);
                Timestamp updatedAt = rs.getTimestamp(9);
                boolean isActive = rs.getBoolean(10);

                prod = new Product(id, name, description, inStock, minStock, priceIn, priceOut, r_category, createdAt, updatedAt, isActive);

                lista.add(prod);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Product prod) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, prod.getId());
            st.setString(2, prod.getName());
            st.setString(3, prod.getDescription());
            st.setInt(4, prod.getInStock());
            st.setInt(5, prod.getMinStock());
            st.setFloat(6, prod.getPriceIn());
            st.setFloat(7, prod.getPriceOut());
            st.setInt(8, prod.getR_category());
            st.setTimestamp(9, prod.getCreatedAt());
            st.setTimestamp(10, prod.getUpdatedAt());
            st.setBoolean(11, prod.getIsActive());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Product prod, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, prod.getName());
            st.setString(2, prod.getDescription());
            st.setInt(3, prod.getInStock());
            st.setInt(4, prod.getMinStock());
            st.setFloat(5, prod.getPriceIn());
            st.setFloat(6, prod.getPriceOut());
            st.setInt(7, prod.getR_category());
            st.setTimestamp(8, prod.getCreatedAt());
            st.setTimestamp(9, prod.getUpdatedAt());
            st.setBoolean(10, prod.getIsActive());
            
            st.setString(11, id);

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
