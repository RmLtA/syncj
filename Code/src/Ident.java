
import java.util.ArrayList;
/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
*/


public class Ident {
	public String name;
	public String booleanExpression;
	public ArrayList<Counter> counter;
	
	/**
	 * Constructor of an ident 
	 * @param	n : the name of the ident
	 */
	public Ident(String n){
		this.name=n;
		booleanExpression="";
		counter = new ArrayList<Counter>();
	}
	
	/**
	 * Return the name of an ident
	 * @return name of the ident
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Return the booelan expression
	 * @return booelan expression of an ident
	 */
	public String getExprBool(){
		return booleanExpression;
	}
	
	/**
	 * Setter of an the boolean expression of an identifier
	 * @param e : the boolean expression
	 */
	public void setExprBool(String e){
		booleanExpression = e;
	}
	
	/**
	 * Add counter to the ident
	 * @param c : counter
	 */
	public void addCompteur(Counter c){
		counter.add(c);
	}
	
	/**
	 * Getter of the counter of an ident
	 * @return Counter
	 */
	public Counter getCounter(int i){
		return counter.get(i);
	}

	/**
	 * Getter of the size of the list of counter
	 * @return size
	 */
	public int getsizeTabCounter(){
		return counter.size();
	}
	
	/**
	 * Check if the counter exists in the list of the ident
	 * @param c : the name of the counter
	 * @return boolean
	 */
	public boolean existCounter(String c){
		for(int i = 0; i<getsizeTabCounter(); i++){
			if( getCounter(i).getName().equals(c)){
				return true;
			}
		}
		return false;
	}
	


}
