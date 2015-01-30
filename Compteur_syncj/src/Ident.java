import java.util.ArrayList;


public class Ident {
	public String nom;
	public ArrayList<Integer> param;
	
	public Ident(String n){
		this.nom=n;
		param=new ArrayList<Integer>();
	}
	
	public String getNom(){
		return nom;
	}
	
	public int getParam(int i){
		return param.get(i);
	}
	
	public int getTailleTabParam(){
		return param.size();
	}

}
