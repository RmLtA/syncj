import java.io.OutputStream;
import java.util.Stack;

public class DeclarationCompt{
	
	OutputStream FichierGen ;
	
	public DeclarationCompt(){
		FichierGen=Ecriture.ouvrir("gen.java");
	}
	
	public void declCompt(String methode){
		declComptReq(methode);
		Ecriture.ecrireString(FichierGen,"\t");
		declComptAut(methode);
		Ecriture.ecrireString(FichierGen,"\t");
		declComptTerm(methode);
		
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
	
	public void recopier(String identLu){
		Ecriture.ecrireString(FichierGen,identLu);
	}
	
	public void recopierInt(int entierLu){
		Ecriture.ecrireInt(FichierGen,entierLu);
	}
	
	public void declMethodeBool(String methode, String exprBool){
		Ecriture.ecrireString(FichierGen,"public ");
		Ecriture.ecrireString(FichierGen,"boolean ");
		Ecriture.ecrireString(FichierGen,"cond_"+methode+"(){\n\t");
		Ecriture.ecrireString(FichierGen,"return "+exprBool);
		Ecriture.ecrireString(FichierGen,";\n}\n");
	}
	
	
	
	
}