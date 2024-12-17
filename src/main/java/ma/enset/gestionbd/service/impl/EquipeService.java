package ma.enset.gestionbd.service.impl;


import ma.enset.gestionbd.dao.EquipeDAO;
import ma.enset.gestionbd.dao.Impl.EquipeDAOImpl;
import ma.enset.gestionbd.dao.Impl.JoueurDAOImpl;
import ma.enset.gestionbd.dao.JoueurDAO;
import ma.enset.gestionbd.entities.Equipe;
import ma.enset.gestionbd.service.IEquipeService;

import java.util.List;

public class EquipeService implements IEquipeService {
    private EquipeDAO equipeDAO;
    private JoueurDAO joueurDAO;

    public EquipeService() {
        this.equipeDAO = new EquipeDAOImpl();
        this.joueurDAO = new JoueurDAOImpl();
    }

    @Override
    public List<Equipe> getAll() {

        List<Equipe> equipes =  equipeDAO.findAll();
        equipes.forEach(equipe -> {
            equipe.setJoueurs(joueurDAO.findAllByEquipe(equipe));
        });
        return equipes;
    }

    @Override
    public Equipe getById(Long id) {
        return equipeDAO.findById(id);
    }

    @Override
    public void save(Equipe equipe) {
        equipeDAO.save(equipe);
    }

    @Override
    public void delete(Equipe equipe) {
        equipeDAO.deleteById(equipe.getId());
    }

    @Override
    public void update(Equipe equipe) {
        equipeDAO.update(equipe);
    }

}
