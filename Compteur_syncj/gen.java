public class LecteurRedacteur {
	
	private final int TAILLE= 10;
	private String tab[] = new String [TAILLE];
	
	private int tab_lec=0;
	private int tab_red=0;

	private int lire_req = 0;
	private int lire_aut = 0;
	private int lire_term = 0;
public boolean cond_lire(){
	return ecrire_act==0;
}

	private int ecrire_req = 0;
	private int ecrire_aut = 0;
	private int ecrire_term = 0;
public boolean cond_ecrire(){
	return ecrire_act==0ecrire_act==0&&lire_act==0;
}

	
	public String lire(){
		
		String s = tab[tab_lec];
		tab_lec=(tab_lec+1)%TAILLE;
		return s;
	}

	public void ecrire(String s){
		tab[tab_red]=s;
		tab_red=(tab_red+1)%TAILLE;
	}
}