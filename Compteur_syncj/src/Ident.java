import java.util.ArrayList;


public class Ident {
	public String nom;
	public String expressionBooleen;
	public ArrayList<Compteur> compteur;
	
	public Ident(String n){
		this.nom=n;
		expressionBooleen="";
		compteur = new ArrayList<Compteur>();
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
	
	public void addCompteur(Compteur s){
		compteur.add(s);
	}
	
	public String getCompteur(int i){
		return compteur.get(i).nom;
	}

	public int getTailleTabParam(){
		return compteur.size();
	}
	
	public Compteur verifCompteur(String expr){
		for (int i = 0; i<compteur.size();i++){
			if(getCompteur(i).equals(expr)){
				return compteur.get(i);
			}
		}
		return null;
	}

}
