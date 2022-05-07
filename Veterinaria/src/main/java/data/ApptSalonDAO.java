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
    public static final String insertSQL = "INSERT INTO appts_salon (r_user, r_owner, r_pet, address, date_appt, in_hour, r_sector, notes, r_service, out_hour, products) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE appts_salon SET r_user = ?, r_owner = ? r_pet = ?, address = ?, date_appt = ?, in_hour = ?, r_sector = ?, notes = ?, r_service = ?, out_hour = ? products = ? WHERE id_appt = ?";
    public static final String deleteSQL = "DELETE FROM appts_salon WHERE id_appt = ?";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");
    
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
                Date dateAppt = new Date(df.parse(rs.getString(3)).getTime());
                Time inHour = rs.getTime(6);
                String sector = rs.getString(7);
                char r_sector = sector.charAt(0);
                String note = rs.getString(8);
                
                int r_service = rs.getInt(9);
                Time outHour = rs.getTime(10);
                String products = rs.getString(11);
                
                apptS = new ApptSalon(id, r_user, r_owner, r_pet, addr, dateAppt, inHour, r_sector, note, r_service , outHour, products);

                lista.add(apptS);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void insert(ApptSalon apptS) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;
        
        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, apptS.getR_user());
            st.setString(2, apptS.getR_owner());
            st.setInt(3, apptS.getR_pet());
            st.setString(4, apptS.getAddr());
            st.setDate(5, apptS.getDateAppt());
            st.setTime(6, apptS.getInHour());
            st.setString(7, apptS.getR_sector() + "");
            st.setString(8, apptS.getNote());
            
            st.setInt(9, apptS.getR_service());
            st.setTime(10, apptS.getOutHour());
            st.setString(11, apptS.getProducts());
           
            st.executeUpdate();

            DBConnection.close(st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void update(ApptSalon apptS, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, apptS.getR_user());
            st.setString(2, apptS.getR_owner());
            st.setInt(3, apptS.getR_pet());
            st.setString(4, apptS.getAddr());
            st.setDate(5, apptS.getDateAppt());
            st.setTime(6, apptS.getInHour());
            st.setString(7, apptS.getR_sector() + "");
            st.setString(8, apptS.getNote());
            
            st.setInt(9, apptS.getR_service());
            st.setTime(10, apptS.getOutHour());
            st.setString(11, apptS.getProducts());
            
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