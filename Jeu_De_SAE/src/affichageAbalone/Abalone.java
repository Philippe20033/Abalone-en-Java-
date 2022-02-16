package affichageAbalone;

public class Abalone {
	/* transformer plateau en tab de int enlever bordure haut,bas du tableau et le placer dans l'affichage */
	
	

	public static int[][] creePlateau(){

		/* Crée un plateau de longueur 9 * 17 avec des points et le renvoie sous forme d'un tableau à double entrée */

		/* initialisation du plateau */

		int[][] plateau = new int[9][17];
		int caseVide = 0 ; // ⏺
		int caseOccupBlanc =  1 ; // ⚪️
		int caseOccupBleu = 2 ; // 🔵

		/* création de la première ligne */

		dessineBordure(plateau[0], 0, 4);
		dessineCase(plateau[0], 4, 13, caseOccupBlanc);
		dessineBordure(plateau[0], 13, 17);

		/* création de la deuxième ligne */

		dessineBordure(plateau[1], 0, 3);
		dessineCase(plateau[1], 3, 14, caseOccupBlanc);
		dessineBordure(plateau[1], 14, 17);

		/* création de la  troisième ligne */

		dessineBordure(plateau[2], 0, 2);
		dessineCase(plateau[2], 2, 6, caseVide);
		dessineCase(plateau[2], 6, 12, caseOccupBlanc);
		dessineCase(plateau[2], 12, 15, caseVide);
		dessineBordure(plateau[2], 15, 17);

		/* création de la  quatrième ligne */

		dessineBordure(plateau[3], 0, 1);
		dessineCase(plateau[3], 1, 16, caseVide);
		dessineBordure(plateau[3], 16, 17);

		/* création de la  cinquième ligne */

		dessineCase(plateau[4], 0, 17, caseVide);


		/* création de la  sixième ligne */

		dessineBordure(plateau[5], 0, 1);
		dessineCase(plateau[5], 1, 16, caseVide);
		dessineBordure(plateau[5], 16, 17);

		/* création de la  septième ligne */

		dessineBordure(plateau[6], 0, 2);
		dessineCase(plateau[6], 2, 6, caseVide);
		dessineCase(plateau[6], 6, 12, caseOccupBleu);
		dessineCase(plateau[6], 12, 15, caseVide);
		dessineBordure(plateau[6], 15, 17);

		/* création de la  huitième ligne */

		dessineBordure(plateau[7], 0, 3);
		dessineCase(plateau[7], 3, 14, caseOccupBleu);
		dessineBordure(plateau[7], 14, 17);

		/* création de la neuvième ligne et dernière ligne */

		dessineBordure(plateau[8], 0, 4);
		dessineCase(plateau[8], 4, 13, caseOccupBleu);
		dessineBordure(plateau[8], 13, 17);

		return plateau;
	}

	public static void afficherPlateau(int[][] plateau){

		/* Procédure affichant le tableau a double entrée pris en
		 en paramètre */
		
		System.out.print(0);
		
		for (int k = 0 ; k < plateau[0].length + 2 ; k++) {
			System.out.print("⬛️"); // bordure haute
		}

		System.out.println();

		for (int i = 0 ; i < plateau.length ; i++) {
			System.out.print(i + 1);
			System.out.print("⬛️"); // bordure gauche
			for (int j = 0 ; j < plateau[i].length ; j++) {
				switch (plateau[i][j]) {

					case -1 :
						System.out.print("🔳️"); 
						break;

					case 0 :
						System.out.print("⏺");
						break;

					case 1 :
						System.out.print("⚪");
						break;

					case 2 :
						System.out.print("🔵"); 
						break;

					case 3 :
						System.out.print("⬛️");
						break;

				default:
                	break;
				}
			}
		
		System.out.print("⬛️"); // bordure droite
		System.out.println();

		}
		System.out.print(10);
		
		for (int k = 0 ; k < plateau[8].length  + 2 ; k++) {
			System.out.print("⬛️"); // bordure basse
		}
		
		System.out.println();
		System.out.print(0);
		
		for (int k = 0 ; k < plateau[8].length  + 2 ; k++) {
			System.out.print(k + 1); // bordure basse
		}

		System.out.println("\n");
	}

	public static void dessineBordure(int[] tab, int debut, int fin) {

		/* dessine des bordure le tableau "tab" de la case à l'indice
		  "debut" inclut jusqu'à la case d'indice  de valeur fin exclue */

		for (int k = debut ; k < fin  ; k++) {
			tab[k] = 3; // ⬛️
		}
	}

	public static void dessineCase(int[] tab, int debut, int fin, int caseValeur ) {
		int caseInacessible = -1; // 🔳️
		for (int k = debut ; k < fin  ; k++) {
			if (debut % 2 == 0) {
				if (k % 2 == 0) {
					tab[k] = caseValeur;
				}
				else {
					tab[k] = caseInacessible;
				}
			}
			else {
				if (k % 2 != 0) {
					tab[k] = caseValeur;
				}
				else {
					tab[k] = caseInacessible;
				}
			}
		}
	}
}



