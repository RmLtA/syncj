public class ReaderWriter{
	private final int size = 10 ; 
	private string tab[] = new string [size] ;
	private int index_writer=0 ;
	private int index_reader =0 ;

	condition read = (write_act==0) ;
	condition write = (read_act==0 && write_act==0) ;

	public String read(){
		read_act++ ;
		write_act++ ;
		String s = tab[index_reader] ;
		index_reader=( index_reader+1)%size ;
		this.notifyAll();
		return s ;
	}
	public void write(String s){
		synchronized(this){
		read_act++ ;
		write_act++ ;
		}
		tab[index_writer]=s ;
		this.wait();
		index_writer=( index_writer+1)%size ;
	}
}