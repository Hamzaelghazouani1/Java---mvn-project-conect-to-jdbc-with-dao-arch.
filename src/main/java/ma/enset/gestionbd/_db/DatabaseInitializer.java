package ma.enset.gestionbd._db;


import ma.enset.gestionbd.dao.SignaletonConnexion;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            Statement stmt = connection.createStatement();

            // Drop tables if they already exist
            stmt.execute("DROP TABLE IF EXISTS joueur");
            stmt.execute("DROP TABLE IF EXISTS equipe");

            // Create the "equipe" table
            String createEquipeTable = """
                CREATE TABLE equipe (
                    id BIGINT PRIMARY KEY,
                    nom VARCHAR(50),
                    ville VARCHAR(50)
                )
            """;
            stmt.execute(createEquipeTable);

            // Create the "joueur" table with a foreign key to "equipe"
            String createJoueurTable = """
                CREATE TABLE joueur (
                    id BIGINT PRIMARY KEY,
                    nom VARCHAR(50),
                    pos VARCHAR(50),
                    numero INT,
                    equipe_id BIGINT,
                    FOREIGN KEY (equipe_id) REFERENCES equipe(id)
                )
            """;
            stmt.execute(createJoueurTable);

            // Insert seed data for "equipe"
            stmt.execute("INSERT INTO equipe (id, nom, ville) VALUES (1, 'Team A', 'City A')");
            stmt.execute("INSERT INTO equipe (id, nom, ville) VALUES (2, 'Team B', 'City B')");

            // Insert seed data for "joueur"
            stmt.execute("INSERT INTO joueur (id, nom, pos, numero, equipe_id) VALUES (1, 'Player 1', 'Forward', 10, 1)");
            stmt.execute("INSERT INTO joueur (id, nom, pos, numero, equipe_id) VALUES (2, 'Player 2', 'Defender', 5, 1)");
            stmt.execute("INSERT INTO joueur (id, nom, pos, numero, equipe_id) VALUES (3, 'Player 3', 'Midfielder', 8, 2)");

            System.out.println("Database initialized successfully with seed data.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
