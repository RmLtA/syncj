import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Generation{
	
	OutputStream FichierGen ;
	
	
	public Generation(){
		FichierGen=Ecriture.ouvrir("gen2.java");
	}
	
	public void declInitCompt(String methode){
		
			declComptReq(methode);
			Ecriture.ecrireString(FichierGen,"\t");
		
		
			declComptAut(methode);
			Ecriture.ecrireString(FichierGen,"\t");
		
		
			declComptTerm(methode);
			Ecriture.ecrireString(FichierGen,"\t");
		
		
	}
	
	public void declComptReq(String methode){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,methode+"_"+"req ");
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n");
	}
	
	public void declComptAut(String methode){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,methode+"_"+"aut ");
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n");
	}
	
	public void declComptTerm(String methode){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,methode+"_"+"term ");
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n");
	}
	
	public String consExprbool(String identLu, String exprBool, boolean notCondition, boolean isExprBool){
		if(!notCondition )
	  		recopier(identLu);
		
		if(isExprBool){
			exprBool+=identLu+ " ";
		}
			return exprBool;
			
	}
	
	public void recopierNotCondition(String identLu, boolean flag){
		if(!flag) recopier(identLu);
	}
	
	public void recopier(String identLu){
		Ecriture.ecrireString(FichierGen,identLu);
	}
	
	public void recopierInt(int entierLu){
		Ecriture.ecrireInt(FichierGen,entierLu);
	}
	
	public void declMethodeBool(String methode, String exprBool){
		Ecriture.ecrireString(FichierGen,"public ");
		Ecriture.ecrireString(FichierGen,"boolean ");
		Ecriture.ecrireString(FichierGen,"cond_"+methode+"(){\n\t\t");
		Ecriture.ecrireString(FichierGen,"return "+"("+exprBool+")");
		Ecriture.ecrireString(FichierGen,";\n\t}\n");
		
	}
	
	public void declSynchronizedAvant(String methode){
		Ecriture.ecrireString(FichierGen,"\n\t\t synchronized(this){ \n\t\t\t");
		Ecriture.ecrireString(FichierGen,methode+"_"+"req++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"att++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,"while(!");
		Ecriture.ecrireString(FichierGen,"cond_"+methode+"()){\n\t\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.wait();\n\t\t\t\t}\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"aut++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"att-- ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"act++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t}\n\t\t");
	}
	
	public void declSynchronizedApres(String methode){
		Ecriture.ecrireString(FichierGen,"synchronized(this){ \n\t\t\t");
		Ecriture.ecrireString(FichierGen,methode+"_"+"term++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"act-- ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t}\n\t\t}");
	}
	
	
	
	
}