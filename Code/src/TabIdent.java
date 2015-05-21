
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
*/

public class TabIdent {
	
	public HashMap<String,Ident> condition;
	public ArrayList<String> buffer;
	public ArrayList<Integer> bufferType;
	public ArrayList<Counter> bufferCounter;

	/**
	 * Counstructor of the table of ident
	 */
	public TabIdent() {
		condition = new HashMap<String,Ident>();
		buffer = new ArrayList<String>();
		bufferType = new ArrayList<Integer>();
		bufferCounter = new ArrayList<Counter>();
	}
	
	/**
	 * Return the identifier which is identified by the key
	 * @param key
	 * @return identifier
	 */
	public Ident searchIdent(String key){
		Ident ident = new Ident(key);
		ident = condition.get(key);
		if(ident!=null){
			return ident;
		}else{
			return null;
		}	
	}
	
	/**
	 * Check if the identifier identified by the key exists in the table
	 * @param cle
	 * @param line the line in the source code for returning a message error
	 * @return bool
	 */
	public boolean existIdent(String key,int line) {
		if(condition.containsKey(key))
				return true;
		else
			
			return false;		
	}
	
	/**
	 * Create an identifier
	 * @param n name
	 * @param exprb boolean expression
	 * @param line the line in the source for returning a message error
	 */
	public void createIdent(String n, String exprb, int ligne){
		Ident id = new Ident(n);
		
		id.setExprBool(exprb);
		for (int i = 0; i<buffer.size(); i++){
			Counter c = new Counter(buffer.get(i), bufferType);
			bufferCounter.add(c);
			id.addCompteur(c);
		}
		putIdent(n, id, ligne);
		buffer.clear();
		bufferType.clear();
		
	}
	
	/**
	 * Put the identifier created in the table
	 * @param key
	 * @param value
	 * @param line
	 */
	public void putIdent(String key, Ident value, int line) {
		if(!existIdent(key, line) && key!=null){
			condition.put(key, value);
		}
	
	}
	
	/**
	 * Display the identifier table
	 * @param expr : the expression to display 
	 */
	public void display(String expr) {
		System.out.println("\n\nThe identifier table : ");
		for(Entry<String, Ident> e : condition.entrySet()) {
			System.out.println(e.getKey() + " = " + expr);
		}

		System.out.println("}\n");
	}

	/**
	 * Display the counters of a condition
	 * @param methode the name of the condition
	 * @param beginLine the line of the source code to display message error
	 */
	public void displayCounter(String methode, int beginLine){
		Ident id = searchIdent(methode);
		System.out.println("Counters of the condition : ");
		for(int i =0; i<id.counter.size(); i++){
			if(id.counter.get(i).getName().contains("_act") || id.counter.get(i).getName().contains("_att") || id.counter.get(i).getName().contains("_req") || id.counter.get(i).getName().contains("_term") || id.counter.get(i).getName().contains("_aut")){
				System.out.println(id.counter.get(i).getName()+"\n");
			}else{
				System.err.println("ERROR : Invalide counter name ");
			}
			
		}
	}

	/**
	 * Return a an object counter identified by expr which exists in 
	 * the arrayList of identifiers in the table
	 * @param expr identifies the counter
	 * @return counter
	 */
	public Counter checkCounter(String expr){
		for(Entry<String, Ident> e : condition.entrySet()) {
			Ident id = e.getValue();
			for(int i = 0; i<id.counter.size(); i++){
				if(id.getCounter(i).getName().equals(expr))
					return id.getCounter(i);
			}
			
		}
		System.out.println("Counter null");
		return null;
	}
	
	
	/**
	 * Add a counter in the buffer
	 * @param counter
	 */
	public void addCounter(String counter){
		buffer.add(counter);
	}
	
	/**
	 * Add a type in the bufferType
	 * @param type
	 */
	public void addType(int type){	
		bufferType.add(type);
	}
	
	/**
	 * Getter of the buffer of counter of the current identifier
	 * @return ArrayList<Counter>
	 */
	public ArrayList<Counter> getbufferCounter(){
		return bufferCounter;
	}
	
	/**
	 * Check if the counter already exists in the buffer of counter
	 * @param c : the nam of the counter
	 * @return boolean
	 */
	public boolean existCounter(String c){
		for(int i=0; i<bufferCounter.size(); i++){
			if(bufferCounter.get(i).getName().equals(c)){
				return true;
			}
		}
		return false;
	}
		
	

}
