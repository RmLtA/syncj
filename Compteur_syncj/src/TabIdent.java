import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent {
	
	private HashMap<String,Ident> condition;
	
	public TabIdent(int taille) {
		condition = new HashMap<String,Ident>(taille);

	}
	
	public Ident chercheIdent(String cle, int ligne) {
		Ident ident = new Ident(cle);
		ident = condition.get(cle);
		if(ident!=null){
			return ident;
		}else{
			System.out.println("\n erreur ligne : "+ligne+" chercheIdent() n'arrive pas � trouver l'identificateur de nom : "+cle+" car elle n'existe pas dans la table\n");
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
		rangeIdent(n, id, ligne);
		
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
		
	

}
