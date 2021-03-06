public class ReaderWriter{
	
	private final int size = 10 ; 
	private string tab[] = new string [size] ;
	private int index_writer=0 ;
	private int index_reader=0 ;

	condition read = (write_act==0) ;
	condition write = (read_act==0 && write_act==0) ;

	public String read() throws TrucException{
		String s = tab[index_reader] ;
		index_reader=( index_reader+1)%size ;
		return s ;
	}
	public void write(String s){
		tab[index_writer]=s ;
		index_writer=( index_writer+1)%size ;
	}
}
