package ma.enset.gestionbd.dao;


import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.entities.Joueur;

import java.util.List;

public interface JoueurDAO extends DAO<Joueur,Long> {
    List<Joueur> findAllByEquipe(Equipe equipe);
}
