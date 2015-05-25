
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class Buffer {
	/**
	* Lecteur Redacteur priorit� aux lecteurs 
	*/
	private OutputStream out ;
	condition write = (read_act == 0 && write_act == 0 && read_att == 0);
	condition read = (read_act == 0 && write_act == 0 && read_att == 0);
	    
	public Buffer(String file) throws FileNotFoundException{		
		out=Ecriture.ouvrir(file);	
	}


	public String read() throws InterruptedException, IOException{
		BufferedReader in ;
		in=new BufferedReader(new FileReader("file"));
		String ligne;
		String contenu ="";
		while( (ligne =in.readLine())!= null){
			contenu+=ligne;
		}			
		return contenu;
	}
	
	public void write(String s) throws InterruptedException{
		Ecriture.ecrireString(out,s);
	}
}
