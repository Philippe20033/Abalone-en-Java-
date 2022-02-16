package déplacementEnLigne;

public class vérifierDéplacementPossibleEnLigne {
	static byte [][] tab;
	static byte [] cordone;
	static boolean aideSuicide = Menu.Paramettres.RetournerEtatParamètreQuiAutoriseLesSuicides();
	
	public static void envoyerTableaux(byte [][] tableDeJeu, byte [] cordoneBille) {
		tab = tableDeJeu;
		cordone = cordoneBille;
	}
	
	public static boolean verificationDesDifférentesDirections(int direction) {
		boolean mouvement;
		
		switch (direction) {
		case 0: //cas Nord-West
			mouvement = mouvementNordWest();
			break;
		case 1: //cas west
			mouvement = mouvementWest();
			break;
		case 2: //cas Sud-west
			mouvement = mouvementSudWest();
			break;
		case 3: //cas Sud-Est
			mouvement = mouvementSudEst();
			break;
		case 4: //cas Est
			mouvement = mouvementEst();
			break;
		case 5: //cas Nord-Est
			mouvement = mouvementNordEst();
			break;
		default:
			System.out.println("Erreur dans la méthode : 'mouvementLignesColonnesEnFonctionDeLaDirection' code Erreur: 404");
			mouvement = false;
			return false;
		}
		return mouvement;
	}
	
	public static boolean mouvementNordWest() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;
		
		while ( ((colone>0 && ligne <=4 && ligne > 0) || ligne>4) && !caseVide) {
			if (ligne > 4) {
				ligne--;
				if (0 == tab[ligne][colone]) {
					caseVide = true;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
			else {
				ligne--;
				colone--;
				if (0 == tab[ligne][colone]) {
					caseVide = true;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
	
	public static boolean mouvementWest() {
		byte colone = cordone[1];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;
		

		while (colone>0 && !caseVide) {
			colone--;
			if (0 == tab[cordone[0]][colone]) {
				caseVide = !caseVide;
			}
			else if (tab[cordone[0]] [cordone[1]] == tab[cordone[0]][colone]) {
				if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
					nombreBilleMemeCouleur++;
					billeMemeCouleurDejaPassé = true;
				}
				else {
					return false;
				}
			}
			else {
				nombreBilleDifferenteCouleur++;
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
	
	public static boolean mouvementSudWest() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;
		
		while ( ((colone>=0 && ligne<4) || (colone > 0 && ligne >=4 && ligne < 8)) && !caseVide) {
			if (ligne>=4) {
				ligne++;
				colone--;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
			else {
				ligne++;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
	
	public static boolean mouvementSudEst() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;
		
		while (ligne+1 < tab.length && colone<tab[ligne+1].length && !caseVide) {
			if (ligne >= 4) {
				ligne++;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					nombreBilleMemeCouleur++;
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
			else {
				ligne++;
				colone++;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
	
	public static boolean mouvementEst() {
		byte colone = cordone[1];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;
		
		while (colone+1<tab[cordone[0]].length && !caseVide) {
			colone++;
			if (0 == tab[cordone[0]][colone]) {
				caseVide = !caseVide;
			}
			else if (tab[cordone[0]] [cordone[1]] == tab[cordone[0]][colone]) {
				if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
					nombreBilleMemeCouleur++;
					billeMemeCouleurDejaPassé = true;
				}
				else {
					return false;
				}
			}
			else {
				nombreBilleDifferenteCouleur++;
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
	
	public static boolean mouvementNordEst() {
		byte colone = cordone[1];
		byte ligne = cordone[0];
		byte nombreBilleMemeCouleur = 1;
		byte nombreBilleDifferenteCouleur = 0;
		
		boolean caseVide = false;
		boolean billeMemeCouleurDejaPassé = false;

		while (ligne-1 >= 0 && colone+1<tab[ligne-1].length && !caseVide) {
			if (ligne>4) {
				ligne--;
				colone++;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
			else {
				ligne--;
				if (0 == tab[ligne][colone]) {
					caseVide = !caseVide;
				}
				else if (tab[cordone[0]] [cordone[1]] == tab[ligne][colone]) {
					if (!billeMemeCouleurDejaPassé || nombreBilleDifferenteCouleur == 0) {
						nombreBilleMemeCouleur++;
						billeMemeCouleurDejaPassé = true;
					}
					else {
						return false;
					}
				}
				else {
					nombreBilleDifferenteCouleur++;
				}
			}
		}
		if (aideSuicide && nombreBilleDifferenteCouleur == 0 && !caseVide) {
			return false;
		}
		else {
			return (nombreBilleMemeCouleur < 4 && nombreBilleDifferenteCouleur < nombreBilleMemeCouleur);
		}
	}
		
	public static boolean verifierPasCoupsSuicide(int nombreBilleMemeCouleur, int nombreBilleDifferenteCouleur, boolean caseVide) {
		if (nombreBilleDifferenteCouleur == 0 && caseVide) {
			return nombreBilleMemeCouleur > nombreBilleDifferenteCouleur;
		}
		else {
			return false;
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
