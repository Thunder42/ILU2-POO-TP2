package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		StringBuilder affichagem = new StringBuilder();
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			affichagem.append("Le marché est vide, revenez plus tard.\n");
		} else {
			String vendeur;
			String quantite;
			String produit;
			affichagem.append(nomAcheteur + " vous trouverez au marché :");
			for (int i = 0; i < infosMarche.length; i++) {
				vendeur = infosMarche[i];
				i++;
				quantite = infosMarche[i];
				i++;
				produit = infosMarche[i];
				affichagem.append("- " + vendeur + " qui vend " + quantite + " " + produit + "\n");
			}
		}
		System.out.println(affichagem.toString());
	}
}
