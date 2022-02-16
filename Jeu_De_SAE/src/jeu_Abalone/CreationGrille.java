package jeu_Abalone;

public class CreationGrille {

	public static byte[][] creationNouvelleGrille() {

		byte[][] Grille;
		Grille = new byte[9][];
		int nombreDeColonne = 5; // taille de la première ligne du plateau

		for (int i = 0; i < 9; i++) {
			Grille[i] = new byte[nombreDeColonne];
			if (i < 4)
				nombreDeColonne ++; // taille de la ligne i du plateau
			else if (i >= 4)
				nombreDeColonne --; // taille de la ligne i du plateau
		}
		return Grille;
	}

	public static void placerBilles(byte[][] tableDeJeu) {
		//placerCaseDecalage(tableDeJeu);
		placerPionBlanc(tableDeJeu);
		placerPionNoir(tableDeJeu);

	}

	public static void placerPionNoir(byte[][] tableDeJeu) {
		byte pionNoir = 2;
		for (int ligne = 8; ligne >= 7; ligne--) {
			for (int colonne = 0; colonne < tableDeJeu[ligne].length; colonne++) {
					tableDeJeu[ligne][colonne] = pionNoir;
				}
			}

		for (int colonne = 2; colonne <= 4; colonne++) {
			tableDeJeu[6][colonne] = pionNoir;
		}
	}
	
	public static void placerPionBlanc(byte[][] tableDeJeu) {
		byte pionBlanc = 1;
		for (int ligne = 0; ligne < 2; ligne++) {
			for (int colonne = 0; colonne < tableDeJeu[ligne].length; colonne++) {
				tableDeJeu[ligne][colonne] = pionBlanc;
			}
		}

		for (int colonne = 2; colonne <= 4; colonne++) {
				tableDeJeu[2][colonne] = pionBlanc;
			}
		}
	

	public static boolean nombrePair(int nombre) {
		return (nombre % 2 == 0);
	}
	
	public static byte[] initialisationDesBillesDesJoueurs() {
		byte[] nombreBilleJoueurs = new byte[2];
		nombreBilleJoueurs[0] = 14;
		nombreBilleJoueurs[1] = 14;
		
		return nombreBilleJoueurs;
		
	}

}