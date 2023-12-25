import java.util.ArrayList;
import java.util.List;

public class Soigneur implements Personne {
    private String nom;
    private List<Enclos> enclosSousResponsabilite;

    public Soigneur(String nom) {
        this.nom = nom;
        this.enclosSousResponsabilite = new ArrayList<>();
    }

    public void ajouterEnclosResponsabilite(Enclos enclos) {
        enclosSousResponsabilite.add(enclos);
    }

    public void retirerEnclosResponsabilite(Enclos enclos) {
        enclosSousResponsabilite.remove(enclos);
    }

    public String toString() {
        return "Soigneur: " + nom + " Enclos sous responsabilité: " + enclosSousResponsabilite.size();
    }


    public void soignerAnimal(Animal a){
        a.estSoigne();
        System.out.println(nom + " a soigné " + a.getNom() + "!");
    }

    public List<Enclos> getEnclosSousResponsabilite() {
        return enclosSousResponsabilite;
    }


    public Class<?> getTypeEnclos() {
        if (this instanceof SoigneurTerrestre) {
            return EnclosTerrestre.class;
        } else if (this instanceof SoigneurAquatique) {
            return EnclosAquatique.class;
        } else if (this instanceof SoigneurOiseau) {
            return EnclosVolieres.class;
        }
        return null;
    }

    @Override
    public String getNom() {
        return nom;
    }
}
