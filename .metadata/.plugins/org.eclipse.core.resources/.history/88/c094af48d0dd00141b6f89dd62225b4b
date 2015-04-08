import java.util.ArrayList;


public class Compteur {
	public String nom;
	public ArrayList<Integer> listetype;
	
	public Compteur(String n, ArrayList<Integer> l){
		nom=n;
		listetype= new ArrayList<Integer>();
		for(int i=0; i<l.size(); i++){
			listetype.add(l.get(i));
		}
	}
	
	public boolean containType(int t){
		if( this!=null)
			return listetype.contains(t);
		else
			return false;
	}
	
	public String getNomCompt(){
		return nom;
	}
	
	public void addType(int t){
		listetype.add(t);
	}
}
