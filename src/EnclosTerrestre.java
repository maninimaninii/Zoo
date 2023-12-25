public class EnclosTerrestre extends Enclos {
    public EnclosTerrestre(int capaciteMax) {
        super(capaciteMax, "Terrestre");
    }

    @Override
    public void ajouterAnimal(Animal animal) {
        if (animal instanceof AnimalTerrestre) {
            super.ajouterAnimal(animal);
        } else {
            System.out.println("Cet enclos terrestre ne peut accueillir que des animaux terrestres.");
        }
    }
}
