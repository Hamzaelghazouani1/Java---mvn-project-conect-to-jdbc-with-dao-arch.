package ma.enset.gestionbd.entities;

import java.io.Serializable;

public class Joueur implements Serializable {
    private Long id;
    private String nom;
    private String pos;
    private int numero;
    private Equipe equipe;

    public Joueur() {}

    public Joueur(Long id, String nom, String pos, int numero,Equipe equipe) {
        this.id = id;
        this.nom = nom;
        this.pos = pos;
        this.numero = numero;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPos() { return pos; }
    public void setPos(String pos) { this.pos = pos; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public Equipe getEquipe() { return equipe; }

    public void setEquipe(Equipe equipe) { this.equipe = equipe; }

    @Override
    public String toString() {
        return "Joueur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pos='" + pos + '\'' +
                ", numero=" + numero +
                ", equipe=" + (equipe != null ? equipe.getNom() : "null") +
                '}';
    }
}