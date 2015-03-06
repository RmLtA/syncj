import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Stack;

public class Generation{
	
	OutputStream FichierGen ;
	
	
	public Generation(){
		FichierGen=Ecriture.ouvrir("gen.java");
	}
	
	public void declInitCompt(TabIdent t, String methode){
		int i;
		String compteur;
		Ident ident = new Ident(methode);
		ident = t.chercheIdent(methode);
		for (i=0;i<ident.getTailleTabParam();i++){
			compteur=ident.getCompteur(i);
			/*condition*/
				ecrireCompt(compteur);
		}
			/*declComptReq(methode);
			Ecriture.ecrireString(FichierGen,"\t");
		
			declComptAut(methode);
			Ecriture.ecrireString(FichierGen,"\t");
		
		
			declComptTerm(methode);
			Ecriture.ecrireString(FichierGen,"\t");
			
			declComptAct(methode);
			Ecriture.ecrireString(FichierGen,"\t");
			
			declComptAtt(methode);
			Ecriture.ecrireString(FichierGen,"\t");*/
		
	}

	
	public void ecrireCompt(String compteur){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,compteur);
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n");
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
	
	public void declComptAct(String methode){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,methode+"_"+"act ");
		Ecriture.ecrireString(FichierGen,"= 0;");
		Ecriture.ecrireString(FichierGen,"\n");
	}
	
	public void declComptAtt(String methode){
		Ecriture.ecrireString(FichierGen,"private ");
		Ecriture.ecrireString(FichierGen,"int ");
		Ecriture.ecrireString(FichierGen,methode+"_"+"att ");
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
	
	public void declSynchronizedAvant(String methode,TabIdent t){
		
		String compteur;
		Ident ident = new Ident(methode);
		ident = t.chercheIdent(methode);
		/*++ seulement si truc_act dans condition, sinon pour les autres compteurs voir les endroits ou il faut faire ++ ou --*/
		
		Ecriture.ecrireString(FichierGen,"\n\t\t synchronized(this){ \n\t\t\t");
		/*Ecriture.ecrireString(FichierGen,methode+"_"+"req++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"att++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		*/
		Ecriture.ecrireString(FichierGen,"while(!");
		Ecriture.ecrireString(FichierGen,"cond_"+methode+"()){\n\t\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.wait();\n\t\t\t\t}\n\t\t\t");
		
		/*
		Ecriture.ecrireString(FichierGen,methode+"_"+"aut++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");
		
		Ecriture.ecrireString(FichierGen,methode+"_"+"att-- ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");*/
		
			compteur=ident.getNom();
			Ecriture.ecrireString(FichierGen,compteur+"_act++ ;\n\t\t\t");
			Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t}\n\t\t");
		
		
	}
	
	public void declSynchronizedApres(String methode, TabIdent t){
		
		String compteur;
		Ident ident = new Ident(methode);
		ident = t.chercheIdent(methode);
		Ecriture.ecrireString(FichierGen,"synchronized(this){ \n\t\t\t");
		/*Ecriture.ecrireString(FichierGen,methode+"_"+"term++ ;\n\t\t\t");
		Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t");*/
		
		
		
			compteur=ident.getNom();
			Ecriture.ecrireString(FichierGen,compteur+"_act-- ;\n\t\t\t");
			Ecriture.ecrireString(FichierGen,"this.notifyAll();\n\t\t\t}\n\t\t}");
		
	}
	
	
	
	
}