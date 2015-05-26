/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
*/

public class ErrorCounterTreatment extends CounterException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1661669936303298202L;

	public ErrorCounterTreatment(){
		super("Errors detected ... ");
	}

	/**
	 * Check the syntaxe of the identifier 
	 * @param	String expr : the identifier
	 * @param	int line : the line in the source code
	 */
	public void checkIdent(String expr, int line) throws CounterException{
		if(expr.endsWith("_att")){
			System.err.println("Not allowed to use <name>_att outside a condition: rename variable. Line :"+line);
			throw new CounterException("Not allowed to use <name>_att outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_act")){
			System.err.println("Not allowed to use <name>_act outside a condition: rename variable. Line :"+line);
			throw new CounterException("Not allowed to use <name>_act outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_term")){
			System.err.println("Not allowed to use <name>_term outside a condition: rename variable. Line :"+line);
			throw new CounterException("Not allowed to use <name>_term outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_req")){
			System.err.println("Not allowed to use <name>_req outside a condition: rename variable. Line :"+line);
			throw new CounterException("Not allowed to use <name>_req outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_aut")){
			System.err.println("Not allowed to use <name>_aut outside a condition: rename variable. Line :"+line);
			throw new CounterException("Not allowed to use <name>_aut outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.contains("notify") || expr.contains("wait") || expr.contains("synchronized") ){
			System.err.println("You are managing yourself the synchronization. Line :"+line);
			throw new CounterException("You are managing yourself the synchronization. Line :"+line);
		}
		
		
	}
	

}
