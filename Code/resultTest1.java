
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class Buffer {
	
	private OutputStream out ;
	String file;
	
	private int read_act= 0;
	public boolean cond_write(){
		return (read_act == 0 );
	}

	private int write_act= 0;
	public boolean cond_read(){
		return (- write_act == 0 );
	}

	    
	public Buffer(String file) throws FileNotFoundException{
		this.file=file;
		out=Ecriture.ouvrir(file);		
	
	}
		
	public String read() throws IOException,InterruptedException{
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			 read_act++;
		
		}
		
		BufferedReader in ;
		in=new BufferedReader(new FileReader(file));
		String ligne;
		String contenu =;
		while( (ligne =in.readLine())!= null){
			contenu+=ligne;
		
	}			
		
		synchronized(this){ 
			 read_act--;
			this.notifyAll();
		
		}return contenu;
	
	}
		
	public void write(String s) throws InterruptedException{
		 synchronized(this){ 
			while(!cond_write()){
				this.wait();
			}
			 write_act++;
			this.notifyAll();
		
		}
		
		Ecriture.ecrireString(out,s);
	
		synchronized(this){ 
			 write_act--;
			this.notifyAll();
		
		}
		
	}

	}
