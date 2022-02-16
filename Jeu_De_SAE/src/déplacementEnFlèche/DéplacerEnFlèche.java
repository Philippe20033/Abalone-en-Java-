package déplacementEnFlèche;

public class DéplacerEnFlèche {
	static byte [][] tab;
	static byte [] cordone;
	
	public static void envoyerTableaux(byte [][] tableDeJeu, byte [] cordoneBille) {
		tab = tableDeJeu;
		cordone = cordoneBille;
	}
	
	public static void déplacerLesbilles(byte numéroDeDirection) {
		switch (numéroDeDirection) {
		case 0:
			if (cordone[4] != 1) {
				translationNordWest();
			}
			else {
				déplacementEnFlèche.vérifierDéplacementPossibleEnFlèche.faireSymétrieTableauDeCordonées();
				déplacementEnLigne.DéplacerEnLigne.déplacementNordWest();
			}
			break;
		case 1:
			
			translationWest();
			break;
			
		case 2:
			if (cordone[4] != 0) {
				translationSudWest();
			}
			else {
				déplacementEnLigne.DéplacerEnLigne.déplacementSudWest();
			}
			break;
			
		case 3:
			if (cordone[4] != 1) {
				tanslationSudEst();
			}
			else {
				déplacementEnLigne.DéplacerEnLigne.déplacementSudEst();
			}
			break;
		case 4:
			translationEst();
			break;
			
		case 5:
			if (cordone[4] !=0 ) {
				translationNordEst();
			}
			else {
				déplacementEnFlèche.vérifierDéplacementPossibleEnFlèche.faireSymétrieTableauDeCordonées();
				déplacementEnLigne.DéplacerEnLigne.déplacementNordEst();
			}
			break;
		}
	}
	
	public static void translationNordWest() {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		while (!finDeCompteur) {
			if (ligne >= 4) {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone-1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone-1]) {
					ligne++;
					colone--;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			else {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
					ligne++;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colone)) {
			nombreDeBilleADéplacé--;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne > 4) {
				tab[ligne-1][colone] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				ligne--;
				colone++;
			}
			else {
				tab[ligne-1][colone-1] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				ligne--;
			}
		}
	}
	
	public static void translationWest () {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		if (cordone[4] == 0) {
		
			while (!finDeCompteur) {
				if (ligne >= 4) {
					if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone-1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone-1]) {
						ligne++;
						colone--;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				else {
					if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), colone) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
						ligne++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				nombreDeBilleADéplacé++;
			}
			
			if (!cordonéeExisteDansLeTableau(ligne, colone)) {
				nombreDeBilleADéplacé--;
			}
			
			for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
				if (ligne > 4) {
					tab[ligne][colone-1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
					colone++;
				}
				else {
					tab[ligne][colone-1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
				}
			}
			
		}
		else {
			while (cordonéeExisteDansLeTableau(ligne, colone) && !finDeCompteur) {
				if (ligne >= 4) {
					if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), colone) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
						ligne++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				else {
					if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone+1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone+1]) {
						ligne++;
						colone++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				nombreDeBilleADéplacé++;
			}
			
			if (!cordonéeExisteDansLeTableau(ligne, colone)) {
				nombreDeBilleADéplacé--;
			}
			
			for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
				if (ligne > 4) {
					tab[ligne][colone-1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
				}
				else {
					tab[ligne][colone-1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
					colone--;
				}
			}

		}
	}
	
	public static void translationSudWest() {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		while (!finDeCompteur) {
			if (ligne >= 4) {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), colone) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
					ligne++;

				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			else {
				if (cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone+1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone+1]) {
					ligne++;
					colone++;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colone)) {
			nombreDeBilleADéplacé--;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				tab[ligne+1][colone-1] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				if (ligne-1 >= 4) {
					ligne--;
				}
				else {
					ligne--;
					colone--;
				}
			}
			else {
				tab[ligne+1][colone] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				ligne--;
				colone--;
			}
		}
	}
	
	public static void tanslationSudEst() {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		while (!finDeCompteur){
			if (ligne < 4) {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), colone) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
					ligne++;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			else {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone-1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone-1]) {
					ligne++;
					colone--;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colone)) {
			if (ligne >= 4) {
				ligne--;
			}
			else {
				ligne--;
				colone++;
			}
			nombreDeBilleADéplacé--;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				tab[ligne+1][colone] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				if (ligne-1 >=4) {
					ligne--;
					colone++;
				}
				else {
					ligne--;
				}
			}
			else {
				tab[ligne+1][colone+1] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				ligne--;
			}
		}
	}
	
	public static void translationEst() {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		if (cordone[4] == 0) {
		
			while (cordonéeExisteDansLeTableau(ligne, colone) && !finDeCompteur) {
				if (ligne >= 4) {
					if (tab[cordone[0]][cordone[1]] == tab[ligne+1][colone-1]) {
						ligne++;
						colone--;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				else {
					if (tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
						ligne++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				nombreDeBilleADéplacé++;
			}
			
			if (!cordonéeExisteDansLeTableau(ligne, colone)) {
				nombreDeBilleADéplacé--;
			}
			
			for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
				if (ligne > 4) {
					tab[ligne][colone+1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
					colone++;
				}
				else {
					tab[ligne][colone+1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
				}
			}
			
		}
		else {
			while (cordonéeExisteDansLeTableau(ligne, colone) && !finDeCompteur) {
				if (ligne >= 4) {
					if (tab[cordone[0]][cordone[1]] == tab[ligne+1][colone]) {
						ligne++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				else {
					if (tab[cordone[0]][cordone[1]] == tab[ligne+1][colone+1]) {
						ligne++;
						colone++;
					}
					else {
						finDeCompteur = !finDeCompteur;
					}
				}
				nombreDeBilleADéplacé++;
			}
			
			if (!cordonéeExisteDansLeTableau(ligne, colone)) {
				if (ligne < 4) {
					ligne--;
				}
				else {
					ligne--;
					colone--;
				}
				nombreDeBilleADéplacé--;
			}
			
			for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
				if (ligne >= 4) {
					tab[ligne][colone+1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne++;
				}
				else {
					tab[ligne][colone+1] = tab[ligne][colone];
					tab[ligne][colone] = 0;
					ligne--;
					colone--;
				}
			}

		}
	}
	
	public static void translationNordEst() {
		byte nombreDeBilleADéplacé = 0;
		boolean finDeCompteur = false;
		byte ligne = cordone[0], colone = cordone[1];
		
		while (!finDeCompteur) {
			if (ligne > 4) {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), (byte)(colone+1)) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone+1] ) {
					ligne++;
					colone++;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			else {
				if ( cordonéeExisteDansLeTableau( (byte)(ligne+1), colone) && tab[cordone[0]][cordone[1]] == tab[ligne+1][colone] ) {
					ligne++;
				}
				else {
					finDeCompteur = !finDeCompteur;
				}
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colone)) {
			nombreDeBilleADéplacé--;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				if (ligne-1 >= 4 ) {
					tab[ligne-1][colone+1] = tab[ligne][colone];
				}
				else {
					tab[ligne-1][colone] = tab[ligne][colone];
				}
				tab[ligne][colone] = 0;
				ligne++;
			}
			else {
				tab[ligne-1][colone] = tab[ligne][colone];
				tab[ligne][colone] = 0;
				ligne--;
				colone--;
			}
		}
	}
	
	public static boolean cordonéeExisteDansLeTableau(byte ligne, byte colonne) {
		if (ligne < tab.length && ligne >= 0) {
			if (colonne < tab[ligne].length && colonne >= 0) {
				return true;
			}
		}
		return false;
	}
}
