
public class LecteurRedacteur{
	
	private final int TAILLE= 10;
	private String tab[] = new String[TAILLE];
	
	private int tab_lec=0;
	private int tab_red=0;
	

	private int ecrire_act= 0;
	public boolean cond_lire(){
		return (ecrire_act == 0 );
	}

	private int lire_act= 0;
	public boolean cond_ecrire(){
		return (ecrire_act == 0 && lire_act == 0 );
	}

	
	public String lire(){
		 synchronized(this){ 
			while(!cond_lire()){
				this.wait();
			}
			lire_act++ ;
			
		}
		
		String s = tab[tab_lec];
		tab_lec=(tab_lec+1)%TAILLE;
		
		synchronized(this){ 
			lire_act-- ;
			this.notifyAll();
		
		}return s;
	}

	public void ecrire(String s){
		 synchronized(this){ 
			while(!cond_ecrire()){
				this.wait();
			}
			ecrire_act++ ;
			
		}
		
		tab[tab_red]=s;
		tab_red=(tab_red+1)%TAILLE;
	
		synchronized(this){ 
			ecrire_act-- ;
			this.notifyAll();
		
		}
	}
	
}
