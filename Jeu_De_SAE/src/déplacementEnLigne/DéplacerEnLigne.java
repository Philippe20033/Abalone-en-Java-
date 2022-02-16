package déplacementEnLigne;

public class DéplacerEnLigne {
	static byte [][] tab;
	static byte [] cordone;
	
	public static void envoyerTableaux(byte [][] tableDeJeu, byte [] cordoneBille) {
		tab = tableDeJeu;
		cordone = cordoneBille;
	}
	
	public static boolean déplacerLesbilles(byte numéroDeDirection) {
		boolean perteDUneBille = false;
		switch (numéroDeDirection) {
		case 0:
			perteDUneBille = déplacementNordWest();
			break;
		case 1:
			perteDUneBille = déplacementWest();
			break;
		case 2:
			perteDUneBille = déplacementSudWest();
			break;
		case 3:
			perteDUneBille = déplacementSudEst();
			break;
		case 4:
			perteDUneBille = déplacementEst();
			break;
		case 5:
			perteDUneBille = déplacementNordEst();
			break;
		}
		return perteDUneBille;
	} 
	
	public static boolean déplacementNordWest() {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		byte ligne = cordone[0], colonne = cordone[1];
		
		while (cordonéeExisteDansLeTableau(ligne, colonne) && tab[ligne][colonne] != 0) {
			if (ligne > 4) {
				ligne--;
			}
			else {
				ligne--;
				colonne--;
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colonne)) {
			if (ligne > 4) {
				ligne++;
			}
			else {
				ligne++;
				colonne++;
			}
			nombreDeBilleADéplacé--;
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne > 4) {
				tab[ligne][colonne] = tab[ligne+1][colonne];
				ligne++;
			}
			else {
				if (ligne+1 > 4) {
					tab[ligne][colonne] = tab[ligne+1][colonne];
					ligne++;
				}
				else {
					tab[ligne][colonne] = tab[ligne+1][colonne+1];
					ligne++;
					colonne++;
				}
			}
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
	}
	
	public static boolean déplacementWest () {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		
		while (cordone[1]-nombreDeBilleADéplacé > 0 && tab[cordone[0]][cordone[1]-nombreDeBilleADéplacé] != 0) {
			nombreDeBilleADéplacé++;
		}
		
		if (!(cordone[1]-nombreDeBilleADéplacé >= 0)) {
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = (byte) (cordone[1]-nombreDeBilleADéplacé); i < cordone[1]; i++) {
			tab[cordone[0]][i] = tab[cordone[0]][i+1];
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
	}
	
	public static boolean déplacementSudWest() {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		byte ligne = cordone[0], colonne = cordone[1];
		
		while (cordonéeExisteDansLeTableau(ligne, colonne) && tab[ligne][colonne] != 0) {
			if (ligne >= 4) {
				ligne++;
				colonne--;
			}
			else {
				ligne++;
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colonne)) {
			if (ligne > 4) {
				ligne--;
				colonne++;
			}
			else {
				ligne--;
			}
			nombreDeBilleADéplacé--;
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				if (ligne-1 >=4) {
					tab[ligne][colonne] = tab[ligne-1][colonne+1];
					ligne--;
					colonne++;
				}
				else {
					tab[ligne][colonne] = tab[ligne-1][colonne];
					ligne--;
				}
			}
			else {
				tab[ligne][colonne] = tab[ligne-1][colonne];
				ligne--;
			}
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
	}
	
	public static boolean déplacementSudEst() {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		byte ligne = cordone[0], colonne = cordone[1];
		
		while (cordonéeExisteDansLeTableau(ligne, colonne) && tab[ligne][colonne] != 0){
			if (ligne < 4) {
				  ligne++;
				colonne++;
			}
			else {
				ligne++;
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colonne)) {
			if (ligne > 4) {
				ligne--;
			}
			else {
				ligne--;
				colonne--;
			}
			nombreDeBilleADéplacé--;
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				if (ligne-1 >=4) {
					tab[ligne][colonne] = tab[ligne-1][colonne];
					ligne--;
				}
				else {
					tab[ligne][colonne] = tab[ligne-1][colonne-1];
					ligne--;
					colonne--;
				}
			}
			else {
				tab[ligne][colonne] = tab[ligne-1][colonne-1];
				ligne--;
				colonne--;
			}
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
	}
	
	public static boolean déplacementEst() {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		
		while (cordone[1]+nombreDeBilleADéplacé < tab[cordone[0]].length && tab[cordone[0]][cordone[1]+nombreDeBilleADéplacé] != 0) {
			nombreDeBilleADéplacé++;
		}
		
		if(!(cordone[1]+nombreDeBilleADéplacé < tab[cordone[0]].length)) {
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = (byte) (cordone[1]+nombreDeBilleADéplacé); i > cordone[1]; i--) {
			tab[cordone[0]][i] = tab[cordone[0]][i-1];
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
	}
	
	public static boolean déplacementNordEst() {
		boolean perteDUneBille = false;
		byte nombreDeBilleADéplacé = 0;
		byte ligne = cordone[0], colonne = cordone[1];
		
		while (cordonéeExisteDansLeTableau(ligne, colonne) && tab[ligne][colonne] != 0) {
			if (ligne > 4) {
				ligne--;
				colonne++;
			}
			else {
				ligne--;
			}
			nombreDeBilleADéplacé++;
		}
		
		if (!cordonéeExisteDansLeTableau(ligne, colonne)) {
			if (ligne > 4) {
				ligne++;
				colonne--;
			}
			else {
				ligne++;
			}
			nombreDeBilleADéplacé--;
			perteDUneBille = !perteDUneBille;
		}
		
		for (byte i = 0; i < nombreDeBilleADéplacé; i++) {
			if (ligne >= 4) {
				tab[ligne][colonne] = tab[ligne+1][colonne-1];
				ligne++;
				colonne--;
			}
			else {
				tab[ligne][colonne] = tab[ligne+1][colonne];
				ligne++;
			}
		}
		tab[cordone[0]][cordone[1]] = 0;
		
		return perteDUneBille;
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