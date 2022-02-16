package déplacementEnFlèche;

public class vérifierDéplacementPossibleEnFlèche {
	static byte [][] tab;
	static byte [] cordone;
	
	public static void envoyerTableaux(byte [][] tableDeJeu, byte [] cordoneBille) {
		tab = tableDeJeu;
		cordone = cordoneBille;
	}
	
	public static boolean traiterLesDonnéesDePositionDesBilles() {
		boolean mouvementExist = true;
		metLesCordonéesDansLOrdreCroissant();
		cordone[4] = détermineLOrientationDesBilles();
		
		if (cordone[4] != 3) {
			mouvementExist = vérifieQueLesBillesSontAlignéEtInférieurATrois();
		}
		return mouvementExist;
	}
	
	public static boolean verificationDesDifférentesTranslations(int direction) {
		boolean mouvement = false;
		
		switch (direction) {
		case 0: //cas Nord-West
			if (cordone[4] != 1) {
				mouvement = vérifierTranslationNordWest();
			}
			else {
				faireSymétrieTableauDeCordonées();
				mouvement = déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementNordWest();
				faireSymétrieTableauDeCordonées();
			}
			break;
			
		case 1: //cas west
		    mouvement = vérifierTranslationWest();
			break;
			
		case 2: //cas Sud-west
			if (cordone[4]!=0) {
				mouvement = vérifierTranslationSudWest();
			}
			else {
				mouvement = déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementSudWest();
			}
			break;
			
		case 3: //cas Sud-Est
			if (cordone[4] != 1) {
				mouvement = vérifierTranslationSudEst();
			}
			else {
				mouvement = déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementSudEst();
			}
			break;
			
		case 4: //cas Est
			mouvement = vérifierTranslationEst();
			break;
			
		case 5: //cas Nord-Est
			if (cordone[4] !=0 ) {
				mouvement = vérifierTranslationNordEst();
			}
			else {
				faireSymétrieTableauDeCordonées();
				mouvement = déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementNordEst();
				faireSymétrieTableauDeCordonées();
			}
			break;
		}
		return mouvement;
	}
	
	public static void metLesCordonéesDansLOrdreCroissant() {
		if (cordone[2]<cordone[0]) {
			faireSymétrieTableauDeCordonées();
		}
		else if (cordone[2] == cordone[0]) {
			if (cordone[3]<cordone[1]) {
				byte colonne = cordone[1];
				cordone[1]=cordone[3];
				cordone[3]=colonne;
			}
		}
	}
	
	public static void faireSymétrieTableauDeCordonées(){
		byte ligne = cordone[0];
		byte colonne = cordone[1];
		cordone[0]=cordone[2];
		cordone[1]=cordone[3];
		cordone[2]=ligne;
		cordone[3]=colonne;
	}
	
	// 3 : Les billes sont alignées 
	// 1 : La partie droite des bille pointe vers le haut
	// 0 : La partie droite des bille pointe vers le bas
	public static byte détermineLOrientationDesBilles() {
		byte orientation = 0;
		
		if (cordone[0] == cordone [2]) {
			orientation = 3;
		}
		else if (cordone[0] <= 4 && cordone[2] <= 4) {
			if (cordone[1] < cordone[3]) {
				orientation = 1;
			}
		}
		else if (cordone[0] >= 4 && cordone[2] >= 4) {
			if (cordone[1] <= cordone[3]) {
				orientation = 1;
			}
		}
		else {
			if (cordone[1] <= cordone[3]) {
				orientation = 1;
			}
		}
		return orientation;
	}
	
	public static boolean vérifieQueLesBillesSontAlignéEtInférieurATrois() {
		byte colone = cordone[1] ;
		byte ligne = cordone[0];
		byte compteur = 1;
		
		
		while (compteur < 3 && (colone != cordone[3] || ligne != cordone[2]) && cordonéeExisteDansLeTableau(ligne, colone) ) {
			if (cordone[4] == 1) {
				if (ligne < 4) {
					ligne++;
					colone++;
				}
				else {
					ligne++;
				}
			}
			else if (cordone[4] == 0){
				if (ligne < 4) {
					ligne++;
				}
				else {
					ligne++;
					colone--;
				}
			}
			else {
				colone++;
			}
			
			compteur++;
		}
		return (colone == cordone[3] && ligne == cordone[2]);
	}
	
	
	public static boolean vérifierTranslationNordWest() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 0) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementNordWest(ligne, colone);
				if (ligne >= 4) {
					ligne++;
					colone--;
				}
				else {
					ligne++;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementNordWest(ligne, colone);
			}
		}
		else {
			while(colone != cordone[3] && mouvementPossible) {
				mouvementPossible = vérifierMouvementNordWest(ligne, colone);
				colone++;
			}
			if (colone == cordone[3] && mouvementPossible) {
				return vérifierMouvementNordWest(ligne, colone);
			}
		}
		
		return false;
	}
	
	public static boolean vérifierMouvementNordWest(byte ligne, byte colone) {
		if (ligne > 4) {
			ligne--;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
		else {
			ligne--;
			colone--;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
		return false;
	}
	
	public static boolean vérifierTranslationWest() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 1) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementWest(ligne, colone);
				if (ligne < 4) {
					ligne++;
					colone++;
				}
				else {
					ligne++;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementWest(ligne, colone);
			}
		}
		else if (cordone[4] == 0) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementWest(ligne, colone);
				if (ligne < 4) {
					ligne++;
				}
				else {
					ligne++;
					colone--;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementWest(ligne, colone);
			}
		}
			
		else {
			faireSymétrieTableauDeCordonées();
			mouvementPossible = déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementWest();
			faireSymétrieTableauDeCordonées();
			return mouvementPossible;
		}
		return false;
	}
	
	public static boolean vérifierMouvementWest(byte ligne, byte colone) {
		colone--;
		if (cordonéeExisteDansLeTableau(ligne, colone)) {
			if (0 == tab[ligne][colone]) {
				return true;
			}
		}
	return false;
	}
	
	public static boolean vérifierTranslationSudWest() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 1) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementSudWest(ligne, colone);
				if (ligne < 4) {
					ligne++;
					colone++;
				}
				else {
					ligne++;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementSudWest(ligne, colone);
			}
		}
		else {
			while(colone != cordone[3] && mouvementPossible) {
				mouvementPossible = vérifierMouvementSudWest(ligne, colone);
				colone++;
			}
			if (colone == cordone[3] && mouvementPossible) {
				return vérifierMouvementSudWest(ligne, colone);
			}
		}
		return false;
	}
	
	public static boolean vérifierMouvementSudWest(byte ligne, byte colone) {
		if (ligne >= 4) {
			ligne++;
			colone--;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
		else {
			ligne++;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
	return false;
	}
	
	public static boolean vérifierTranslationSudEst() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 0) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementSudEst(ligne, colone);
				if (ligne < 4) {
					ligne++;
				}
				else {
					ligne++;
					colone--;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementSudEst(ligne, colone);
			}
		}
		else {
			while(colone != cordone[3] && mouvementPossible) {
				mouvementPossible = vérifierMouvementSudEst(ligne, colone);
				colone++;
			}
			if (colone == cordone[3] && mouvementPossible) {
				return vérifierMouvementSudEst(ligne, colone);
			}
		}
		return false;
	}
	
	public static boolean vérifierMouvementSudEst(byte ligne, byte colone) {
		if (ligne >= 4) {
			ligne++;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
		else {
			ligne++;
			colone++;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
	return false;
	}
	
	public static boolean vérifierTranslationEst() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 1) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementEst(ligne, colone);
				if (ligne < 4) {
					ligne++;
					colone++;
				}
				else {
					ligne++;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementSudEst(ligne, colone);
			}
		}
		else if (cordone[4] == 0) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementEst(ligne, colone);
				if (ligne < 4) {
					ligne++;
				}
				else {
					ligne++;
					colone--;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return vérifierMouvementEst(ligne, colone);
			}
		}
			
		else {
			return déplacementEnLigne.vérifierDéplacementPossibleEnLigne.mouvementEst();
		}
		return false;
	}
	
	public static boolean vérifierMouvementEst(byte ligne, byte colone) {
		colone++;
		if (cordonéeExisteDansLeTableau(ligne, colone)) {
			if (0 == tab[ligne][colone]) {
				return true;
			}
		}
	return false;
	}
	
	public static boolean vérifierTranslationNordEst() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		boolean mouvementPossible = true;
		
		if (cordone[4] == 1) {
			while ( (ligne != cordone[2] || cordone[3] != colone) && mouvementPossible) {
				mouvementPossible = vérifierMouvementNordEst(ligne, colone);
				if (ligne < 4) {
					ligne++;
					colone++;
				}
				else {
					ligne++;
				}
			}
			if (ligne == cordone[2] && cordone[3] == colone && mouvementPossible) {
				return true;
			}
		}
		else {
			while(colone != cordone[3] && mouvementPossible) {
				mouvementPossible = vérifierMouvementNordEst(ligne, colone);
				colone++;
			}
			if (colone == cordone[3] && mouvementPossible) {
				return vérifierMouvementNordEst(ligne, colone);
			}
		}
		return false;
	}
	
	public static boolean vérifierMouvementNordEst(byte ligne, byte colone) {
		if (ligne >= 4) {
			ligne--;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
		else {
			ligne--;
			colone++;
			if (cordonéeExisteDansLeTableau(ligne, colone)) {
				if (0 == tab[ligne][colone]) {
					return true;
				}
			}
		}
	return false;
	}
	
	public static boolean cordonéeExisteDansLeTableau(byte i, byte j) {
		if (i < tab.length && i >= 0) {
			if (j < tab[i].length && j >= 0) {
				return true;
			}
		}
		return false;
	}
}
