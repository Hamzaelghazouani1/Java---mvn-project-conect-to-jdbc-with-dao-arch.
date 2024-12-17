package ma.enset.gestionbd;

import ma.enset.gestionbd._db.DatabaseInitializer;
import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.entities.Joueur;
import ma.enset.gestionbd.service.IEquipeService;
import ma.enset.gestionbd.service.IJourService;
import ma.enset.gestionbd.service.impl.EquipeService;
import ma.enset.gestionbd.service.impl.JoueurService;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {

        IEquipeService equipeService = new EquipeService();
        IJourService jourService = new JoueurService();
        List<Equipe> equipes =  equipeService.getAll();
        List<Joueur> joueurs = jourService.getAll();
        joueurs.forEach(System.out::println);
        equipes.forEach(System.out::println);


    }
}
