package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() throws Exception {
        if (con == null || con.isClosed()) {
            
            Class.forName("com.mysql.cj.jdbc.Driver");

            
            String url = "jdbc:mysql://localhost:3306/beehouse"; 
            String user = "root";                                
            String password = "";                                

            con = DriverManager.getConnection(url, user, password);
        }
        return con;
    }
}
