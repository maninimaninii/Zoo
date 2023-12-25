public class SoigneurOiseau extends Soigneur {
    public SoigneurOiseau(String nom) {
        super(nom);
    }

    @Override
    public void ajouterEnclosResponsabilite(Enclos e) {
        if (e instanceof EnclosVolieres) {
            super.ajouterEnclosResponsabilite(e);
        } else {
            System.out.println("Ce soigneur ne peut pas s'occuper de cet enclos non voliere, celà dépasse son champ d'expertise!.");
        }
    }
}
