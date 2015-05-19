public Class ProducteurConsommateur {
	private final int TAILLE = 10;
	private object tab[] = new object [ TAILLE]
	private int tab_prod = 0;
	private int tab_cons = 0;

	private int produire_aut = 0;
	private int produire_term = 0;
	
	private int consommer_aut = 0;
	private int consommer_term = 0;

	public boolean cond_produire () {
		return (produire_aut - consommer_term < N);
	}
	public boolean cond_consommer () {
		return (produire_term - consommer_aut >0);
	}
	public void produire(Object o){
		synchronized ( this ){
			while (! cond_produire()){
			this.wait();
		}
			produire_aut++;
			this.notifyAll();
		}
		
		tab[tab_prod]=o;
		tab_prod=(tab_prod+1)%TAILLE;
		
		synchronized (this){
			produire_term++;
			this.notifyAll();
		}
	}
	
	public Object consommer (){
		synchronized ( this ){
			while (!cond_consommer()){
				this.wait();
			}
			consommer_aut++;
			this.notifyAll();
		}
		Object o = tab[tab_cons];
		tab_cons=(tab_cons+1)%TAILLE;
		
		synchronized (this){
			consommer_term++;
			this.notifyAll();
		}	return tab[tab_cons];
		
	}
}