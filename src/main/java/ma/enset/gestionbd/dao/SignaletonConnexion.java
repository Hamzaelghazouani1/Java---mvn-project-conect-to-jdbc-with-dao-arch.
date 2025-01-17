package ma.enset.gestionbd.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SignaletonConnexion {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_equipe";
    private static final String USER = "root";
    private static final String PASSWORD = "password";

    private static Connection connection;

    public SignaletonConnexion() {} // Private constructor to prevent instantiation

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        return connection;
    }
}
