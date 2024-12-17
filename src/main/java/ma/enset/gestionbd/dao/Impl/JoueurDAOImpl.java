package ma.enset.gestionbd.dao.Impl;


import ma.enset.gestionbd.dao.JoueurDAO;
import ma.enset.gestionbd.dao.SignaletonConnexion;
import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.entities.Joueur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurDAOImpl implements JoueurDAO {

    @Override
    public void save(Joueur joueur) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO joueur (nom, pos, numero, equipe_id) VALUES (?, ?, ?, ?)");
            pstm.setString(1, joueur.getNom());
            pstm.setString(2, joueur.getPos());
            pstm.setInt(3, joueur.getNumero());
            pstm.setLong(4, joueur.getEquipe().getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Joueur findById(Long id) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM joueur WHERE id = ?");
            pstm.setLong(1, id);
            ResultSet rs = pstm.executeQuery();

            if (rs.next()) {
                return new Joueur(rs.getLong("id"),rs.getString("nom"),rs.getString("pos"),rs.getInt("numero"),new Equipe(rs.getLong("equipe_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Joueur> findAll() {
        List<Joueur> joueurs = new ArrayList<>();
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM joueur");
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                joueurs.add(new Joueur(rs.getLong("id"), rs.getString("nom"), rs.getString("pos"), rs.getInt("numero"),new Equipe(rs.getLong("equipe_id"))));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return joueurs;
    }

    @Override
    public void update(Joueur joueur) {
        try (Connection connection = SignaletonConnexion.getConnection()) {
            PreparedStatement pstm = connection.prepareStatement("UPDATE joueur SET nom = ?, pos = ?, numero = ?, equipe_id = ? WHERE id = ?");
            pstm.setString(1, joueur.getNom());
            pstm.setString(2, joueur.getPos());
            pstm.setInt(3, joueur.getNumero());
            pstm.setLong(4, joueur.getEquipe().getId());
            pstm.setLong(5, joueur.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean deleteById(Long id) {
        try {
            Connection connection = SignaletonConnexion.getConnection();
            PreparedStatement pstm = connection.prepareStatement("DELETE FROM joueur WHERE id = ?");
            pstm.setLong(1, id);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Joueur> findAllByEquipe(Equipe equipe) {
        try{
            Connection connection = SignaletonConnexion.getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM joueur WHERE equipe_id = ?");
            pstm.setLong(1, equipe.getId());
            ResultSet rs = pstm.executeQuery();
            List<Joueur> joueurs = new ArrayList<>();
            while (rs.next()) {
                joueurs.add(new Joueur(rs.getLong("id"), rs.getString("nom"), rs.getString("pos"), rs.getInt("numero"),new Equipe(rs.getLong("equipe_id"))));
            }
            return joueurs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
