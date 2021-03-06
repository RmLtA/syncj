
import java.util.ArrayList;


public class Counter {
	private String name;
	private ArrayList<Integer> listType;
	
	public Counter(String n, ArrayList<Integer> l){
		name=n;
		listType= new ArrayList<Integer>();
		for(int i=0; i<l.size(); i++){
			listType.add(l.get(i));
		}
	}
	
	
	/**
	 * Check if a Type t exists in the arraylist of the counter
	 * @param	int t : Type, refer to interface Type
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
	
	public String getName(){
		return name;
	}
}
