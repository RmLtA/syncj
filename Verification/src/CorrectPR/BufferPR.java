package CorrectPR;


public class BufferPR {
	/**
	* Lecteur Redacteur priorité au lecteur
	*/
		private final int size = 10 ; 
		private String tab[] = new String [size] ;
		private int index_writer=0 ;
		private int index_reader =0 ;
		private int write_act= 0;
		
		public boolean cond_read(){
			return (write_act == 0 );
		}

		private int read_act= 0;
		private int read_att= 0;
		
		public boolean cond_write(){
			return (read_act == 0 && write_act == 0 && read_att == 0 );
		}


		public String read() throws InterruptedException{
			 synchronized(this){ 
				 //  read_att ++;
				 while(!cond_read()){
					this.wait();
				}
				 //read_att--;
				read_act++ ;	
			}
			
			String s = tab[index_reader] ;
			index_reader=( index_reader+1)%size ;
			
			synchronized(this){ 
				read_act-- ;
				this.notifyAll();
			}
			return s ;
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
	
}

