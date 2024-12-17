package ma.enset.gestionbd.dao.Impl;



import ma.enset.gestionbd.dao.EquipeDAO;
import ma.enset.gestionbd.dao.SignaletonConnexion;
import ma.enset.gestionbd.entities.Equipe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EquipeDAOImpl implements EquipeDAO {
    @Override
    public void save(Equipe equipe) {
        Connection connection = null;
        try {
            connection = SignaletonConnexion.getConnection();
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO equipe (nom,ville) VALUES (?,?)");
            pstm.setString(1, equipe.getNom());
            pstm.setString(2, equipe.getVille());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Equipe findById(Long id) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM equipe WHERE id = ?");
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                return new Equipe(rs.getLong("id"), rs.getString("nom"), rs.getString("ville"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Equipe> findAll() {
        List<Equipe> equipes = new ArrayList<>();
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM equipe");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                equipes.add(new Equipe(rs.getLong("id"), rs.getString("nom"), rs.getString("ville")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return equipes;
    }

    @Override
    public void update(Equipe equipe) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("UPDATE equipe SET nom = ?, ville = ? WHERE id = ?");
            pstm.setString(1, equipe.getNom());
            pstm.setString(2, equipe.getVille());
            pstm.setLong(3, equipe.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM equipe WHERE id = ?");
            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}