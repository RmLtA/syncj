
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;
/**
* <b> SYNCJ Project
* The purpose of the SYNCJ project is to develop a solution to facilitate the learning of synchronization tools for 4th year programming students from INSA Rennes. 
* In order to do that, we have implemented the synchronization counters mechanism in JAVA.
*
* @author INSA of Rennes students : Nour Romdhane - Liantsoa Rasata - Mathilde Leparquier - Othmane Kabir - Ibrahim Benali
*/

public class Generation implements Type{
	
	private OutputStream FichierGen ;
	private ArrayList<String> bufferCounter;


	
	public Generation(String file){
		FichierGen=Ecriture.ouvrir(file);
		bufferCounter = new ArrayList<String>(); 


	}
	
	/**
	 * Generate the code to initialize the counters
	 * @param t the table of identifiers
	 * @param identCondition the name of the condition
	 */
	public void declInitCount(TabIdent t, String identCondition){
		int i;
		String counter;
		
		Ident ident = new Ident(identCondition);
		ident = t.searchIdent(identCondition);
		
		for (i=0;i<ident.getsizeTabCounter();i++){	
			counter=ident.getCounter(i).getName();
			if(!bufferCounter.contains(counter)){
				bufferCounter.add(counter);
				writeCounter(counter);
			}
	
		}
		
	}

	/**
	 * Generate the code of the counters
	 * @param counter
	 */
	public void writeCounter(String counter){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,counter);
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n\t");
	}

	

	/**
	 * Concatenation of the boolean expression of a condition 
	 * @param ident the identifier red 
	 * @param exprBool boolean expression
	 * @param notCondition boolean check if it is a part of a condition expression
	 * @param isExprBool boolean check if it is a part of a boolean expression
	 * @return the expression concatenated
	 */
	public String consExprbool(String ident , String exprBool, boolean notCondition, boolean isExprBool){
		if(!notCondition )
	  		rewrite(ident);
		
		if(isExprBool){
			exprBool+=ident+ " ";
		}
			return exprBool;
			
	}
	
	/**
	 * Rewrite identifier which is not a part of a condition
	 * @param ident
	 * @param flag
	 */
	public void rewriteNotCondition(String ident, boolean flag){
		if(!flag) rewrite(ident);
	}
	
	public void rewrite(String ident){
		Ecriture.ecrireString(FichierGen,ident);
	}
	
	public void rewriteInt(int entierLu){
		Ecriture.ecrireInt(FichierGen,entierLu);
	}
	
	/**
	 * Generate the code of the declaration of the methods of the condition
	 * @param method the name of the condition identifier
	 * @param exprBool the boolean expression
	 */
	public void declMethodBool(String method, String exprBool){
		Ecriture.ecrireString(FichierGen,"\tpublic ");
		Ecriture.ecrireString(FichierGen,"boolean ");
		Ecriture.ecrireString(FichierGen,"cond_"+method+"(){\n\t\t");
		Ecriture.ecrireString(FichierGen,"return "+"("+exprBool+")");
		Ecriture.ecrireString(FichierGen,";\n\t}\n");
		
	}

	/**
	 * Generate the code of the first block synchronized before the instructions of the method
	 * @param method the name of the condition identifier
	 * @param t the table of identifiers
	 */
	public void declFirstBlockSynchronized(String method,TabIdent t){
		String counter;
		Ident ident = new Ident(method);
		ident = t.searchIdent(method);
		
		if(t.existCounter(ident.getName()+"_att")){
			update_att_inc(ident.getName());
			counter=ident.getName()+"_att";
			generateNotifyInc(counter,t);
			generateNotifyforEqualN(counter, t);
		}
		
		
		Ecriture.ecrireString(FichierGen,"\n\t\t synchronized(this){ \n\t\t\t");

		if(t.existCounter(ident.getName()+"_req")){
			update_req_inc(ident.getName());
			counter=ident.getName()+"_req";
			generateNotifyInc(counter,t);
			generateNotifyforEqualN(counter, t);
			
		}
		
		
		
		Ecriture.ecrireString(FichierGen,"while(!");
		Ecriture.ecrireString(FichierGen,"cond_"+method+"()){\n\t\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.wait();\n\t\t\t}\n\t\t\t");
		
		if(t.existCounter(ident.getName()+"_aut")){
			update_req_inc(ident.getName());
			counter=ident.getName()+"_aut";
			generateNotifyInc(counter,t);
			generateNotifyforEqualN(counter, t);
		}
		
		if(t.existCounter(ident.getName()+"_att")){
			update_att_dec(ident.getName());
			counter=ident.getName()+"_att";
			generateNotifyDec(counter,t);
			generateNotifyforEqualZero(counter, t);
			generateNotifyforEqualN(counter, t);
		}
		
		
		if(t.existCounter(ident.getName()+"_act")){
			update_act_inc(ident.getName());
			counter=ident.getName()+"_act";
			generateNotifyInc(counter,t);
			generateNotifyforEqualN(counter, t);
		}
		
		Ecriture.ecrireString(FichierGen,"\n\t\t}\n\t\t");
	
		
		
	}

	/**
	 * Generate the code of the second block synchronized after the instructions of the method
	 * @param method the name of the condition identifier
	 * @param t the table of identifiers
	 */
	public void declSecondBlockSynchronized(String method, TabIdent t){
		
		String counter;
		Ident ident = new Ident(method);
		ident = t.searchIdent(method);

		
		Ecriture.ecrireString(FichierGen,"\n\t\tsynchronized(this){ \n\t\t\t");
		if(t.existCounter(ident.getName()+"_term")){
			update_act_inc(ident.getName());
			counter=ident.getName()+"_term";
			generateNotifyInc(counter,t);
			generateNotifyforEqualN(counter, t);
		}
		
		if(t.existCounter(ident.getName()+"_act")){
			update_act_dec(ident.getName());
			counter=ident.getName()+"_act";
			generateNotifyDec(counter,t);
			generateNotifyforEqualZero(counter, t);
			generateNotifyforEqualN(counter, t);
		}
		
		Ecriture.ecrireString(FichierGen,"\n\t\t}");
		
	}
	
	/**
	 * Generate code for throws Exception if it is missing
	 * @param b boolean true if there are others exceptions
	 */	
	public void declThrowsException(boolean b){
		if(b){
			Ecriture.ecrireString(FichierGen,",InterruptedException");
		}else{
			Ecriture.ecrireString(FichierGen," throws InterruptedException");
		}

	}

	/**
	 * Generate code after the incrementation of the counter 
	 * @param counter : the name of the counter 
	 * @param t : the table of identifier
	 */	
	public void generateNotifyInc(String counter, TabIdent t){
		if((t.checkCounter(counter).containType(Type.SUP) && t.checkCounter(counter).getSign() == Sign.PLUS)
				|| (t.checkCounter(counter).containType(Type.SUPEQUAL) && t.checkCounter(counter).getSign() == Sign.PLUS)
				|| (t.checkCounter(counter).containType(Type.INFEQUAL) && t.checkCounter(counter).getSign() == Sign.MINUS)
				|| (t.checkCounter(counter).containType(Type.INF) && t.checkCounter(counter).getSign() == Sign.MINUS)){
			Ecriture.ecrireString(FichierGen,"\tthis.notifyAll();\n\t\t");
		}

	}
	
	
	/**
	 * Generate code after the decrementation of the counter 
	 * @param counter : the name of the counter 
	 * @param t : the table of identifier
	 */	
	public void generateNotifyDec(String counter, TabIdent t){
		if((t.checkCounter(counter).containType(Type.SUP) && t.checkCounter(counter).getSign() == Sign.MINUS)
				|| (t.checkCounter(counter).containType(Type.SUPEQUAL) && t.checkCounter(counter).getSign() == Sign.MINUS)
				|| (t.checkCounter(counter).containType(Type.INFEQUAL) && t.checkCounter(counter).getSign() == Sign.PLUS)
				|| (t.checkCounter(counter).containType(Type.INF) && t.checkCounter(counter).getSign() == Sign.PLUS)){
			Ecriture.ecrireString(FichierGen,"\tthis.notifyAll();\n\t\t");
		}
	}
	
	public void generateNotifyforEqualZero(String counter, TabIdent t){
		if((t.checkCounter(counter).containType(Type.EQUAL) && t.checkCounter(counter).getSign() == Sign.MINUS &&  t.checkCounter(counter).allZeroEquBuffer() == true)
				|| (t.checkCounter(counter).containType(Type.EQUAL) && t.checkCounter(counter).getSign() == Sign.PLUS) &&  t.checkCounter(counter).allZeroEquBuffer() == true){
			Ecriture.ecrireString(FichierGen,"\tthis.notifyAll();\n\t\t");
		}		
	}
	
	public void generateNotifyforEqualN(String counter, TabIdent t){
		if((t.checkCounter(counter).containType(Type.EQUAL) &&  t.checkCounter(counter).allZeroEquBuffer() == false )){
			Ecriture.ecrireString(FichierGen,"\tthis.notifyAll();\n\t\t");
		}		
	}
	
	/**
	 * Increment <name>_act
	 * @param ident : the identifier of a condition
	 */	
	public void update_act_inc(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_act++;\n\t\t");
	}
	
	/**
	 * Decrement <name>_act
	 * @param ident : the identifier of a condition
	 */	
	public void update_act_dec(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_act--;\n\t\t");
	}

	/**
	 * Increment <name>_att
	 * @param ident : the identifier of a condition
	 */
	public void update_att_inc(String ident){
		Ecriture.ecrireString(FichierGen,"\n\t\t"+ident+"_att++;\n\t\t");
	}
	
	/**
	 * Decrement <name>_att
	 * @param ident : the identifier of a condition
	 */
	public void update_att_dec(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_att--;\n\t\t");
	}
	
	/**
	 * Increment <name>_aut
	 * @param ident : the identifier of a condition
	 */
	public void update_aut_inc(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_aut++;\n\t\t");
	}
	
	/**
	 * Decrement <name>_aut
	 * @param ident : the identifier of a condition
	 */
	public void update_aut_dec(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_aut--;\n\t\t");
	}
	
	/**
	 * Increment <name>_req
	 * @param ident : the identifier of a condition
	 */
	public void update_req_inc(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_req++;\n\t\t");
	}
	
	/**
	 * Decrement <name>_term
	 * @param ident : the identifier of a condition
	 */
	public void update_term_dec(String ident){
		Ecriture.ecrireString(FichierGen," "+ident+"_term++;\n\t\t");
	}
	
	/**
	 * Generate "\n\t"
	 */
	
	public void writeTr(){
		Ecriture.ecrireString(FichierGen,"\n\t");
	}
	
	
	
}