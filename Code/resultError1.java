public class ReaderWriter{
	private final int size =  ; 
	private string tab[] = new string [size] ;
	private int index_writer= ;
	private int index_reader = ;

	private int write_xxx= 0;
	public boolean cond_read(){
		return (write_xxx == 0 );
	}

	private int read_act= 0;
	private int write_act= 0;
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
		
		read_act++ ;
		write_act++ ;
		String s = tab[index_reader] ;
		index_reader=( index_reader+)%size ;
		
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
		
		read_act++ ;
		write_act++ ;
		tab[index_writer]=s ;
		index_writer=( index_writer+)%size ;
	
		synchronized(this){ 
			 write_act--;
			this.notifyAll();
		
		}
	}
}