public class ProducteurConsommateur{
	private final int TAILLE = 10;
	private String tab[] = new String[TAILLE];
	private int index_prod = 0;
	private int index_cons = 0;
	
	private int produire_aut= 0;
	private int consommer_term= 0;
		public boolean cond_produire(){
		return (produire_aut - consommer_term < 10 );
	}

	private int produire_term= 0;
	private int consommer_aut= 0;
		public boolean cond_consommer(){
		return (produire_term - consommer_aut > 0 );
	}

	
	public void produire(String o) throws InterruptedException{
		 synchronized(this){ 
			while(!cond_produire()){
				this.wait();
			}
			 produire_req++;
		
		}
		
		tab[index_prod] = o;
		index_prod=(index_prod+1)%TAILLE;
	
		synchronized(this){ 
			 produire_act++;
			this.notifyAll();
		
		}
	}
	
	public String consommer() throws InterruptedException{
		 synchronized(this){ 
			while(!cond_consommer()){
				this.wait();
			}
			 consommer_req++;
		
		}
		
		String o = tab[index_cons];
		index_cons=(index_cons+1)%TAILLE;
		
		synchronized(this){ 
			 consommer_act++;
			this.notifyAll();
		
		}return tab[index_cons];
	}

}