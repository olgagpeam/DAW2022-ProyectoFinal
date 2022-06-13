/*
 *  
 */
package data;

import model.ApptSalon;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ApptSalonDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM appts_salon";
    public static final String insertSQL = "INSERT INTO appts_salon (r_user, r_owner, r_pet, address, date_appt, in_hour, r_sector, notes, r_service, out_hour, products) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE appts_salon SET r_user = ?, address = ?, date_appt = ?, in_hour = ?, notes = ?, r_service = ?, out_hour = ?, products = ? WHERE id_appt = ?";
    public static final String deleteSQL = "DELETE FROM appts_salon WHERE id_appt = ?";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<ApptSalon> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ApptSalon apptS = null;

        ArrayList<ApptSalon> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String r_user = rs.getString(2);
                String r_owner = rs.getString(3);
                int r_pet = rs.getInt(4);
                String addr = rs.getString(5);
                Date dateAppt = null;
                if (rs.getString(6) != null) {
                    dateAppt = new Date(df.parse(rs.getString(6)).getTime());
                }
                Time inHour = rs.getTime(7);
                String sector = rs.getString(8);
                char r_sector = sector.charAt(0);
                String note = rs.getString(9);

                int r_service = rs.getInt(10);
                Time outHour = rs.getTime(11);
                String apptSucts = rs.getString(12);

                apptS = new ApptSalon(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_service, outHour, apptSucts);

                lista.add(apptS);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(ApptSalon apptS) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, apptS.getR_user());
            st.setString(2, apptS.getR_owner());
            st.setInt(3, apptS.getR_pet());
            st.setString(4, (apptS.getAddr().equals("")) ? null : apptS.getAddr());
            st.setDate(5, apptS.getDateAppt());
            st.setTime(6, apptS.getInHour());
            st.setString(7, apptS.getR_sector() + "");
            st.setString(8, (apptS.getNote().equals("")) ? null : apptS.getNote());

            st.setInt(9, apptS.getR_service());
            st.setTime(10, apptS.getOutHour());
            st.setString(11, apptS.getProducts());

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ApptSalon apptS, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, apptS.getR_user());
            //st.setString(2, apptS.getR_owner());
            //st.setInt(3, apptS.getR_pet());
            st.setString(2, (apptS.getAddr().equals("")) ? null : apptS.getAddr());
            st.setDate(3, apptS.getDateAppt());
            st.setTime(4, apptS.getInHour());
            //st.setString(7, apptS.getR_sector() + "");
            st.setString(5, (apptS.getNote().equals("")) ? null : apptS.getNote());

            st.setInt(6, apptS.getR_service());
            st.setTime(7, apptS.getOutHour());
            st.setString(8, (apptS.getProducts().equals("")) ? null : apptS.getProducts());

            st.setInt(9, id);

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public int delete(int id) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            ArrayList<ApptSalon> apptS = select();
            for (ApptSalon search : apptS) {
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
