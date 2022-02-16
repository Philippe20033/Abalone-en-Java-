package Menu;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Affichage {
	
	public static void afficherMessageDuMenu() {
		System.out.println("Que souhaitez-vous faire ?\n");
		System.out.println("\t-1. Jouer 👻👻👻");
		System.out.println("\t-2. Lire les Règles 💩💩");
		System.out.println("\t-3. Accéder aux paramètres 🔧");
		System.out.println("\t-4. Quitter 😧 😧 ");
	}
	
	public static void afficherMenuParamettres() {
		System.out.println("Reglons quelques petits paramètres 🔧🔧🔧\n");
		System.out.println("\t-1. " + afficherInverseEtatParamètres(1) + " l'aide qui liste uniquement les déplacement possibles 👻👻👻");
		System.out.println("\t-2. " + afficherInverseEtatParamètres(2) + " la sécurité antisuicide 💩💩");
		System.out.println("\t-3. Revenir au menu principal 💥");
	}
	
	public static void afficherUneErreurDeSaisie(){
		System.out.println("Je n'es pas compris ce que tu m'as écrit 🤔❓❓❓");
	}
	
	public static void afficherLesRègles() {
		System.out.println("\n\n\n\n");
		System.out.println("Présentation du jeu\n");
		System.out.println("Abalone est un jeu de société, stratégique crée par Michel");
		System.out.println("Lalet et Laurent Lévi.\n");
		
		System.out.println("\tAu début de la partie les boules sont disposé comme ci");
		System.out.println("dessous, 5 boules sur les dernières lignes,6 boules sur les");
		System.out.println("avant dernières lignes et les trois autres placé sur les");
		System.out.println("lignes suivants à minimun 2 case de la bordure du plateau.\n");
		
		System.out.println("\n\tLe joueur ayant les boules noirs commence la partie,chaque");
		System.out.println("joueur peut déplacer jusqu'à 3 des ses boules maximun qu'une");
		System.out.println("fois durant chacun de ses tours, c'est ce qu'on appelle un");
		System.out.println("mouvement.Un mouvement consiste à déplacer une ou plusieurs");
		System.out.println("billes vers un espace libres via l'une des 6 directions de");
		System.out.println("l'hexagones du jeu.Une fois effectué, un mouvement ne peut");
		System.out.println("plus être changé.\n");
		
		System.out.println("\n\tLe joueur ayant les boules noirs commence la partie,chaque");
		System.out.println("Il arrive qu'un joueur se retrouve en position de");
		System.out.println("\"Sumito\" ,c'est à dire lorqu'il est en supériorité numérique");
		System.out.println("Le joueur ayant les boules noirs commence la partie,chaqueface à son adversaire.\n");
		
		System.out.println("\n\tLorsqu'un joueur est en position de sumito, il peut pousser");
		System.out.println("la ou les boule(s) de l'adversaire seulement si :\n");
		System.out.println("-Il le fait en faisant un mouvement \"en ligne\"(voir plus plus haut).\n");
		System.out.println("-Lorsque les boules noirs et blanches sont en contact direct.\r\n");
		System.out.println("-Et lorqu'il y a un espace libre derrière la boule ou les 2 boules attaquées.\n\n");
		System.out.println("\tUne boule est dite \"boule ejecté\" lorsqu'elle a été poussée hors de l'hexagone.\n");
		System.out.println("\tLe but du jeu est d'être le premier à  éjecter 6 boules de");
		System.out.println("l'adverses hors de l'hexagone,alors la partie s'arrête et");
		System.out.println("vous remportez la partie.\n\n");
		System.out.println("Plus d'info sur : https://fr.wikipedia.org/wiki/Abalone_(jeu)");
		System.out.println("\n\n\n\n");
	}
	
	public static String afficherInverseEtatParamètres(int ligne){
		FileSystem fs = FileSystems.getDefault();
		Path chemin = fs.getPath("C:\\Users\\Licorne_Magic\\Documents\\Abalone_Fichier_Sauvegarde\\paramètre.txt");
		List<String> lines = null;
		try {
			lines = Files.readAllLines(chemin);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		if (lines.get(ligne).equals("false")) {
			return "Activer";
		}
		else {
			return "Désactiver";
		}
		
	}
}
