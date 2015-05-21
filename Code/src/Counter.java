
import java.util.ArrayList;
/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
* 
*/

public class Counter {
	private String name;
	private ArrayList<Integer> listType;
	
	/**
	 * Constructor
	 * @param	n : name of the counter 
	 * @param 	l : list of Type 
	 */
	
	public Counter(String n, ArrayList<Integer> l){
		name=n;
		listType= new ArrayList<Integer>();
		for(int i=0; i<l.size(); i++){
			listType.add(l.get(i));
		}
	}
	
	
	/**
	 * Check if a Type t exists in the arraylist of the counter
	 * @param	t : Type, refer to interface Type
	 * @return boolean
	 */
	public boolean containType(int t){
		if( this!=null)
			return listType.contains(t);
		else
			return false;
	}
	
	
	/**
	 * Add a type to the counter
	 * @param t : Type, refer to interface Type
	 */
	public void addType(int t){
		listType.add(t);
	}
	
	/**
	 * Return the name of the counter
	 * @return the name of the counter
	 */
	public String getName(){
		return name;
	}
}
