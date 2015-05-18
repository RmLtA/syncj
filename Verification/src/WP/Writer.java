package WP;


public class Writer extends Thread{
	private ReaderWriter buf;
	private int identité;
	
	public Writer(ReaderWriter c, int n) {
		buf = c;
		this.identité = n;
	}
	
	public void run() {
		while(true){
			try {
				buf.write("message");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Producteur #" + this.identité + " met : " + "message");
			
		}

	}
}

