/*
 *  
 */

package data;

import model.Account;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class AccountDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM account";
    public static final String insertSQL = "INSERT INTO account (id_acct, type_acct) VALUES (?, ?)";
    public static final String updateSQL = "UPDATE account SET type_acct = ? WHERE id_acct = ?";
    public static final String deleteSQL = "DELETE FROM account WHERE id_acct = ? ";
    
    public ArrayList<Account> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Account acct = null;
         
        ArrayList<Account> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String id = rs.getString(1);
                String type_acct = rs.getString(2);

                acct = new Account(id, type_acct);

                lista.add(acct);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(Account acct) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, acct.getId());
            st.setString(2, acct.getTypeAcct());

            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(Account acct, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, acct.getTypeAcct());
            
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
