
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
	private int sign;
	private ArrayList<Integer> equalityBuffer;
	
	/**
	 * Constructor
	 * @param	n : name of the counter 
	 * @param 	l : list of Type 
	 */
	
	public Counter(String n, ArrayList<Integer> l){
		name=n;
		listType= new ArrayList<Integer>();
		equalityBuffer = new ArrayList<Integer>();
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
		return listType.contains(t);
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
	
	/**
	 * Return the sign of the counter
	 * @return the sign of the counter
	 */
	public int getSign(){
		return sign;
	}
	
	/**
	 * Set the sign of the counter
	 * @param s sign
	 */
	public void setSign(int s){
		sign = s;
	}

	/**
	 * Return the sign of the buffer for an equality expression
	 * @return the list of number to compared to the counter
	 */
	public ArrayList<Integer> getBufferEq(){
		return equalityBuffer;
	}
	
	/**
	 * Add the number used in an equality expression  for a counter
	 * @param i number
	 */
	public void addEquBuffer(int i){
		equalityBuffer.add(i);
	}
	
	/**
	 * Check if the counter is always compared to zero in an equality expression
	 * @return boolean
	 */
	public boolean allZeroEquBuffer(){
		for(int i=0; i<equalityBuffer.size();i++){

			if(equalityBuffer.get(i)!=0){
				System.out.println("number counter : "+equalityBuffer.get(i));
				return false;
			}
		}
		return true;
	}
	
}
