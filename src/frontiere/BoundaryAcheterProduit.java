package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		if (!controlAcheterProduit.verifierIdentiteClient(nomAcheteur)) {
			System.out.println("Je suis désolé " + nomAcheteur
					+ " mais il faut être un habitant du village pour commercer ici.\n");
		} else {
			System.out.println("Quel produit voulez-vous acheter ?");
			String produit = scan.next();
			String[] vendeursProduit = controlAcheterProduit.chercherVendeurs(produit);
			if (vendeursProduit.length == 0) {
				System.out.println("Désolé, personne ne vend ce produit au marché.\n");
			} else {
				StringBuilder choixcomm = new StringBuilder(
						"Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < vendeursProduit.length; i++) {
					choixcomm.append((i + 1) + " - " + vendeursProduit[i] + "\n");
				}
				System.out.println(choixcomm.toString());
				int choix = scan.nextInt();
				if (choix > 0 && choix <= vendeursProduit.length) {
					String nomVendeur = vendeursProduit[choix - 1];
					System.out.println(nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + nomVendeur
							+ ".\nBonjour " + nomAcheteur + ".\nCombien de " + produit + " voulez-vous acheter ?\n");
					int quantite = scan.nextInt();
					int quantiteAchetee = controlAcheterProduit.acheterProduit(quantite, nomVendeur);
					if (quantiteAchetee != -1) {
						StringBuilder achat = new StringBuilder();
						if (quantiteAchetee == quantite) {
							achat.append(
									nomAcheteur + " achète " + quantite + " " + produit + " à " + nomVendeur + ".\n");
						} else {
							achat.append(nomAcheteur + " veut acheter " + quantite + produit);
							if (quantiteAchetee == 0) {
								achat.append(", malheureusement il n'y en a plus !\n");
							} else {
								achat.append(", malheureusement " + nomVendeur + " n'en a plus que " + quantiteAchetee
										+ ". " + nomAcheteur + " achète tout le stock de " + nomVendeur + ".\n");
							}
						}
						System.out.println(achat.toString());
					}
				}
			}
		}
	}
}