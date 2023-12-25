public class SoigneurTerrestre extends Soigneur {
    public SoigneurTerrestre(String nom) {
        super(nom);
    }

    @Override
    public void ajouterEnclosResponsabilite(Enclos e) {
        if (e instanceof EnclosTerrestre) {
            super.ajouterEnclosResponsabilite(e);
        } else {
            System.out.println("Ce soigneur ne peut pas s'occuper de cet enclos non terrestre, celà dépasse son champ d'activité!.");
        }
    }
}
