package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur, Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] chercherVendeurs(String produit) {
		Gaulois vendeursgau[] = village.rechercherVendeursProduit(produit);
		String[] vendeurs = null;
		String vendeur;
		for (int i = 0; i < vendeurs.length; i++) {
			vendeur = vendeursgau[i].getNom();
			vendeurs[i] = vendeur;
		}
		return vendeurs;
	}
	// TODO : faut plus de méthodes
}
