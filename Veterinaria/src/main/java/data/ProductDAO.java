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
    public static final String updateSQL = "UPDATE products SET name_prod = ?, description = ?, in_stock = ?, min_stock = ?, price_in = ?, price_out = ?, r_category = ?, updated_at = ?, is_active = ? WHERE id_product = ?";
    public static final String deleteSQL = "DELETE FROM products WHERE id_product = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public String[] selectOnly(String id_search) throws ParseException {
        String[] result = {"", "", "", "", "", "", "", "", "", ""};
        ArrayList<Product> pro = new ArrayList<>();
        pro = select();
        for (Product rs : pro) {
            if (rs.getId().equals(id_search)) {
                result[0] = id_search;
                result[1] = rs.getName();
                result[2] = rs.getDescription();
                result[3] = String.valueOf(rs.getInStock());
                result[4] = String.valueOf(rs.getMinStock());
                result[5] = String.valueOf(rs.getPriceIn());
                result[6] = String.valueOf(rs.getPriceOut());
                result[7] = String.valueOf(rs.getR_category());
                result[8] = ((rs.getIsActive()) ? "si" : "no");
                return result;
            } else {
                result[0] = "404NotFound";
                return result;
            }
        }
        return result;
    }

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
                float priceIn = rs.getInt(6);
                float priceOut = rs.getInt(7);
                int r_category = rs.getInt(8);
                Timestamp createdAt = rs.getTimestamp(9);
                Timestamp updatedAt = rs.getTimestamp(10);
                boolean isActive = rs.getBoolean(11);

                prod = new Product(id, name, description, inStock, minStock, priceIn, priceOut, r_category, createdAt, updatedAt, isActive);

                lista.add(prod);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(Product prod) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, (prod.getId().equals("")) ? null : prod.getId());
            st.setString(2, (prod.getName().equals("")) ? null : prod.getName());
            st.setString(3, (prod.getDescription().equals("")) ? null : prod.getDescription());
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
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Product prod, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, (prod.getName().equals("")) ? null : prod.getName());
            st.setString(2, (prod.getDescription().equals("")) ? null : prod.getDescription());
            st.setInt(3, prod.getInStock());
            st.setInt(4, prod.getMinStock());
            st.setFloat(5, prod.getPriceIn());
            st.setFloat(6, prod.getPriceOut());
            st.setInt(7, prod.getR_category());
            st.setTimestamp(8, prod.getUpdatedAt());
            st.setBoolean(9, prod.getIsActive());

            st.setString(10, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int delete(String id) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            ArrayList<Product> prod = select();
            for (Product search : prod) {
                if (search.getId().equals(id)) {
                    conn = DBConnection.getConnection();
                    st = conn.prepareStatement(deleteSQL);
                    st.setString(1, id);

                    st.executeUpdate();

                    DBConnection.close(st, conn);
                    return 0;
                } else {
                    return 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 2;
    }
}
