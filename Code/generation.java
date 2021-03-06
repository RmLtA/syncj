
public class LecteurRedacteur{
	
	private final int TAILLE= 10;
	private String tab[] = new String[TAILLE];
	
	private int tab_lec=0;
	private int tab_red=0;
	private int ecrire_act = 0;

	private int lire_req = 0;
	private int lire_aut = 0;
	private int lire_term = 0;
	public boolean cond_lire(){
		return (ecrire_act == 0 );
	}

	private int ecrire_req = 0;
	private int ecrire_aut = 0;
	private int ecrire_term = 0;
	public boolean cond_ecrire(){
		return (ecrire_act == 0 && lire_act == 0 );
	}

	
	public void lire(){
		 synchronized(this){ 
			lire_req++ ;
			this.notifyAll();
			lire_att++ ;
			this.notifyAll();
			while(!cond_lire()){
				this.wait();
				}
			lire_aut++ ;
			this.notifyAll();
			lire_att-- ;
			this.notifyAll();
			lire_act++ ;
			this.notifyAll();
			}
		
		
		String s = tab[tab_lec];
		tab_lec=(tab_lec+1)%TAILLE;
		return s;
	synchronized(this){ 
			lire_term++ ;
			this.notifyAll();
			lire_act-- ;
			this.notifyAll();
			}
		}

	public void ecrire(String s){
		 synchronized(this){ 
			ecrire_req++ ;
			this.notifyAll();
			ecrire_att++ ;
			this.notifyAll();
			while(!cond_ecrire()){
				this.wait();
				}
			ecrire_aut++ ;
			this.notifyAll();
			ecrire_att-- ;
			this.notifyAll();
			ecrire_act++ ;
			this.notifyAll();
			}
		
		tab[tab_red]=s;
		tab_red=(tab_red+1)%TAILLE;
	synchronized(this){ 
			ecrire_term++ ;
			this.notifyAll();
			ecrire_act-- ;
			this.notifyAll();
			}
		}
	

}
