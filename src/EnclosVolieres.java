public class EnclosVolieres extends Enclos {
    public EnclosVolieres(int capaciteMax) {
        super(capaciteMax, "Volieres");
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof Oiseau) {
            super.ajouterAnimal(animal);
        } else {
            System.out.println("Cette volière ne peut accueillir que des oiseaux.");
        }
    }
}
