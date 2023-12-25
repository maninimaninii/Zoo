import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Gestion {

    public String nom;
    public ArrayList<Soigneur> soigneurs;
    public ArrayList<Enclos> enclos;
    public ArrayList<Animal> animaux;

    public Gestion(String nom) {
        this.nom = nom;
        enclos = new ArrayList<>();
        soigneurs = new ArrayList<>();
        animaux = new ArrayList<>();
        enclos.add(new EnclosTerrestre(10));
        enclos.add(new EnclosAquatique(10));
        enclos.add(new EnclosVolieres(10));
    }

    public void recruter(Soigneur nouveauSoigneur) {
        // Vérifier si un soigneur du même type existe déjà
        for (Soigneur ancienSoigneur : soigneurs) {
            if (ancienSoigneur.getClass() == nouveauSoigneur.getClass()) {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Un soigneur du même type d'animaux existe déjà. Voulez-vous le remplacer ? (Oui/Non)");
                String reponse = scanner.nextLine();
                if (reponse.equalsIgnoreCase("Oui")) {
                    // Retirer l'ancien soigneur
                    soigneurs.remove(ancienSoigneur);
                    System.out.println("L'ancien soigneur a été remplacé.");

                    // Transférer les enclos de l'ancien soigneur au nouveau soigneur

                    for(Enclos enclo : ancienSoigneur.getEnclosSousResponsabilite()){
                    nouveauSoigneur.ajouterEnclosResponsabilite(enclo);}
                    return;
                } else {
                    System.out.println("Recrutement annulé.");
                    return;
                }
            }
        }

        // Aucun soigneur du même type n'a été trouvé
        soigneurs.add(nouveauSoigneur);

        // Attribuer tous les enclos du même type au nouveau soigneur
        for (Enclos enclo : enclos) {
            if (enclo.getClass() == nouveauSoigneur.getTypeEnclos()) {
                nouveauSoigneur.ajouterEnclosResponsabilite(enclo);
            }
        }


        System.out.println(nouveauSoigneur.getNom() + " est le nouveau soigneur de l'équipe!");
        System.out.println("Il/elle est responsable des enclos de type " + nouveauSoigneur.getTypeEnclos().getSimpleName().substring(6) + ".\n");    }

    public void accueillir(Animal a) {
        Enclos enclosApproprie = trouverEnclosApproprie(a);
        if (enclosApproprie != null) {
            enclosApproprie.ajouterAnimal(a);
        }
    }

    private Enclos trouverEnclosApproprie(Animal a) {
        if (a instanceof AnimalTerrestre) {
            return trouverEnclosDisponible(EnclosTerrestre.class, a);
        } else if (a instanceof AnimalAquatique) {
            return trouverEnclosDisponible(EnclosAquatique.class, a);
        } else if (a instanceof Oiseau) {
            return trouverEnclosDisponible(EnclosVolieres.class, a);
        }
        return null; // Aucun enclos approprié trouvé
    }

    // Méthode utilitaire pour trouver un enclos disponible du type spécifié
    private <T extends Enclos> T trouverEnclosDisponible(Class<T> typeEnclos, Animal a) {
        for (Enclos enclo : enclos) {
            // On cherche un enclos contenant les memes animaux et pas plein
            if (typeEnclos.isInstance(enclo) && (!enclo.estPlein() && enclo.contientAnimauxDuMemeNom(a))) {
                System.out.println("Un " + a.getNom() + " débarque dans " + nom + " dans l'enclos des " + a.getNomSimple() + "s"  );
                return typeEnclos.cast(enclo);
            }
        }


        for (Enclos enclo : enclos) {

            //si la premiere recherche n'a rien donné, on cherche cette fois un enclos vide pour y installer l'animal pour la premiere fois
            if(typeEnclos.isInstance(enclo) && enclo.estVide()){
                //enclo est du bon type et vide
                System.out.println("Le " + a.getNom() + " inogure notre nouvel enclos de " + a.getNomSimple() + "s");
                return typeEnclos.cast(enclo);
                }
            }
        //si aucune des deux recherches n'a rien donné
        System.out.println("Aucun enclos approprié disponible pour accueillir des " + a.getNomSimple() + "s, il faudrait songer à ajouter un nouvel enclos!");

        return null;  // Aucun enclos disponible
    }



    public void tournee() {
        for (Class<?> typeEnclos : obtenirTypesEnclos()) {
            Soigneur soigneurDuType = trouverSoigneurDuType(typeEnclos);

            if (soigneurDuType != null) {
                System.out.println("Tournee de " + soigneurDuType.getNom() + " :");
                effectuerTournee(soigneurDuType);
            } else {
                System.out.println("Aucun soigneur du type " + typeEnclos.getSimpleName() + " n'est présent. Il est temps de recruter un soigneur du type concerné.");
            }
        }
    }

    private List<Class<?>> obtenirTypesEnclos() {
        List<Class<?>> typesEnclos = new ArrayList<>();
        for (Enclos enclo : enclos) {
            typesEnclos.add(enclo.getClass());
        }
        return typesEnclos;
    }

    private Soigneur trouverSoigneurDuType(Class<?> typeEnclos) {
        for (Soigneur soigneur : soigneurs) {
            if (soigneur.getTypeEnclos() == typeEnclos) {
                return soigneur;
            }
        }
        return null;
    }

    private void effectuerTournee(Soigneur soigneur) {
        for (Enclos enclo : soigneur.getEnclosSousResponsabilite()) {
            for (Animal animal : enclo.getAnimaux()) {
                if (!animal.estOsculte()) {
                    System.out.println("Animal malade trouvé dans l'enclos de " + soigneur.getNom() +
                            ": " + animal.getNom());
                    soigneur.soignerAnimal(animal);
                }
            }
        }
    }

    public void construireNouvelEnclos(String type){
        switch(type.toLowerCase()){
            case "terrestre" :
                enclos.add(new EnclosTerrestre(10));
                System.out.println("Nous célebrons l'ouverture d'un nouvel enclos terrestre!");
                break;

            case "aquatique" :
                enclos.add(new EnclosAquatique(10));
                System.out.println("Nous célebrons l'ouverture d'un nouvel enclos aquatique!");
                break;

            case "oiseau" :
                enclos.add(new EnclosVolieres(10));
                System.out.println("Nous célebrons l'ouverture d'un nouvel enclos volière!");
                break;

            default :
                System.out.println("Entrez un type d'enclos valide");
                break;
        }
    }



}
