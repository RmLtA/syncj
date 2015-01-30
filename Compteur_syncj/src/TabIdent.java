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
			System.out.println(" ERREUR existeIdent() : l'ident de nom: "+cle+" n'est dans aucune des tables de locaux ou globaux, ligne "+ligne+"\n");
			return false;		
	}
	
	public void rangeIdent(String cle, Ident valeur) {

		condition.put(cle, valeur);
		
	}
		
	

}
