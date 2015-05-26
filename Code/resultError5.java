
public class ProducteurConsommateur{
	private final int TAILLE = ;
	private String tab[] = new String[TAILLE];
	private int index_prod = ;
	private int index_cons = ;
	
	private int produire_aut= 0;
	private int consommer_term= 0;
	private int taille_act= 0;
	public boolean cond_produire(){
		return (produire_aut - consommer_term == taille_act );
	}

	private int produire_term= 0;
	private int consommer_aut= 0;
	private int taille_term= 0;
	public boolean cond_consommer(){
		return (produire_term - consommer_aut == taille_term );
	}

	
	public void produire(String o) throws InterruptedException{
		 synchronized(this){ 
			while(!cond_produire()){
				this.wait();
			}
			 produire_aut++;
		
		}
		
		tab[index_prod] = o;
		index_prod=(index_prod+1)%TAILLE;
	
		synchronized(this){ 
			 produire_term++;
		
		}
	}
	
	public String consommer() throws InterruptedException{
		 synchronized(this){ 
			while(!cond_consommer()){
				this.wait();
			}
			 consommer_aut++;
		
		}
		
		String o = tab[index_cons];
		index_cons=(index_cons+)%TAILLE;
		
		synchronized(this){ 
			 consommer_term++;
		
		}return tab[index_cons];
	}

}