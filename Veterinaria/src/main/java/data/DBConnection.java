/*
 *  
 */
package data;

import java.sql.*;

/**
 *
 * @author Alarcon Olga
 */
public class DBConnection {

    private static String user = "postgres";
    private static String pswd = "123456";
    private static String bd = "VET";
    private static String server = "jdbc:postgresql://localhost:5432/";
    private static String driver = "org.postgresql.Driver";
    private static DBConnection conn = null;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(server + bd, user, pswd);
    }

    public static void close(ResultSet rs) throws SQLException {
        rs.close();
    }

    public static void close(Connection con) throws SQLException {
        con.close();
    }

    public static void close(PreparedStatement ps) throws SQLException {
        ps.close();
    }

    public static void close(ResultSet rs, Connection con) throws SQLException {
        rs.close();
        con.close();
    }
    
    public static void close(ResultSet rs, PreparedStatement ps) throws SQLException {
        rs.close();
        ps.close();
    }
    
    public static void close(PreparedStatement ps, Connection con) throws SQLException {
        ps.close();
        con.close();
    }
    
    public static void close(ResultSet rs, Statement st, Connection con) throws SQLException {
        rs.close();
        st.close();
        con.close();
    }
}
