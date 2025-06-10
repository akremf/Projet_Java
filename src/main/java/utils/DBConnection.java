// --- Fichier Java : DBConnection.java ---
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static Connection con;

    public static Connection getConnection() throws Exception {
        if (con == null || con.isClosed()) {
            // Charger le driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Établir la connexion (adapter les paramètres si besoin)
            String url = "jdbc:mysql://localhost:3306/beehouse"; // nom de la base = beehouse
            String user = "root";                                // utilisateur MySQL
            String password = "";                                // mot de passe MySQL

            con = DriverManager.getConnection(url, user, password);
        }
        return con;
    }
}
