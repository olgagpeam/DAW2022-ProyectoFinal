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
    public static final String insertSQL = "INSERT INTO appts_hospital (r_user, r_owner, r_pet, address, date_appt, in_hour, r_sector, notes, illness, procedures, medicaments) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE appts_hospital SET r_user = ?, r_owner = ? r_pet = ?, address = ?, date_appt = ?, in_hour = ?, r_sector = ?, notes = ?, illness = ?, procedures = ? medicaments = ? WHERE id_appt = ?";
    public static final String deleteSQL = "DELETE FROM appts_hospital WHERE id_appt = ?";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    
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
                Date dateAppt = new Date(df.parse(rs.getString(3)).getTime());
                Time inHour = rs.getTime(6);
                String sector = rs.getString(7);
                char r_sector = sector.charAt(0);
                String note = rs.getString(8);
                
                String illness = rs.getString(9);
                String procedures = rs.getString(10);
                String med = rs.getString(11);
                
                apptH = new ApptHospital(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, illness , procedures, med);

                lista.add(apptH);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(ApptHospital apptH) throws ParseException {
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
            st.setString(11, apptH.getMedicaments());
           
            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(ApptHospital apptH, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

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
            st.setString(11, apptH.getMedicaments());
            
            st.setInt(12, id);

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