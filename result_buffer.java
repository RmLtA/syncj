
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;


public class Buffer {
	/**/**
/**
	/**
	*/**
	* /**
	* L/**
	* Le/**
	* Lec/**
	* Lect/**
	* Lecte/**
	* Lecteu/**
	* Lecteur/**
	* Lecteur /**
	* Lecteur R/**
	* Lecteur Re/**
	* Lecteur Red/**
	* Lecteur Reda/**
	* Lecteur Redac/**
	* Lecteur Redact/**
	* Lecteur Redacte/**
	* Lecteur Redacteu/**
	* Lecteur Redacteur/**
	* Lecteur Redacteur /**
	* Lecteur Redacteur s/**
	* Lecteur Redacteur sa/**
	* Lecteur Redacteur san/**
	* Lecteur Redacteur sans/**
	* Lecteur Redacteur sans /**
	* Lecteur Redacteur sans p/**
	* Lecteur Redacteur sans pr/**
	* Lecteur Redacteur sans pri/**
	* Lecteur Redacteur sans prio/**
	* Lecteur Redacteur sans prior/**
	* Lecteur Redacteur sans priori/**
	* Lecteur Redacteur sans priorit/**
	* Lecteur Redacteur sans priorit�/**
	* Lecteur Redacteur sans priorité/**
	* Lecteur Redacteur sans priorité/**
	* Lecteur Redacteur sans priorité
/**
	* Lecteur Redacteur sans priorité
	/**
	* Lecteur Redacteur sans priorité
	*/
	private OutputStream out ;
	String file;
	    
	private int read_act= 0;
	private int write_act= 0;
		public boolean cond_read(){
		return (read_act == 0 && write_act == 0 );
	}

		public boolean cond_write(){
		return (read_act == 0 && write_act == 0 );
	}

		public Buffer(String file) throws FileNotFoundException{
			this.file=file;
			out=Ecriture.ouvrir(file);
			
		}
		


		public String read() throws InterruptedException, IOException,InterruptedException{
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			 read_act++;
			this.notifyAll();
		
		}
		
			 BufferedReader in ;
			in=new BufferedReader(new FileReader(file));
			String ligne;
			String contenu ="";
			while( (ligne =in.readLine())!= null){
		/* synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			 read_act++;
			this.notifyAll();
		
		}*/
		
				contenu+=ligne;
			
		/*synchronized(this){ 
			 read_act--;
			this.notifyAll();
			
		}*/
	}
		/*ICI : synchronized(this){ 
			 read_act--;
			this.notifyAll();
			
		}*/
			return contenu;
		}
		
		public void write(String s) throws InterruptedException,InterruptedException{
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
