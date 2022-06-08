/*
 *  
 */
package data;

import model.Pet;

import java.sql.*;
import java.text.*;
import java.util.ArrayList;

/**
 *
 * @author Alarcon Olga
 */
public class PetDAO {
//  select    insert    update      delete

    public static final String selectSQL = "SELECT * FROM pets";
    public static final String insertSQL = "INSERT INTO pets (name_pet, bdate_pet, specie, race, r_sex, color, r_ownr, other_notes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    public static final String updateSQL = "UPDATE pets SET name_pet = ?, bdatpet = ?, specie = ?, race = ?, r_sex = ?, color = ?, r_ownr = ?, other_notes = ? WHERE id_pet = ?";
    public static final String deleteSQL = "DELETE FROM pets WHERE id_pet = ? ";
    SimpleDateFormat df = new SimpleDateFormat("yyyy-mm-dd");

    public ArrayList<Pet> select() throws ParseException {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        Pet pet = null;

        ArrayList<Pet> lista = new ArrayList<>();
        try {
            conn = DBConnection.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(selectSQL);

            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                Date bdate = null;
                if (rs.getString(3) != null) {
                    bdate = new Date(df.parse(rs.getString(3)).getTime());
                }
                String specie = rs.getString(4);
                String race = rs.getString(5);
                String sex = rs.getString(6);
                char r_sex = sex.charAt(0);
                String color = rs.getString(7);
                String r_ownr = rs.getString(8);
                String other_notes = rs.getString(9);

                pet = new Pet(id, name, bdate, specie, race, r_sex, color, r_ownr, other_notes);

                lista.add(pet);
            }
            DBConnection.close(rs, st, conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean insert(Pet pet) throws ParseException {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(insertSQL);
            st.setString(1, (pet.getName().equals("")) ? null : pet.getName());
            st.setDate(2, pet.getBdate());
            st.setString(3, (pet.getSpecie().equals("")) ? null : pet.getSpecie());
            st.setString(4, (pet.getRace().equals("")) ? null : pet.getRace());
            String sex = pet.getR_sex() + "";
            st.setString(5, (sex.equals("")) ? null : sex);
            st.setString(6, (pet.getColor().equals("")) ? null : pet.getColor());
            st.setString(7, (pet.getR_owner().equals("")) ? null : pet.getR_owner());
            st.setString(8, (pet.getOther().equals("")) ? null : pet.getOther());

            st.executeUpdate();

            DBConnection.close(st, conn);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean update(Pet pet, int id) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DBConnection.getConnection();
            st = conn.prepareStatement(updateSQL);

            st.setString(1, (pet.getName().equals("")) ? null : pet.getName());
            st.setDate(2, pet.getBdate());
            st.setString(3, (pet.getSpecie().equals("")) ? null : pet.getSpecie());
            st.setString(4, (pet.getRace().equals("")) ? null : pet.getRace());
            String sex = pet.getR_sex() + "";
            st.setString(5, (sex.equals("")) ? null : sex);
            st.setString(6, (pet.getColor().equals("")) ? null : pet.getColor());
            st.setString(7, (pet.getR_owner().equals("")) ? null : pet.getR_owner());
            st.setString(8, (pet.getOther().equals("")) ? null : pet.getOther());

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
            ArrayList<Pet> pet = select();
            for (Pet search : pet) {
                if (search.getId() == id) {
                    conn = DBConnection.getConnection();
                    st = conn.prepareStatement(deleteSQL);
                    st.setInt(1, id);

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
