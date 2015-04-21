public class ReaderWriter{
	private final int size = 10 ; 
	private string tab[] = new string [size] ;
	private int index_writer=0 ;
	private int index_reader =0 ;

	private int write_xxx= 0;
	public boolean cond_read(){
		return (write_xxx == 0 );
	}

	private int read_act= 0;
private int write_act= 0;
	public boolean cond_write(){
		return (read_act == 0 && write_act == 0 );
	}


	public String read(){
		 synchronized(this){ 
			while(!cond_read()){
				this.wait();
			}
			read_act++ ;
			
		}
		
		read_act++ ;
		write_act++ ;
		String s = tab[index_reader] ;
		index_reader=( index_reader+1)%size ;
		
		synchronized(this){ 
			read_act-- ;
			this.notifyAll();
		
		}return s ;
	}
	public void write(String s){
		 synchronized(this){ 
			while(!cond_write()){
				this.wait();
			}
			write_act++ ;
			
		}
		
		read_act++ ;
		write_act++ ;
		tab[index_writer]=s ;
		index_writer=( index_writer+1)%size ;
	
		synchronized(this){ 
			write_act-- ;
			this.notifyAll();
		
		}
}
