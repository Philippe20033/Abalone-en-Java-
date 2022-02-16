package jeu_Abalone;

import java.util.Scanner;

import coups.ChoixDeAlgorithmeDéplacement;
//import déplacementEnLigne.DéplacerEnLigne;

public class Abalone {

	public static void faireUnePartieAbalone(boolean aide) {
		
		//Initialisation Des Variables
		byte[][] tableDeJeu;
		byte[] nombreBilleJoueurs;
		byte[] position;
		byte numéroDeDirection;
		boolean [] directionsPossible;
		byte joueur;
		
		//Remplissage Des Variables
		Scanner sc = new Scanner(System.in);
		directionsPossible = new boolean [6];
		tableDeJeu = CreationGrille.creationNouvelleGrille();
		nombreBilleJoueurs = CreationGrille.initialisationDesBillesDesJoueurs();
		CreationGrille.placerBilles(tableDeJeu);
		joueur = 0;
		
		String[] pseudos = DonnéeJoueurs.demanderPrenomJoueurs(sc);

		do {
			joueur = DonnéeJoueurs.changerDeJoueur(joueur);
			do {
				do {
				    Affichage.afficherGrilleDeJeu(tableDeJeu);
				    position = DonnéeJoueurs.demanderJoueurQuelleBilleBouger(tableDeJeu, joueur, pseudos[joueur], sc);
				    ChoixDeAlgorithmeDéplacement.directionDansLesQuelleLaBillePeutEtreDeplacer(tableDeJeu, position, directionsPossible);
					Affichage.afficherDirectionDansLesQuellesLesBillesPeuventEtreDéplacé(directionsPossible, aide);  	
				}while (!ChoixDeAlgorithmeDéplacement.nombreDeCoupPossibleSuppérieurA1(directionsPossible));
				numéroDeDirection = DonnéeJoueurs.demanderJoueurQuelleDirection(directionsPossible, sc, aide);
			}while (numéroDeDirection == 'r');
			
			if (ChoixDeAlgorithmeDéplacement.déplacéLesBilles(numéroDeDirection)) {
				DonnéeJoueurs.joueurAUneBilleEnMoin(nombreBilleJoueurs, joueur);
			}  
		}while (nombreBilleJoueurs[joueur] > 8);
		Affichage.afficherLeGagnant(pseudos[joueur]);
	}
}
