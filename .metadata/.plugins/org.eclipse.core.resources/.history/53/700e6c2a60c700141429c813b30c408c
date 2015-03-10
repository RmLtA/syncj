import java.io.OutputStream;


public class Optimisation {
	
OutputStream FichierGen ;
	
	
	public Optimisation(){
		FichierGen=Ecriture.ouvrir("opt.java");
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

}
