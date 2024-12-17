package ma.enset.gestionbd.service.impl;



import ma.enset.gestionbd.dao.EquipeDAO;
import ma.enset.gestionbd.dao.Impl.EquipeDAOImpl;
import ma.enset.gestionbd.dao.Impl.JoueurDAOImpl;
import ma.enset.gestionbd.dao.JoueurDAO;
import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.entities.Joueur;
import ma.enset.gestionbd.service.IJourService;

import java.util.ArrayList;
import java.util.List;

public class JoueurService implements IJourService {
    private final JoueurDAO joueurDAO;
    private final EquipeDAO equipeDAO;

    public JoueurService() {
        this.joueurDAO = new JoueurDAOImpl();
        this.equipeDAO = new EquipeDAOImpl();
    }

    @Override
    public List<Joueur> getAll() {
        List<Joueur> joueurs = new ArrayList<Joueur>();
        joueurs = joueurDAO.findAll();
        joueurs.forEach(joueur -> {
            if (joueur.getEquipe() != null)
                joueur.setEquipe(equipeDAO.findById(joueur.getEquipe().getId()));
        });
        return joueurs;
    }

    @Override
    public Joueur getById(Long id) {
        return (Joueur) joueurDAO.findById(id);
    }

    @Override
    public void save(Joueur joueur) {
        joueurDAO.save(joueur);
    }

    @Override
    public void delete(Joueur joueur) {
        joueurDAO.deleteById(joueur.getId());
    }

    @Override
    public void update(Joueur joueur) {
        joueurDAO.update(joueur);
    }

    @Override
    public List<Joueur> findAllByEquipe(Equipe equipe) {
        return joueurDAO.findAllByEquipe(equipe);
    }
}
