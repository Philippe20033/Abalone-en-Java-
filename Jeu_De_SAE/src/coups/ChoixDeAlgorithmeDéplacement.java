package coups;

import déplacementEnFlèche.DéplacerEnFlèche;
import déplacementEnFlèche.vérifierDéplacementPossibleEnFlèche;
import déplacementEnLigne.DéplacerEnLigne;
import déplacementEnLigne.vérifierDéplacementPossibleEnLigne;

//import java.util.Scanner;

public class ChoixDeAlgorithmeDéplacement {
	static byte [] cordone;
	
	public static void directionDansLesQuelleLaBillePeutEtreDeplacer(byte[][] tableDeJeu, byte[] cordoneBille, boolean[] directionPossibles){
		cordone = cordoneBille;
		importerTableauxDansLesClassesDeDéplacementDesBilles(tableDeJeu, cordoneBille);
		if (cordoneBille[2] == -1) {
			for (int i=0; i<6; i++) {
				directionPossibles[i] = vérifierDéplacementPossibleEnLigne.verificationDesDifférentesDirections(i);
			}
		}
		else {
			if (vérifierDéplacementPossibleEnFlèche.traiterLesDonnéesDePositionDesBilles()) {
				for (int i=0; i<6; i++) {
					directionPossibles[i] = vérifierDéplacementPossibleEnFlèche.verificationDesDifférentesTranslations(i);
				}
			}
			else {
				remplirTableauAvecCaseVide(directionPossibles);
			}
		}
	}
	
	public static boolean déplacéLesBilles (byte numéroDeDirection) {
		boolean perteDUneBille = false;
		
		if (cordone[2] != -1) {
			déplacementEnFlèche.DéplacerEnFlèche.déplacerLesbilles(numéroDeDirection);
		}
		else {
			perteDUneBille = déplacementEnLigne.DéplacerEnLigne.déplacerLesbilles(numéroDeDirection);
		}
		
		return perteDUneBille;
	}
	
	public static void importerTableauxDansLesClassesDeDéplacementDesBilles(byte[][] tableDeJeu, byte[] cordoneBille) {
		vérifierDéplacementPossibleEnLigne.envoyerTableaux(tableDeJeu, cordoneBille);
		vérifierDéplacementPossibleEnFlèche.envoyerTableaux(tableDeJeu, cordoneBille);
		DéplacerEnLigne.envoyerTableaux(tableDeJeu, cordoneBille);
		DéplacerEnFlèche.envoyerTableaux(tableDeJeu, cordoneBille);
	}
	
	public static boolean nombreDeCoupPossibleSuppérieurA1(boolean[] directionPossible) {
		for (byte i=0; i<6; i++) {
			if (directionPossible[i]) {
				return true;
			}
		}
		return false;
	}
	
	public static void remplirTableauAvecCaseVide(boolean[] tab) {
		for (int i=0; i<6; i++) {
			tab[i] = false;
		}
	}
}
