
public class ErrorExprBoolTreatment extends ExprBoolException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3995547175039666796L;

	public ErrorExprBoolTreatment() {
		super("Errors detected ... ");

	}

	public void checkExprBool(int op, int line) throws ExprBoolException{
		throw new ExprBoolException("Boolean expression not allowed. Line :"+line);
	}

}
