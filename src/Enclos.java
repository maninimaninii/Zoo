import java.util.ArrayList;
import java.util.List;

public class Enclos {
    private List<Animal> animaux;
    private int capaciteMax;
    private String typeEnvironnement;

    public Enclos(int capaciteMax, String typeEnvironnement) {
        this.animaux = new ArrayList<>();
        this.capaciteMax = capaciteMax;
        this.typeEnvironnement = typeEnvironnement;
    }

    public void ajouterAnimal(Animal animal) {
        if (animaux.size() < capaciteMax) {
            animaux.add(animal);
        } else {
            System.out.println("L'enclos est plein, impossible d'ajouter un nouvel animal.");
        }
    }

    public void retirerAnimal(Animal animal) {
        animaux.remove(animal);
    }

    public void afficherAnimaux() {
        for (Animal animal : animaux) {
            System.out.println(animal);
        }
    }

    public List<Animal> getAnimaux(){
        return animaux;
    }

    public boolean estPlein(){ //verifier si l'enclos est déja plein
        return capaciteMax <= animaux.size();
    }
    public boolean estVide(){ //verifier si l'enclos est déja plein
        return animaux.isEmpty();
    }

    public boolean contientAnimauxDuMemeNom(Animal animal) {
        for (Animal a : animaux) {
            if (a.getNomSimple().equals(animal.getNomSimple())) {
                return true;
            }
        }
        return false;
    }

    public void afficherStatistiques() {
        System.out.println("Capacité maximale: " + capaciteMax);
        System.out.println("Type d'environnement: " + typeEnvironnement);
        // Ajoutez d'autres statistiques spécifiques à l'enclos si nécessaire
    }
}
