/*
 *  
 */
package data;

import model.ApptConsult;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ApptConsultDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM appts_consult";
    public static final String insertSQL = "INSERT INTO appts_consult (r_user, r_owner, r_pet, address, date_appt, in_hour, r_sector, notes, r_consult, addr_ref, diagnosis, procedures, medicaments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE appts_consult SET r_user = ?, address = ?, date_appt = ?, in_hour = ?, notes = ?, r_consult = ?, addr_ref = ?, diagnosis = ?, procedures = ?, medicaments = ? WHERE id_appt = ?";
    public static final String deleteSQL = "DELETE FROM appts_consult WHERE id_appt = ?";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<ApptConsult> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ApptConsult apptC = null;

        ArrayList<ApptConsult> lista = new ArrayList<>();
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
                Date dateAppt = new Date(df.parse(rs.getString(6)).getTime());
                Time inHour = rs.getTime(7);
                String sector = rs.getString(8);
                char r_sector = sector.charAt(0);
                String note = rs.getString(9);

                String r_consult = rs.getString(10);
                String addrRef = rs.getString(11);
                String diagnosis = rs.getString(12);
                String procedures = rs.getString(13);
                String med = rs.getString(14);

                apptC = new ApptConsult(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_consult, addrRef, diagnosis, procedures, med);

                lista.add(apptC);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(ApptConsult apptC) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, apptC.getR_user());
            st.setString(2, apptC.getR_owner());
            st.setInt(3, apptC.getR_pet());
            st.setString(4, apptC.getAddr());
            st.setDate(5, apptC.getDateAppt());
            st.setTime(6, apptC.getInHour());
            st.setString(7, apptC.getR_sector() + "");
            st.setString(8, apptC.getNote());

            st.setString(9, apptC.getR_consult());
            st.setString(10, apptC.getAddrRef());
            st.setString(11, apptC.getDiagnosis());
            st.setString(12, apptC.getProcedures());
            st.setString(13, apptC.getMed());

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ApptConsult apptC, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, apptC.getR_user());
            //st.setString(2, apptC.getR_owner());
            //st.setInt(3, apptC.getR_pet());
            st.setString(2, apptC.getAddr());
            st.setDate(3, apptC.getDateAppt());
            st.setTime(4, apptC.getInHour());
            //st.setString(7, apptC.getR_sector() + "");
            st.setString(5, apptC.getNote());

            st.setString(6, apptC.getR_consult());
            st.setString(7, apptC.getAddrRef());
            st.setString(8, apptC.getDiagnosis());
            st.setString(9, apptC.getProcedures());
            st.setString(10, apptC.getMed());

            st.setInt(11, id);

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
            ArrayList<ApptConsult> apptC = select();
            for (ApptConsult search : apptC) {
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
