public class DemoZoo {

    public static void main(String[] args) {
        Gestion zoo = new Gestion("Animal City");

        // Ajout d'animaux

        System.out.println("\n\n");
        zoo.accueillir(new AnimalTerrestre("Lion", "Félin", 5, "Mâle", 4));
        zoo.accueillir(new AnimalTerrestre("Lion", "Félin", 2, "Femelle", 4));
        zoo.accueillir(new AnimalTerrestre("Lion", "Félin", 4, "Mâle", 4));
        zoo.accueillir(new AnimalTerrestre("Lion", "Félin", 8, "Femelle", 4));
        zoo.accueillir(new AnimalTerrestre("Lion", "Félin", 11, "Mâle", 4));

        System.out.println("\n\n\n");

        zoo.accueillir(new AnimalTerrestre("Tigre", "Felidae", 3, "Mâle", 4));
        zoo.construireNouvelEnclos("terrestre");
        System.out.println("\n");

        zoo.accueillir(new AnimalTerrestre("Tigre", "Panthera tigris sumatrae", 3, "Femelle", 4));
        zoo.accueillir(new AnimalTerrestre("Tigre", "Felidae", 9, "Mâle", 4));
        zoo.accueillir(new AnimalTerrestre("Tigre", "Panthera tigris altaica", 3, "Femelle", 4));
        zoo.accueillir(new AnimalTerrestre("Tigre", "Felidae", 1, "Mâle", 4));
        zoo.accueillir(new AnimalTerrestre("Tigre", "Panthera tigris altaica", 2, "Mâle", 4));

        System.out.println("\n\n\n");



        zoo.accueillir(new AnimalAquatique("Requin", "Marteau", 2, "Femelle", "Océan"));
        zoo.accueillir(new AnimalAquatique("Requin", "Selachimorpha", 8, "Mâle", "Océan"));
        zoo.accueillir(new AnimalAquatique("Requin", "Baleine", 5, "Femelle", "Océan"));

        System.out.println("\n\n\n");

        zoo.accueillir(new AnimalAquatique("Dauphin", "Delphinidae", 5, "Mâle", "Mere/océan"));
        zoo.construireNouvelEnclos("aquatique");
        System.out.println("\n");

        zoo.accueillir(new AnimalAquatique("Dauphin", "Delphinidae", 5, "Mâle", "Mere/océan"));
        zoo.accueillir(new AnimalAquatique("Dauphin", "Tursiops truncatus", 3, "Mâle", "Mere/océan"));
        zoo.accueillir(new AnimalAquatique("Dauphin", "Lagenorhynchus acutus",5,"Femelle", "Mere/océan"));
        zoo.accueillir(new AnimalAquatique("Dauphin", "Delphinidae", 2, "Mâle", "Mere/océan"));
        zoo.accueillir(new AnimalAquatique("Dauphin", "Tursiops truncatus", 3, "Mâle", "Mere/océan"));
        zoo.accueillir(new AnimalAquatique("Dauphin", "Tursiops truncatus", 2, "Femelle", "Mere/océan"));


        System.out.println("\n\n\n");


        zoo.accueillir(new Oiseau("Aigle", "Accipitridae", 1, "Femelle", "Crochu"));
        zoo.accueillir(new Oiseau("Aigle", "Accipitridae", 5, "Mâle", "Crochu"));
        zoo.accueillir(new Oiseau("Aigle", "Aquila chrysaetos", 3, "Femelle", "Crochu"));
        zoo.accueillir(new Oiseau("Aigle", "Pandion haliaetus", 7, "Mâle", "Crochu"));
        zoo.accueillir(new Oiseau("Aigle", "Pandion haliaetus", 2, "Mâle", "Crochu"));


        System.out.println("\n\n\n");

        zoo.accueillir(new Oiseau("Perroquet", "Psittacidae", 2, "Femelle", "Crochu"));

        zoo.construireNouvelEnclos("oiseau");
        System.out.println("\n");

        zoo.accueillir(new Oiseau("Perroquet", "Ara macao", 2, "Femelle", "Crochu"));
        zoo.accueillir(new Oiseau("Perroquet", "Psittacidae", 4, "Femelle", "Crochu"));
        zoo.accueillir(new Oiseau("Perroquet", "Ara macao", 3, "Mâle", "Crochu"));
        zoo.accueillir(new Oiseau("Perroquet", "Cacatua alba", 1, "Femelle", "Crochu"));
        zoo.accueillir(new Oiseau("Perroquet", "Ara macao", 7, "Mâle", "Crochu"));
        zoo.accueillir(new Oiseau("Perroquet", "Ara macao", 1, "Mâle", "Crochu"));



        System.out.println("\n\n\n");

        // Recrutement de soigneurs
        SoigneurTerrestre soigneurTerrestre = new SoigneurTerrestre("Jean");
        SoigneurAquatique soigneurAquatique = new SoigneurAquatique("Marie");
        SoigneurOiseau soigneurOiseau = new SoigneurOiseau("Pierre");

        zoo.recruter(soigneurTerrestre);
        zoo.recruter(soigneurAquatique);
        zoo.recruter(soigneurOiseau);

        // Affichage des informations sur les soigneurs et les animaux
        System.out.println("\nInformations sur les soigneurs :");
        for (Soigneur soigneur : zoo.soigneurs) {
            System.out.println(soigneur);
        }

        System.out.println("\nInformations sur les animaux :");
        for (Animal animal : zoo.animaux) {
            System.out.println(animal);
        }

        // Tournée des soigneurs
        System.out.println("\nTournée des soigneurs :");
        zoo.tournee();
    }
    }