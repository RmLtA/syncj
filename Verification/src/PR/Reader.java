package PR;


public class Reader extends Thread {
	private ReaderWriter rwt;
	public Reader(String name, ReaderWriter rw){
		super(name);
		rwt = rw;
	}
	
	public void run(){
		while(true){
			try {
				rwt.read();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}