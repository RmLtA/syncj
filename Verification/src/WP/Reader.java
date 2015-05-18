package WP;


public class Reader extends Thread {
	private ReaderWriter buf;
	private int identit�;
	
	public Reader(ReaderWriter c, int n) {
		buf = c; 
		this.identit� = n;
	}
	public void run() {
		while(true){
			try {
				System.out.println("Consommateur #" + this.identit� + " lit : " + buf.read());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}

	}
}

