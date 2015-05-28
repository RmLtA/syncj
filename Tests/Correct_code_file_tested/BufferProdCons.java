package pck_test2;
public class ProducteurConsommateur {
	private final int TAILLE = 10;
	private String tab[] = new String [TAILLE];
	private int tab_prod = 0;
	private int tab_cons = 0;
	
	condition consommer = (produire_term - consommer_aut >0);
	condition produire = (produire_aut - consommer_term < 10);
	
	public boolean cond_consommer () {
		return (produire_term - consommer_aut >0);
	}
	
	ProducteurConsommateur(){
		for(int i=0;i<tab.length;i++){
			tab[i]="0";
		}
		
	}
	
	public void produire(String o){
		
		tab[tab_prod]=o;
		tab_prod=(tab_prod+1)%TAILLE;
		
	}
	
	public Object consommer (){
		Object o = tab[tab_cons];
		tab[tab_cons]="0";
		tab_cons=(tab_cons+1)%TAILLE;
		return o;
	}
	
	public void display(){
		System.out.println("----------------------------------------------------------------------------------------");
		for(int i=0;i<tab.length;i++){
		
			System.out.print(tab[i]+"   |    ");	
		}
		System.out.println("\n");
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("\n");
		
	}
}