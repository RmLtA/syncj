

public class ErrorTreatment extends CounterException{
	
	public ErrorTreatment(){
		super("Errors detected ... ");
	}

	public void checkIdent(String expr, int line) throws CounterException{
		if(expr.endsWith("_att")){
			throw new CounterException("Not allowed to use <name>_att outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_act")){
			throw new CounterException("Not allowed to use <name>_act outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_term")){
			throw new CounterException("Not allowed to use <name>_term outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_req")){
			throw new CounterException("Not allowed to use <name>_req outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.endsWith("_aut")){
			throw new CounterException("Not allowed to use <name>_aut outside a condition: rename variable. Line :"+line);
		}
		
		if(expr.contains("notify") || expr.contains("wait")){
			throw new CounterException("You are managing yourself the synchronization. Line :"+line);
		}
		
		
		
		
	}
}
