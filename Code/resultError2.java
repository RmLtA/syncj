
public class ReaderWriter{
	private final int size =  ; 
	private string tab[] = new string [size] ;
	private int index_writer= ;
	private int index_reader = ;

	private int write_act= 0;
	public boolean cond_read(){
		return (write_act == 0 );
	}

	private int read_act= 0;
	public boolean cond_write(){
		return (read_act == 0 && write_act == 0 );
	}


	public String read() throws InterruptedException{
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			 read_act++;
		
		}
		
		String s = tab[index_reader] ;
		index_reader=( index_reader+)%size ;
		this.notifyAll();
		
		synchronized(this){ 
			 read_act--;
			this.notifyAll();
		
		}return s ;
	}
	public void write(String s) throws InterruptedException{
		 synchronized(this){ 
			while(!cond_write()){
				this.wait();
			}
			 write_act++;
		
		}
		
		synchronized(this){
			tab[index_writer]=s ;
		
		this.wait();
		index_writer=( index_writer+)%size ;
	}
}