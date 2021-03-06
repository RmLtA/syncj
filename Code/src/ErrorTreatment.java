

public class ErrorTreatment extends CounterException{
	
	public ErrorTreatment(){
		super();
	}

	public void checkIdent(String expr, int line) throws CounterException{
		if(expr.contains("_att")){
			System.err.println("Not allowed to use <name>_att outside a condition: rename variable. Line :"+line);
			new CounterException();
		}
		
		if(expr.contains("_act")){
			System.err.println("Not allowed to use <name>_act outside a condition: rename variable. Line :"+line);
			new CounterException();
		}
		
		if(expr.contains("_term")){
			System.err.println("Not allowed to use <name>_term outside a condition: rename variable. Line :"+line);
			new CounterException();
		}
		
		if(expr.contains("_req")){
			System.err.println("Not allowed to use <name>_req outside a condition: rename variable. Line :"+line);
			new CounterException();
		}
		
		if(expr.contains("_aut")){
			System.err.println("Not allowed to use <name>_aut outside a condition: rename variable. Line :"+line);
			new CounterException();
		}
		
		if(expr.contains("notify") || expr.contains("wait")){
			System.err.println("WARNING : you are managing yourself the synchronization. Line :"+line);
			new CounterException();
		}
		
		
		
		
	}
}
