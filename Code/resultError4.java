public class LecteurRedacteur{
	
	private final int TAILLE= ;
	private String tab[] = new String[TAILLE];
	
	private int tab_lec=;
	private int tab_red=;

	
	public String lire()
		String s = tab[tab_lec];
		tab_lec=(tab_lec+)%TAILLE;
		return s;
	}

	public void ecrire(String s)
		tab[tab_red]=s;
		tab_red=(tab_red+)%TAILLE;
	}
	
}