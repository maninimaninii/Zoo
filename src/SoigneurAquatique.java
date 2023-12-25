public class SoigneurAquatique extends Soigneur {
    public SoigneurAquatique(String nom) {
        super(nom);
    }

    @Override
    public void ajouterEnclosResponsabilite(Enclos e) {
        if (e instanceof EnclosAquatique) {
            super.ajouterEnclosResponsabilite(e);
        } else {
            System.out.println("Ce soigneur ne peut pas s'occuper de cet enclos non aquatique, celà dépasse son champ de capacité!.");
        }
    }
}
