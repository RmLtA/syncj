package PR;



public class Writer extends Thread{
	ReaderWriter rwt;
	public Writer(String name,ReaderWriter rw){
		super(name);
		rwt = rw;
	}
	
	public void run(){
		int i = 0;
		while(true){
			try {
				rwt.write("element "+i);
				i++;
				if(i%40 == 0){
					rwt.displayState();
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
