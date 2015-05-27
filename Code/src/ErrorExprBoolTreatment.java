/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
*/
public class ErrorExprBoolTreatment extends ExprBoolException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3995547175039666796L;

	/**
	 * Constructor
	 */
	public ErrorExprBoolTreatment() {
		super("Errors detected ... ");

	}
	/**
	 * Check the syntaxe of the boolean expression in the condition is correct 
	 * @param	int line in the source code
	 */
	public void checkExprBool(int line) throws ExprBoolException{
		throw new ExprBoolException("Boolean expression not allowed. Line :"+line);
	}

}
