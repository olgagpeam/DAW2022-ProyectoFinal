/*
 *  
 */
package data;

import model.Owner;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class OwnerDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM owners";
    public static final String insertSQL = "INSERT INTO owners (ine, name_ownr, bdate_ownr, addr_ownr, cel_ownr, tel_ownr, email_ownr) VALUES (?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE owners SET name_ownr = ?, bdate_ownr = ?, addr_ownr = ?, cel_ownr = ?, tel_ownr = ?, email_ownr = ? WHERE ine = ?";
    public static final String deleteSQL = "DELETE FROM owners WHERE ine = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<Owner> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Owner ownr = null;

        ArrayList<Owner> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                String ine = rs.getString(1);
                String name = rs.getString(2);
                Date bdate = null;
                if (rs.getString(3) != null) {
                    bdate = new Date(df.parse(rs.getString(3)).getTime());
                }
                String addr = rs.getString(4);
                String cel = rs.getString(5);
                String tel = rs.getString(6);
                String email = rs.getString(7);

                ownr = new Owner(ine, name, bdate, addr, cel, tel, email);

                lista.add(ownr);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(Owner ownr) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, (ownr.getIne().equals("")) ? null : ownr.getIne());
            st.setString(2, (ownr.getName().equals("")) ? null : ownr.getName());
            st.setDate(3, ownr.getBdate());
            st.setString(4, (ownr.getAddr().equals("")) ? null : ownr.getAddr());
            st.setString(5, (ownr.getCel().equals("")) ? null : ownr.getCel());
            st.setString(6, (ownr.getTel().equals("")) ? null : ownr.getTel());
            st.setString(7, (ownr.getEmail().equals("")) ? null : ownr.getEmail());

            st.executeUpdate();

            DBConnection.close(st, conn);

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(Owner ownr, String ine) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, (ownr.getName().equals("")) ? null : ownr.getName());
            st.setDate(2, ownr.getBdate());
            st.setString(3, (ownr.getAddr().equals("")) ? null : ownr.getAddr());
            st.setString(4, (ownr.getCel().equals("")) ? null : ownr.getCel());
            st.setString(5, (ownr.getTel().equals("")) ? null : ownr.getTel());
            st.setString(6, (ownr.getEmail().equals("")) ? null : ownr.getEmail());

            st.setString(7, ine);

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int delete(String ine) throws ParseException {
        //regresa 0 si se realizo la operacion con exito
        //regresa 1 si no se encuentra el id a eliminar
        //regresa 2 si es otro error
        Connection conn = null;
        PreparedStatement st = null;
        try {
            ArrayList<Owner> owner = select();
            for (Owner search : owner) {
                if (search.getIne().equals(ine)) {
                    conn = DBConnection.getConnection();
                    st = conn.prepareStatement(deleteSQL);
                    st.setString(1, ine);

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
