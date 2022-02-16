package jeu_Abalone;

import java.util.Scanner;

public class DonnéeJoueurs {
	
	public static byte changerDeJoueur(byte joueur) {
		if (joueur == 0) {
			joueur = 1;
		}
		else {
			joueur = 0;
		}
		return joueur;
	}

	public static String demandeNomJoueur(boolean joueur, Scanner sc) {
		String prenom;
		prenom = demandePrenomUtilisateur(joueur, sc);
		if (!VérificationDesSaisies.verificationSaiseJoueurPrenom(prenom)) {
			System.out.println("\nJ'avais demander un prénom, pas un Pseudo mais bon...\n");
		}

		return prenom;
	}

	public static String demandePrenomUtilisateur(boolean joueur, Scanner sc) {
		Affichage.afficherSelectionJoueur(joueur);
		String prenom = sc.nextLine();
		return prenom;
	}

	//joueurBilleNoir = position 0
	//joueurBilleBlanche = position 1
	public static String[] demanderPrenomJoueurs(Scanner sc) {
		String [] pseudos = new String [2];
		pseudos[1] = DonnéeJoueurs.demandeNomJoueur(false, sc);
		pseudos[0] = DonnéeJoueurs.demandeNomJoueur(true, sc);
		Affichage.decalageHauteur(50);
		return pseudos;
	}

	// Demande a l'utilisateur de saisir les cordoné et va vériffier que les cordoné
	// existent dans le jeu
	public static byte[] demanderJoueurQuelleBilleBouger(byte[][] tableDeJeu,byte joueur, String nomJoueur, Scanner sc) {
		System.out.println("quelle bille souhaite tu bouger " + nomJoueur + " ? (Ligne puis Colonne) : ");
		String cordone = VérificationDesSaisies.verifierSaisieBillesUtilisateur(tableDeJeu, joueur, sc.nextLine().toLowerCase(), nomJoueur, sc);
		byte[] CordonéeBilleADeplacer = retrournerTableauCordoneLigneEtColonne(cordone);
		return CordonéeBilleADeplacer;
	}
	
	
	public static byte demanderJoueurQuelleDirection(boolean[] directionsPossible, Scanner sc, boolean aide) {
		byte directionChoisie = 114;
		System.out.println("Et dans quelle direction souhaite tu bouger cette bille ?");
		String direction = sc.nextLine().toLowerCase();
		while (!VérificationDesSaisies.verifierSaisieDirection(direction) || !VérificationDesSaisies.verifierCoupSaisieEstPossible(directionsPossible, direction, aide)) {
			direction = sc.nextLine().toLowerCase();
		}
		if (direction.charAt(0) == 114) {
			System.out.print("Très bien Changons de bille.\n\n\nDonc cette fois-ci ");
			return directionChoisie;
		}
		else {
			if (aide) {
				directionChoisie = (byte) (direction.charAt(0)-48);
				directionChoisie = retrouverNumeroDuCoup(directionChoisie, directionsPossible);
			}
			else {
				directionChoisie = (byte) (direction.charAt(0)-49);
			}
			for (byte i=0; i<10; i++) {
				System.out.println();
			}
		}
		return directionChoisie;
	}
	
	public static byte retrouverNumeroDuCoup(byte direction, boolean [] directionsPossible) {
		byte compteur=0;
		if (direction == 114){
			return direction;
		}
		for (byte i=0; i<6; i++) {
			if (directionsPossible[i]) {
				compteur++;
			}
			if (compteur == direction) {
				return i;
			}
		}
		return -1;
	}
	
	public static byte[] retrournerTableauCordoneLigneEtColonne(String cordone) {
		byte[] tabCordone = new byte[5];
		tabCordone[0] = (byte) (Math.abs(cordone.charAt(0)-105));
		tabCordone[1] = (byte) (cordone.charAt(1)-49);
		if (cordone.length() > 2) {
			tabCordone[2] = (byte) (Math.abs(cordone.charAt(3)-105));
			tabCordone[3] = (byte) (cordone.charAt(4)-49);
		}
		else {
			tabCordone[2] = -1;
			tabCordone[3] = -1;
		}
		return tabCordone;
	}
	
	public static void joueurAUneBilleEnMoin(byte[] nombreBilleJoueurs, byte joueur) {
		nombreBilleJoueurs[joueur] -= (byte) 1;
	}
}
