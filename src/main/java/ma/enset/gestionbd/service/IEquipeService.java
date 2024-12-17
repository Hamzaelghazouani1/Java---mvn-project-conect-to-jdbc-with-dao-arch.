package ma.enset.gestionbd.service;

import ma.enset.gestionbd.entities.Equipe;

import java.util.List;

public interface IEquipeService {

    public List<Equipe> getAll();

    public Equipe getById(Long id);

    public void save(Equipe equipe);

    public void delete(Equipe equipe);

    public void update(Equipe equipe);
}
