package Menu;

public class VérifierLesSaisies {
	
	public static boolean saisieMenuEstCorrect(String mot) {
		char saisie;
		if (mot.length() > 0) {
			saisie = mot.charAt(0);
			return ( saisie != 49 || saisie != 50 || saisie != 51 );
		}
		return false;
	}
}
