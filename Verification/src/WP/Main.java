package WP;


public class Main {
	
		public static void main(String[] args) {
		ReaderWriter c = new ReaderWriter();
		
		Reader r1 = new Reader(c, 1);
		Reader r2 = new Reader(c, 2);
		
		Writer w1 = new Writer(c, 1);
		Writer w2 = new Writer(c, 2);
		
		r1.start();r2.start();
		w1.start();w2.start();
		}
		
}

