package jeu_Abalone;

import java.util.Scanner;

public class VérificationDesSaisies {
	
	public static boolean verificationSaiseJoueurPrenom(String prenom) {
		char lettre;
		for (int i = 0; i < prenom.length(); i++) {
			lettre = prenom.charAt(i);
			if (!(lettre >= 65 && lettre <= 90 || lettre >= 97 && lettre <= 122 || lettre == 45 || lettre == 126)) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean verifierCoupSaisieEstPossible(boolean [] directionsPossible, String directionStr, boolean aide) {
		if (directionStr.length() > 0 && directionStr.length() < 2) {
			byte direction = (byte) (directionStr.charAt(0));
			if (direction == 114) {
				return true;
			}
			if (aide) {
				direction -= 48;
				direction = DonnéeJoueurs.retrouverNumeroDuCoup(direction, directionsPossible);
				for (byte i=0; i<directionsPossible.length; i++) {
					if ( (directionsPossible[i] && direction == i) ) {
						return true;
					}
				}
			}
			else {
				direction -= 49;
				if (directionsPossible[direction]) {
					return true;
				}
			}
			System.out.println("veuillez entrez une direction jouable uniquement");
			return false;
		}
		else {
			System.out.println("veuillez entrez une direction possible uniquement ou R pour réssayer");
			return false;
		}
	}
	
	public static boolean verifierSaisieDirection(String direction){
		byte erreur = codeErreurSaisieDirection(direction);
		Affichage.afficherErreurSaisieDirection(erreur);
		return (erreur==0);
	}
	
	public static byte codeErreurSaisieDirection(String direction) {
		byte erreur = 0;
		if (direction.length() < 1) {
			erreur = 2;
		}
		else {
			int caratères = direction.charAt(0);
			if ( (caratères < 49 || caratères > 54) && caratères != 114) {
				erreur = 1;
			}
			else if (direction.length() > 1) {
				erreur = 3;
			}
		}
		return erreur;
	}


	public static String verifierSaisieBillesUtilisateur(byte[][] tableDeJeu, byte joueur, String cordone, String nomJoueur, Scanner sc) {
		byte[] numeroDeCordoné = new byte [2];
		do {
			if (cordone.indexOf("-") != -1) {
				verifierSaisieDUneTranslation(tableDeJeu, joueur, cordone, nomJoueur, numeroDeCordoné);
			}
			else {
				verifierSaisieDeUneBille(tableDeJeu, joueur, cordone, nomJoueur, numeroDeCordoné);
			}
			
			if (numeroDeCordoné[0] != 0) {
				Affichage.afficherUtilisateurProblèmeDeUneCordone(tableDeJeu, numeroDeCordoné[0], cordone, nomJoueur, numeroDeCordoné[1]);
				cordone = sc.nextLine().toLowerCase();
			}
		}while(numeroDeCordoné[0] !=0);
		
		return cordone;
	}
	

	public static void verifierSaisieDUneTranslation (byte[][] tableDeJeu, byte joueur, String cordone, String nomJoueur, byte[] numeroDeCordoné) {
		byte erreur = 0;
		byte boucle;
		byte tableauProbleme = 0;
		String[] tabCordone = cordone.split("-");
		
		boucle =0;
		while (boucle < 2 && erreur == 0) {
			erreur = verifierSaisieCordone(tabCordone[0], boucle, tableDeJeu);
			tableauProbleme = 0;
			boucle++;
		}
		
	    if (erreur == 0) {
	    	boucle =0;
			while (boucle < 2 && erreur == 0) {
				erreur = verifierSaisieCordone(tabCordone[1], boucle, tableDeJeu);
				tableauProbleme = 1;
				boucle++;
			}
	    }
		
		if (erreur == 0) {
			byte i = 0;
			while (numeroDeCordoné[0] == 0 && i < 2) {
				verifierSaisieDeUneBille(tableDeJeu, joueur, tabCordone[i], nomJoueur, numeroDeCordoné);
				i++;
			}
		}
	
		if (erreur == 0 && !billeExiste(tableDeJeu, tabCordone[0])) {
			erreur = 6;
			tableauProbleme = 0;
		}
		if (erreur == 0 && !billeExiste(tableDeJeu, tabCordone[1])) {
			erreur = 6;
			tableauProbleme = 1;
		}
		if (erreur == 0 && !verifierBilleAppartienAuJoueur(tableDeJeu, joueur, tabCordone[0])) {
			erreur = 5;
			tableauProbleme = 0;
		}
		if (erreur == 0 && !verifierBilleAppartienAuJoueur(tableDeJeu, joueur, tabCordone[1])) {
			erreur = 5;
			tableauProbleme = 1;
		}
		if (erreur == 0 && tabCordone[0].charAt(0) == tabCordone[1].charAt(0) && tabCordone[0].charAt(1) == tabCordone[1].charAt(1)) {
			erreur = 9;
		}
		numeroDeCordoné[0] = erreur;
		numeroDeCordoné[1] = tableauProbleme;
	}
	
	public static void verifierSaisieDeUneBille (byte[][] tableDeJeu, byte joueur, String cordone, String nomJoueur, byte[] numeroDeCordoné) {
		byte erreur=0;
		for (int i= 0; i<2; i++) {
			if (erreur==0) {
				erreur = verifierSaisieCordone(cordone, i, tableDeJeu);
			}
		}
		if (erreur==0) {
			if (billeExiste(tableDeJeu, cordone)) {
				if (!verifierBilleAppartienAuJoueur(tableDeJeu, joueur, cordone)) {
					erreur = 5;
				}
			}
			else {
				erreur = 6;
			}
		}
		numeroDeCordoné[0] = erreur;
	}
	
	public static boolean billeExiste(byte[][] tableDeJeu, String cordone) {
		return (tableDeJeu[Math.abs(cordone.charAt(0)-105)][cordone.charAt(1)-49] != 0);
	}
	
	public static boolean verifierBilleAppartienAuJoueur(byte[][] tableDeJeu, int joueur, String cordone) {
		int ligne = Math.abs(((int) cordone.charAt(0))-105);
		int colonne = ((int) cordone.charAt(1))-49;
		if (joueur == 0) {
			if (tableDeJeu[ligne][colonne] == 2) {
					return true;
				}
			else {
				return false;
			}
		}
		else if (tableDeJeu[ligne][colonne] == 1) {
			return true;
			}
		else {
			return false;
		}
	}
	
	public static byte verifierSaisieCordone(String cordone, int typeDeCordone, byte[][] tableDeJeu) {
		byte erreur;
		
		if (cordone.length() > 2) {
			erreur = 1;
		}
		else if (cordone.length() < 2 && cordone.length() > 0) {
			erreur = 7;
		}
		else if (cordone.length() == 0) {
			erreur = 8;
		}
		else {
			char nombre = cordone.charAt(typeDeCordone);
			if (typeDeCordone == 0 || typeDeCordone == 3) {
				if (nombre>=97 && nombre<=105) {
					erreur = 0;
				}
				else {
					erreur = 3 ;
				}
			}
			else if (nombre>=49 && nombre<=57) {
				if (tableDeJeu[Math.abs((cordone.charAt(0)-105))].length >= (cordone.charAt(1)-48)) {
					erreur = 0;
				}
				else {
					erreur = 4;
				}
			}
			else {
				erreur = 2;
			}
		}
		return erreur;
	}
}
