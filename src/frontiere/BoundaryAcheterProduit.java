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
		System.out.println("Quel produit voulez-vous acheter ?\n");
		String produit = scan.next();
		String[] vendeursProduit = controlAcheterProduit.chercherVendeurs(produit);
		if (vendeursProduit.length == 0) {
			System.out.println("Désolé, personne ne vend ce produit au marché.\n");
		} else {
			StringBuilder choixcomm = new StringBuilder(
					"Chez quel commerçant voulez-vous acheter des" + produit + ": \n");
			for (int i = 0; i < vendeursProduit.length; i++) {
				choixcomm.append((i + 1) + " - " + vendeursProduit[i] + "\n");
			}
			System.out.println(choixcomm.toString());
			int choix = scan.nextInt();
			// TODO :t'as quasi géré le choix du commerçant, il faut gérer l'achat
		}
	}
}
