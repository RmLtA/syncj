import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class TabIdent {
	
	public HashMap<String,Ident> condition;
	public ArrayList<String> buffer;
	public ArrayList<Integer> bufferType;
	
	public TabIdent(int taille) {
		condition = new HashMap<String,Ident>(taille);
		buffer = new ArrayList<String>();
		bufferType = new ArrayList<Integer>();

	}
	
	public Ident chercheIdent(String cle){
		Ident ident = new Ident(cle);
		ident = condition.get(cle);
		if(ident!=null){
			return ident;
		}else{
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
			Compteur c = new Compteur(buffer.get(i), bufferType);
			id.addCompteur(c);
		}
		rangeIdent(n, id, ligne);
		buffer.clear();
		bufferType.clear();
		
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
		Ident id = chercheIdent(methode);
		System.out.println("Compteurs de la condition : ");
		for(int i =0; i<id.compteur.size(); i++){
			System.out.println(id.compteur.get(i).getNomCompt()+"\n");
		}
	}
	
	public Compteur verifCompteur(String expr){
		for(Entry<String, Ident> e : condition.entrySet()) {
			Ident id = e.getValue();
			for(int i = 0; i<id.compteur.size(); i++){
				if(id.getCompteur(i).getNomCompt().equals(expr))
					return id.getCompteur(i);
			}
			
		}
		System.out.println("Compteur null");
		return null;
	}
	
	
	
	public void ajoutCompteur(String compteur){	
		buffer.add(compteur);
	}
	
	public void ajoutType(int type){	
		bufferType.add(type);
	}
		
	

}
