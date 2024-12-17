package ma.enset.gestionbd.entities;

import java.io.Serializable;
import java.util.List;

public class Equipe implements Serializable {
    private Long id;
    private String nom;
    private String ville;
    private List<Joueur> joueurs;

    public Equipe() {}

    public Equipe(Long id) {
        this.id = id;
    }

    public Equipe(Long id, String nom, String ville) {
        this.id = id;
        this.nom = nom;
        this.ville = ville;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getVille() { return ville; }
    public void setVille(String ville) { this.ville = ville; }

    public List<Joueur> getJoueurs() { return joueurs; }
    public void setJoueurs(List<Joueur> joueurs) { this.joueurs = joueurs; }

    @Override
    public String toString() {
        return "Equipe{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", ville='" + ville + '\'' +
                '}';
    }
}