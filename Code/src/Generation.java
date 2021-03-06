
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;
/**
 * 
 * @author 
 * Handle the code generation 
 */
public class Generation implements Type{
	
	private OutputStream FichierGen ;
	private ArrayList<String> buffer;
	
	public Generation(String file){
		FichierGen=Ecriture.ouvrir(file);
		buffer = new ArrayList<String>(); 
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
			if(!buffer.contains(counter)){
				buffer.add(counter);
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
	
	public void writeTr(){
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
		counter=ident.getName()+"_act";
		
		Ecriture.ecrireString(FichierGen,"\n\t\t synchronized(this){ \n\t\t\t");
		Ecriture.ecrireString(FichierGen,"while(!");
		Ecriture.ecrireString(FichierGen,"cond_"+method+"()){\n\t\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.wait();\n\t\t\t}\n\t\t\t");
		Ecriture.ecrireString(FichierGen,counter+"++ ;\n\t\t\t");
			
		if(t.checkCounter(counter).containType(Type.SUP)||
		   t.checkCounter(counter).containType(Type.SUPEQUAL)){
				Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t}\n\t\t");
			}else{
				Ecriture.ecrireString(FichierGen,"\n\t\t}\n\t\t");
			}
		
		
	}

	/**
	 * Generate the code of the second block synchronized after the instructions of the method
	 * @param method the name of the condition identifier
	 * @param t the table of identifiers
	 */
	public void declSecondBlockSynchronized(String method, TabIdent t){
		
		String compteur;
		Ident ident = new Ident(method);
		ident = t.searchIdent(method);
		compteur=ident.getName()+"_act";
		
		Ecriture.ecrireString(FichierGen,"\n\t\tsynchronized(this){ \n\t\t\t");
		Ecriture.ecrireString(FichierGen,compteur+"-- ;\n\t\t\t");
		
		if(t.checkCounter(compteur).containType(Type.EQUAL) || 
		   t.checkCounter(compteur).containType(Type.INF)   || 
		   t.checkCounter(compteur).containType(Type.INFEQUAL)){
			Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t");
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
	
	
	
	
	
}