package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		village.installerVendeur(abraracourcix, "boucliers", 20);

	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		assertNotNull(controlLibererEtal, "Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		assertTrue(controlLibererEtal.isVendeur("Abraracourcix"));
		assertFalse(controlLibererEtal.isVendeur("Existe pas"));
	}

	@Test
	void testLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur, village);
		String[] testLibererE = controlLibererEtal.libererEtal("Abraracourcix");
		assertNotNull(testLibererE, "LibererEtal ne renvoie pas null");
		assertTrue(testLibererE[0].equals("true"));
		assertTrue(testLibererE[1].equals("Abraracourcix"));
		assertTrue(testLibererE[2].equals("boucliers"));
		assertTrue(testLibererE[3].equals("20"));
	}

}
