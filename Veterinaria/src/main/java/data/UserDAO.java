/*
 *  
 */
package data;

import model.User;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class UserDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM users";
    public static final String insertSQL = "INSERT INTO users (id_user, pwd, name_usr, bdate_usr, addr_usr, cel_usr, tel_usr, email_usr, r_acct) VALUES (?, ?, ROW(?, ?, ?), ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE users SET pwd = ?, name_usr = (?, ?, ?), bdate_usr = ?, addr_usr = ?, cel_usr = ?, tel_usr = ?, email_usr = ?, r_acct = ? WHERE id_user = ?";
    public static final String deleteSQL = "DELETE FROM users WHERE id_user = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<User> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        User usr = null;

        ArrayList<User> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String id = rs.getString(1);
                String pwd = rs.getString(2);
                String name = rs.getString(3);
                String lname2 = null;
                String lname1 = null;
                if (name != null) {
                    String name_full[] = name.split(",", 3);
                    name = name_full[0];
                    lname1 = name_full[1];
                    lname2 = name_full[2];
                }
                Date bdate = null;
                if (rs.getString(4) != null) {
                    bdate = new Date(df.parse(rs.getString(4)).getTime());
                }
                String addr = rs.getString(5);
                String tel = rs.getString(6);
                String cel = rs.getString(7);
                String email = rs.getString(8);
                String r_acct = rs.getString(9);

                usr = new User(id, pwd, name, lname1, lname2, bdate, addr, tel, cel, email, r_acct);

                lista.add(usr);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(User usr) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, usr.getId());
            st.setString(2, usr.getPwd());
            st.setString(3, usr.getName());
            st.setString(4, usr.getLname1());
            st.setString(5, usr.getLname2());
            st.setDate(6, usr.getBdate());
            st.setString(7, usr.getAddr());
            st.setString(8, usr.getTel());
            st.setString(9, usr.getCel());
            st.setString(10, usr.getEmail());
            st.setString(11, usr.getR_acct());

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(User usr, String id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, usr.getPwd());
            st.setString(2, usr.getName());
            st.setString(3, usr.getLname1());
            st.setString(4, usr.getLname2());
            st.setDate(5, usr.getBdate());
            st.setString(6, usr.getAddr());
            st.setString(7, usr.getTel());
            st.setString(8, usr.getCel());
            st.setString(9, usr.getEmail());
            st.setString(10, usr.getR_acct());

            st.setString(11, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int delete(String id) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            ArrayList<User> user = select();
            for (User search : user) {
                if (search.getId().equals(id)) {
                    conn = DBConnection.getConnection();
                    st = conn.prepareStatement(deleteSQL);
                    st.setString(1, id);

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
