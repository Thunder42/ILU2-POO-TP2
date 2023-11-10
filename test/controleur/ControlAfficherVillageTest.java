package controleur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAfficherVillageTest {
	private Village village;
	private Chef abraracourcix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
	}

	@Test
	void testControlAfficherVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		assertNotNull(controlAfficherVillage, "Constructeur ne renvoie pas null");
	}

	@Test
	void testDonnerNomsVillageois() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String testVillageois[] = controlAfficherVillage.donnerNomsVillageois();
		assertNotNull(testVillageois, "DonnerNomsVillageois ne renvoie pas null");
		assertTrue(testVillageois[0].equals("Abraracourcix"));
		// Avec autres villageois ?
	}

	@Test
	void testDonnerNomVillage() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		String testNomVillage = controlAfficherVillage.donnerNomVillage();
		assertTrue(testNomVillage.equals("le village des irréductibles"));
	}

	@Test
	void testDonnerNbEtals() {
		ControlAfficherVillage controlAfficherVillage = new ControlAfficherVillage(village);
		int testNbEtals = controlAfficherVillage.donnerNbEtals();
		assertTrue(testNbEtals == 5);
		// ajouter et retirer un étal pour voir si le nombre change ?
	}

}
