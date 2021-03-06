package PR;

public class ReaderWriter{
	/*priorit� reader*/
	private final static int size = 10 ; 
	public static String tab[] = new String [size] ;
	public static int index_writer=0 ;
	public static int index_reader =0 ;

	private int write_act= 0;
	public boolean cond_read(){
		return (write_act == 0 );
	}

	private int read_act= 0;
	private int read_att= 0;
	public boolean cond_write(){
		return (read_act == 0 && write_act == 0 && read_att == 0 );
	}
	
	public ReaderWriter(){
		
	}

	public String read() throws InterruptedException{
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			read_act++ ;
			
		}
		
		String s = tab[index_reader] ;
		index_reader=( index_reader+1)%size ;
		
		synchronized(this){ 
			read_act-- ;
			this.notifyAll();
		
		}return s ;
	}
	
	public void write(String s) throws InterruptedException{
		 synchronized(this){ 
			while(!cond_write()){
				this.wait();
			}
			write_act++ ;
			
		}
		
		tab[index_writer]=s ;
		index_writer=( index_writer+1)%size ;
	
		synchronized(this){ 
			write_act-- ;
			this.notifyAll();
		
		}
	}
	
	public void displayState(){
		System.out.println("Index writer : "+index_writer);
		System.out.println("Index reader : "+index_reader);
		for(int i = 0; i<tab.length; i++){
			System.out.println("index "+i+": "+tab[i]);
		}
		
	}
	
	public static void main(String args[]){
		ReaderWriter rw = new ReaderWriter();
		Reader r = new Reader("Read", rw);
		Writer w = new Writer("Write", rw);
		w.start();
		r.start();
		
		
	}
}
