/*
 *  
 */
package data;

import model.ApptHospital;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class ApptHospitalDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM appts_hospital";
    public static final String insertSQL = "INSERT INTO appts_hospital (r_user, r_owner, r_pet, address, date_appt, in_hour, r_sector, notes, illness, procedures, medicaments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE appts_hospital SET r_user = ?, address = ?, date_appt = ?, in_hour = ?, notes = ?, illness = ?, procedures = ?, medicaments = ? WHERE id_appt = ?";
    public static final String deleteSQL = "DELETE FROM appts_hospital WHERE id_appt = ?";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<ApptHospital> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        ApptHospital apptH = null;

        ArrayList<ApptHospital> lista = new ArrayList<>();
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

                String illness = rs.getString(10);
                String procedures = rs.getString(11);
                String med = rs.getString(12);

                apptH = new ApptHospital(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, illness, procedures, med);

                lista.add(apptH);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(ApptHospital apptH) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, apptH.getR_user());
            st.setString(2, apptH.getR_owner());
            st.setInt(3, apptH.getR_pet());
            st.setString(4, apptH.getAddr());
            st.setDate(5, apptH.getDateAppt());
            st.setTime(6, apptH.getInHour());
            st.setString(7, apptH.getR_sector() + "");
            st.setString(8, apptH.getNote());

            st.setString(9, apptH.getIllness());
            st.setString(10, apptH.getProcedures());
            st.setString(11, apptH.getMed());

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(ApptHospital apptH, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, apptH.getR_user());
            //st.setString(2, apptH.getR_owner());
            //st.setInt(3, apptH.getR_pet());
            st.setString(2, apptH.getAddr());
            st.setDate(3, apptH.getDateAppt());
            st.setTime(4, apptH.getInHour());
            //st.setString(7, apptH.getR_sector() + "");
            st.setString(5, apptH.getNote());

            st.setString(6, apptH.getIllness());
            st.setString(7, apptH.getProcedures());
            st.setString(8, apptH.getMed());

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
            ArrayList<ApptHospital> apptH = select();
            for (ApptHospital search : apptH) {
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
