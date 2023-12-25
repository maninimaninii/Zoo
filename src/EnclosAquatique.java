public class EnclosAquatique extends Enclos {
    public EnclosAquatique(int capaciteMax) {
        super(capaciteMax, "Aquarium");
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof AnimalAquatique) {
            super.ajouterAnimal(animal);
        } else {
            System.out.println("Cet aquarium ne peut accueillir que des animaux aquatiques.");
        }
    }
}
