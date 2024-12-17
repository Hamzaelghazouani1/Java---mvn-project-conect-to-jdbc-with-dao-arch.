package ma.enset.gestionbd.service;

import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.entities.Joueur;

import java.util.List;

public interface IJourService {

    public List<Joueur> getAll();

    public Joueur getById(Long id);

    public void save(Joueur joueur);

    public void delete(Joueur joueur);

    public void update(Joueur joueur);

    public List<Joueur> findAllByEquipe(Equipe equipe);
}
