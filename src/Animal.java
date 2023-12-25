import java.util.Random;

public class Animal {
    private String nom;
    private String espece;
    private int age;
    private String genre;
    private boolean sante;


    public Animal(String nom, String espece, int age, String genre) {
        this.nom = nom;
        this.espece = espece;
        this.age = age;
        this.genre = genre;
        this.sante = true;

    }

    public String getNom(){
        return nom + ", de l'espèce : " + espece;
    }

    public String getNomSimple(){
        return  nom;
    }


    public void tombeMalade(){
        this.sante = false;
    }


    public boolean estOsculte() {
        // une chance sur 4 que la santé change
        Random random = new Random();
        int chance = random.nextInt(4);  // génère un nombre aléatoire entre 0 et 3
        if (chance == 0) {
            // La santé change
            this.tombeMalade();
        }
        return sante;
    }

    public void estSoigne() {

       this.sante = true;
    }

    @Override
    public String toString() {
        String etat = "Malade";
        if(sante == true) etat = "En forme";
        return "Animal{" +
                "nom='" + nom + '\'' +
                ", espece='" + espece + '\'' +
                ", age=" + age +
                ", genre='" + genre + '\'' +
                ", sante=" + etat +
                '}';
    }
}
