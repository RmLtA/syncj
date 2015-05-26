
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class Buffer {
	
	private OutputStream out ;
	private int read_act= 0;
	private int write_act= 0;
	private int read_att= 0;
		public boolean cond_write(){
		return (read_act == 0 && write_act == 0 && read_att == 0 );
	}

		public boolean cond_read(){
		return (read_act == 0 && write_act == 0 && read_att == 0 );
	}

	    
	public Buffer(String file) throws FileNotFoundException{		
		out=Ecriture.ouvrir(file);	
	}


	public String read() throws InterruptedException, IOException,InterruptedException{
		read_att++;
		
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			 read_att--;
			this.notifyAll();
		 read_act++;
		
		}
		
		BufferedReader in ;
		in=new BufferedReader(new FileReader());
		String ligne;
		String contenu =;
		while( (ligne =in.readLine())!= null){
			contenu+=ligne;
					
		
		synchronized(this){ 
			 read_act--;
			this.notifyAll();
		
		}return contenu;
	}
	
	public void write(String s) throws InterruptedException,InterruptedException{
		 synchronized(this){ 
			while(!cond_write()){
				this.wait();
			}
			 write_act++;
		
		}
		
		Ecriture.ecrireString(out,s);
	
		synchronized(this){ 
			 write_act--;
			this.notifyAll();
		
		}
	}
}