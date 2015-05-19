public class ProducteurConsommateur{
	private final int TAILLE = 10;
	private object tab[] = new object[TAILLE];
	private int tab_prod = 0;
	private int tab_cons = 0;
	
	condition produire = (produire_aut - consommer_term < N );
	condition consommer = (produire_term - consommer_aut > 0);
	
	public void produire(object o){
		tab[tab_prod] = o;
		tab_prod=(tab_prod+1)%TAILLE;
	}
	
	public object consommer(){
		Object o = tab[tab_cons];
		tab_cons=(tab_cons+1)%TAILLE;
		return tab[tab_cons];
	}

}