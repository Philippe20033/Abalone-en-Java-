package Menu;

import java.util.Scanner;

public class Menu {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String saisie;
		int parametre;
		
		do {
			Affichage.afficherMessageDuMenu();
			saisie = sc.nextLine();
			
			while(!VérifierLesSaisies.saisieMenuEstCorrect(saisie)) {
				Affichage.afficherUneErreurDeSaisie();
				Affichage.afficherMessageDuMenu();
				saisie = sc.nextLine();
			}
			
			parametre = Integer.parseInt(saisie);
			allerDansLaFonction(parametre, sc);
		}while (parametre != 4);
		
		
		
	}
	
	public static void allerDansLaFonction(int fonction, Scanner sc) {
		switch(fonction) {
		
		case 1:
			jeu_Abalone.Abalone.faireUnePartieAbalone(Paramettres.RetournerEtatParamètreQuiListeDesPossibilité());
			break;
		case 2:
			Affichage.afficherLesRègles();
			break;
		case 3:
			Paramettres.menuDesParamètres(sc);
		break;
		}
	}
}
