/*False expression boolean N*/
public class ProducteurConsommateur{
	private final int TAILLE = 10;
	private String tab[] = new String[TAILLE];
	private int index_prod = 0;
	private int index_cons = 0;
	
	condition produire = (produire_aut - consommer_term <= N);
	condition consommer = (produire_term - consommer_aut == N);
	
	public void produire(String o){
		tab[index_prod] = o;
		index_prod=(index_prod+1)%TAILLE;
	}
	
	public String consommer(){
		String o = tab[index_cons];
		index_cons=(index_cons+1)%TAILLE;
		return tab[index_cons];
	}

}