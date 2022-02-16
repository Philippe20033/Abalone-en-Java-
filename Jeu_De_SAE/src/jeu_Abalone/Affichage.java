package jeu_Abalone;

import coups.ChoixDeAlgorithmeDéplacement;

public class Affichage {
	
	public static void afficherGrilleDeJeu(byte[][] tableDeJeu) { // Affiche le plateau du jeu avec leur coordoné
		decalageHauteur(1);
		for (int ligne = 0; ligne < tableDeJeu.length; ligne++) {
			AfficherLeBonNombreEspaceEnFonctionLigne(ligne);
			nomDeLaLignePateauDeJeu(ligne);
			for (int colonne = 0; colonne < tableDeJeu[ligne].length; colonne++) {
				System.out.print(afficherPion(tableDeJeu[ligne][colonne]));
			}
			nomDeLaColonnePateauDeJeu(ligne);
			System.out.println();
		}
		decalageHauteur(1);
	}

	public static String afficherPion(int pion) {
		String imagePion;
		switch (pion) {
		case 1:
			imagePion = "⚪️";
			break;
		case 2:
			imagePion = "⚫️";
			break;
		default :
			imagePion = "🧿";
			break;
		}
		return imagePion;
	}
	
	public static void sEnuyer(int ms)
	{
	    try{
	        Thread.sleep(ms);
	    }
	    catch(InterruptedException ex){
	        Thread.currentThread().interrupt();
	    }
	}

	public static void nomDeLaLignePateauDeJeu(int ligne) { // Affiche le nom des lignes entre (A-I)
		System.out.print(((char) (-ligne + 73)) + " ");
	}
	
	public static void modeFlemmeErreur() {
		System.out.println();
		double hasard = Math.random();
		if (hasard > 0.95) {
			affichageFlemmeErreur();
		}
	}
	
	public static void affichageFlemmeErreur() {
			System.out.println("Mise en marche du mode economie de coneries..");
			for (int i=0; i<=16; i++) {
				if (i<=15) {
				System.out.println("Chargement...   ");
				}
				else {
					System.out.println("\nLa bêtise est nettement supérieure à l'intelligence car toute l'intelligence du monde ne permettra jamais de comprendre la bêtise universelle,\ntandis qu'un peu de bêtise suffit amplement à ne pas comprendre quoi que ce soit d'intelligent....😈😈😈\n\n"); 
					sEnuyer(1500);
				}
				sEnuyer(500);
			}
			//System.out.println("\n\n");
		}

	public static void afficherUtilisateurProblèmeDeUneCordone(byte[][] tableDeJeu, byte erreur, String cordone, String nomJoueur, byte tableauProbleme) {
		for (byte i=0; i<20; i++) {
			System.out.println();
		}
		
		String[] tabCordone = cordone.split("-");
		
		switch (erreur) {
		case 1:
			System.out.println("Dans '" + tabCordone[tableauProbleme] + "', Il y a plus que deux caractères.\nIl faut saisir 2 informations " + nomJoueur + "!, le numéro de la ligne et celui de la colone c'est pourtant simple à comprendre 😩.");
			break;
		case 2:
			System.out.println("La colonne '"+ tabCordone[tableauProbleme].charAt(1) + "' n'est pas une cordoné du plateau de jeu 🙄, y'en a toujours un pour écrire des conneries... 🤣🤣🤣");
			break;
		case 3:
			System.out.println("La ligne '"+ tabCordone[tableauProbleme].charAt(0) + "' n'existe même pas sur le plateau de jeu 🙄, y'en a toujours un pour écrire des conneries... 🤣🤣🤣\nPour la peine moi aussi je me met a imaginer😌, Vive les licornes 🦄🦄🦄 !!!");
			break;
		case 4:
			System.out.println("Tu as du mal compter, dans la ligne '" + tabCordone[tableauProbleme].charAt(0) + "', la colonne " + tabCordone[tableauProbleme].charAt(1) +" n'existe pas 😉.");
			break;
		case 5:
			System.out.println("Heuuu...\n" + nomJoueur + ", la bille : '" + tabCordone[tableauProbleme].toUpperCase() + "' appartienent à ton adversaire... FAIT UN EFFORT POUR UNE FOIS 😡 ArEtTe De TrIcHeR !!");
			break;
		case 6:
			System.out.println("La case " + tabCordone[tableauProbleme].toUpperCase() +" ne contien aucune bille.\nPS: je connais un bonne ophtalmologue si tu veux... 🤣🤣🤣");
			break;
		case 7:
			System.out.print("Nom mais fait un petit effort au moin, comment tu veux que avec la ligne " + tabCordone[tableauProbleme].charAt(0) + " je trouve la bille que tu veux bouger ???");
			for (int i=0; i<=100; i++) {
				System.out.print("😭");
			}
			System.out.println();
			break;
		case 8:
			System.out.println("Haha c'est marrant de spamer la touche entrer 🙄");
			break;
		case 9:
			System.out.println("hein ? '" + tabCordone[0] + "' et '" + tabCordone[1] + "' c'est la même bille 🤯🤯🤯\n\n   MOI PAS COMPRENDRE CE QUE TOI DIRE A MOI");
			break;
		}
		Affichage.modeFlemmeErreur();	
		Affichage.afficherGrilleDeJeu(tableDeJeu);
		System.out.println("Sinon, Peut-tu réesayer ? ohhhh " + nomJoueur + " que j'admire...🤩🤩🤩\n\n\n");
	}
	
	public static void nomDeLaColonnePateauDeJeu(int ligne) {
		switch (ligne) {
		case 5:
			System.out.print(" " + 9);
			break;
		case 6:
			System.out.print(" " + 8);
			break;
		case 7:
			System.out.print(" " + 7);
			break;
		case 8:
			System.out.println(" " + 6);
			AfficherLeBonNombreEspaceEnFonctionLigne(ligne);
			System.out.print("   ");
			for (int i = 1; i <= 5; i++) {
				System.out.print(i);
				System.out.print(" ");
			}
			break;
		}
	}

	public static void decalageHauteur(int Hauteur) { // Décalle en hauteur l'affichage sur le terminal
		for (int i = 0; i < Hauteur; i++) {
			System.out.println();
		}
	}

	public static void AfficherLeBonNombreEspaceEnFonctionLigne(int ligne) { // Met des espace pour afficher corectement
		// le plateau de jeu

		int DecalageDuBortEcran = 10;
		String bordure = " ";

		switch (ligne) {
		case 0:
			for (int i = 0; i < DecalageDuBortEcran + 4; i++) {
				System.out.print(bordure);
			}
			break;
		case 1:
			for (int i = 0; i < DecalageDuBortEcran + 3; i++) {
				System.out.print(bordure);
			}
			break;
		case 2:
			for (int i = 0; i < DecalageDuBortEcran + 2; i++) {
				System.out.print(bordure);
			}
			break;
		case 3:
			for (int i = 0; i < DecalageDuBortEcran + 1; i++) {
				System.out.print(bordure);
			}
			break;
		case 4:
			for (int i = 0; i < DecalageDuBortEcran; i++) {
				System.out.print(bordure);
			}
			break;
		case 5:
			for (int i = 0; i < DecalageDuBortEcran + 1; i++) {
				System.out.print(bordure);
			}
			break;
		case 6:
			for (int i = 0; i < DecalageDuBortEcran + 2; i++) {
				System.out.print(bordure);
			}
			break;
		case 7:
			for (int i = 0; i < DecalageDuBortEcran + 3; i++) {
				System.out.print(bordure);
			}
			break;
		case 8:
			for (int i = 0; i < DecalageDuBortEcran + 4; i++) {
				System.out.print(bordure);
			}
			break;
		}
	}

	public static void afficherTableau(byte[][] tableDeJeu) { // Affiche le tableau du jeu à l'état brut
		for (int ligne = 0; ligne < tableDeJeu.length; ligne++) {
			for (int colonne = 0; colonne < tableDeJeu[ligne].length; colonne++) {
				System.out.print(tableDeJeu[ligne][colonne]);
			}
			System.out.println();
		}
	}
	
	public static void afficherSelectionJoueur(boolean joueur) {
		if (joueur) {
			System.out.println("Quelle est le prénom du joueur avec les billes Noir ?");
		} else {
			System.out.println("Quelle est le prénom du joueur avec les billes Blanche ?");
		}
	}

	public static void afficherBienvenue() {
		int nombreEtoile = 100;
		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println();

		for (int i = 0; i < 32; i++) {
			System.out.print(" ");
		}
		System.out.print("Le : ");
		System.out.print(java.time.LocalDate.now());
		System.out.print(" à : ");
		System.out.println(java.time.LocalTime.now());

		for (int i = 0; i < 36; i++) {
			System.out.print(" ");
		}
		System.out.println("Bienvue Dans le jeux Abalone 🤪");
		for (int i = 0; i < 30; i++) {
			System.out.print(" ");
		}
		System.out.println("C'est un plaisir de vous accueillir 🤗🤗🤗");

		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i = 0; i < nombreEtoile; i++) {
			System.out.print("*");
		}
		System.out.println("\n\n\n\n");
	}
	
	public static void afficherDirectionDansLesQuellesLesBillesPeuventEtreDéplacé(boolean[] directionPossibles, boolean aide) {
		if (aide) {
			System.out.println("\nchoix possible :");
			byte numéroDeDirection = 0;
			for (byte i=0; i<6; i++) {
				if (directionPossibles[i]) {
					numéroDeDirection++;
					afficherUneDirection(i, numéroDeDirection);
				}
			}
		}
		else {
			System.out.println("\nchoix possible :");
			for (byte i=0; i<6; i++) {
				afficherUneDirection(i, (byte) (i+1));
			}
		}
		if (!ChoixDeAlgorithmeDéplacement.nombreDeCoupPossibleSuppérieurA1(directionPossibles)) {
			System.out.println("ha ba on dirait que y'en a pas 🤣🤣🤣");
			afficherBilleNonDéplacable();
		}
		else {
			afficherTouchePourChangerDeBille();
		}
	}
	
	public static void afficherTouchePourChangerDeBille() {
		System.out.println("\nR. Changer de bille");
		System.out.println();
	}
	
	public static void afficherUneDirection(byte direction, byte numéroDeDirection){
		switch(direction) {
		case 0:
			System.out.println(numéroDeDirection + ". Nord-West");
			break;
		case 1:
			System.out.println(numéroDeDirection + ". West");
			break;
		case 2:
			System.out.println(numéroDeDirection + ". Sud-West");
			break;
		case 3:
			System.out.println(numéroDeDirection + ". Sud-Est");
			break;
		case 4:
			System.out.println(numéroDeDirection + ". Est");
			break;
		case 5:
			System.out.println(numéroDeDirection + ". Nord-Est");
			break;
		}
	}
	
	public static void afficherToutesLesDirections() {
		System.out.println("\nchoix possible :");
		for (byte i=0; i<6; i++) {
			afficherUneDirection(i, (byte) (i+1));
		}
		afficherTouchePourChangerDeBille();
	}
	
	public static void afficherErreurSaisieDirection(byte erreur) {
		switch (erreur) {
		case 1:
			modeFlemmeErreur();
			System.out.println("Veuillez entrer un chiffre ou 'R' 👀");
			break;
		case 2:
			modeFlemmeErreur();
			System.out.println("Veuillez entrer quelque chose je ne suis pas encore devin 🥲");
			break;
		case 3:
			modeFlemmeErreur();
			System.out.println("Veuillez entrer uniquement un chiffre 😕");
			break;
		}
	}
	
	public static void afficherBilleNonDéplacable() {
		System.out.println("\nLa Bille Selectoné ne peut pas être déplacé (sauf si tu souhaite en perdre)\n");
		System.out.print("Donc... ");
	}
	
	public static void afficherLeGagnant(String pseudoJoueur) {
		byte nombre = 1;
		boolean[] tab = new boolean[0];
		System.out.print("\033[H\033[2J");
		System.out.flush();
		System.out.println("Whoooooo ! \nMais on on a un grand Vainceur !!!\n\n\nBravo " + pseudoJoueur + " Tu as litéralement tout déchiré ! 🥳🥳🥳");
		System.out.println("Et le perdant ba il a le droit d'aller m'acheté une glace 😁😁😁, moi je travaille pas pour rien non mais rohh");
		sEnuyer(9000);
		System.out.println("\n\n\n\n\nAlors ce code ?, il est comment ??? 😄");
		sEnuyer(3000);
		System.out.println("Et ba il BBBBBEEEUUUUGGGGGGGG 🤖🤖 regarde 🤣 :");
		tab[nombre] = true;
		


	}

}
