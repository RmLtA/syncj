import java.util.ArrayList;


public class Ident {
	public String nom;
	public String expressionBooleen;
	public ArrayList<String> compteur;
	
	public Ident(String n){
		this.nom=n;
		expressionBooleen="";
		compteur = new ArrayList<String>();
	}
	
	public String getNom(){
		return nom;
	}
	
	public String getExprBool(){
		return expressionBooleen;
	}
	
	public void setExprBool(String e){
		expressionBooleen = e;
	}
	
	public void addCompteur(String s){
		compteur.add(s);
	}
	
	public String getCompteur(int i){
		return compteur.get(i);
	}

	public int getTailleTabParam(){
		return compteur.size();
	}

}
