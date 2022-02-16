package Menu;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class Paramettres {
		static String cheminDFichier = "C:\\Users\\Licorne_Magic\\Documents\\Abalone_Fichier_Sauvegarde\\paramètre.txt";
		
		public static void menuDesParamètres(Scanner sc){
			String saisie;
			int parametre;
			do {
				Affichage.afficherMenuParamettres();
				saisie = sc.nextLine();
				
				while(!VérifierLesSaisies.saisieMenuEstCorrect(saisie)) {
					Affichage.afficherUneErreurDeSaisie();
					Affichage.afficherMenuParamettres();
					saisie = sc.nextLine();
				}
				
				parametre = Integer.parseInt(saisie);
				if (parametre != 3 && parametre != 4)
					changerEtatParamètre(parametre);
			}while(parametre != 3);
		}
			
		public static void changerEtatParamètre(int ligne){
			FileSystem fs = FileSystems.getDefault();
			Path chemin = fs.getPath(cheminDFichier);
			List<String> lines = null;
			try {
				lines = Files.readAllLines(chemin);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (lines.get(ligne).equals("false")) {
				lines.set(ligne, "true");
			}
			else {
				lines.set(ligne, "false");
			}
			
			try {
				Files.write(chemin, lines);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		public static boolean RetournerEtatParamètreQuiListeDesPossibilité(){
			FileSystem fs = FileSystems.getDefault();
			Path chemin = fs.getPath(cheminDFichier);
			List<String> lines = null;
			try {
				lines = Files.readAllLines(chemin);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (lines.get(1).equals("false")) {
				return false;
			}
			return true;
		}
		
		public static boolean RetournerEtatParamètreQuiAutoriseLesSuicides(){
			FileSystem fs = FileSystems.getDefault();
			Path chemin = fs.getPath(cheminDFichier);
			List<String> lines = null;
			try {
				lines = Files.readAllLines(chemin);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			if (lines.get(2).equals("false")) {
				return false;
			}
			return true;
		}
		
}

