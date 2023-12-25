public class Oiseau extends Animal {
    private String typeBec;

    public Oiseau(String nom, String espece, int age, String genre, String typeBec) {
        super(nom, espece, age, genre);
        this.typeBec = typeBec;
    }

    // Ajoutez des méthodes spécifiques pour les oiseaux si nécessaire
}
