
public class Compteur {
	public String nom;
	public int type;
	
	public Compteur(String n, int t){
		nom=n;
		type=t;
	}
	
	public int getType(){
		return type;
	}
	
	public String getNomCompt(){
		return nom;
	}
}
