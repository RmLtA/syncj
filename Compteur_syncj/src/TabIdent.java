import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent {
	
	private HashMap<String,Ident> condition;
	public ArrayList<String> buffer;
	
	public TabIdent(int taille) {
		condition = new HashMap<String,Ident>(taille);
		buffer = new ArrayList<String>(); 

	}
	
	public Ident chercheIdent(String cle, int ligne) {
		Ident ident = new Ident(cle);
		ident = condition.get(cle);
		if(ident!=null){
			return ident;
		}else{
			System.out.println("\n erreur ligne : "+ligne+" chercheIdent() n'arrive pas à trouver l'identificateur de nom : "+cle+" car elle n'existe pas dans la table\n");
			return null;
		}	
	}
	
	public boolean existeIdent(String cle,int ligne) {
		if(condition.containsKey(cle))
				return true;
		else
			
			return false;		
	}
	
	public void createIdent(String n, String exprb, int ligne){
		Ident id = new Ident(n);
		id.setExprBool(exprb);
		for (int i = 0; i<buffer.size(); i++){
			id.addCompteur(buffer.get(i));
		}
		rangeIdent(n, id, ligne);
		buffer.clear();
		
	}
	
	public void rangeIdent(String cle, Ident valeur, int ligne) {
		if(!existeIdent(cle, ligne) && cle!=null){
			condition.put(cle, valeur);
		}
	
	}
	
	public void affiche(String expr) {
		System.out.println("\n\nVoici la table des identificateurs : ");
		for(Entry<String, Ident> e : condition.entrySet()) {
			System.out.println(e.getKey() + " = " + expr);
		}

		System.out.println("}\n");
	}
	
	public void afficheCompteur(String methode, int beginLine){
		Ident id = chercheIdent(methode, beginLine);
		for(int i =0; i<id.compteur.size(); i++){
			System.out.println(id.compteur.get(i)+"\n");
		}
	}
	
	public boolean verifCompteur(String expr){
		switch(expr){
			case "att":
				return true;
			case "act":
				return true;
			case "req":
				return true;
			case "aut":
				return true;
			case "term":
				return true;
			default:
				return false;
		}
	}
	
	public void ajoutCompteur(String compteur){		
		System.out.println(compteur);
		buffer.add(compteur);
	}
		
	

}
