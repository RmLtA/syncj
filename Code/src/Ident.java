
import java.util.ArrayList;


public class Ident {
	public String name;
	public String booleanExpression;
	public ArrayList<Counter> counter;
	
	public Ident(String n){
		this.name=n;
		booleanExpression="";
		counter = new ArrayList<Counter>();
	}
	
	public String getName(){
		return name;
	}
	
	public String getExprBool(){
		return booleanExpression;
	}
	
	public void setExprBool(String e){
		booleanExpression = e;
	}
	
	public void addCompteur(Counter c){
		counter.add(c);
	}
	
	public Counter getCounter(int i){
		return counter.get(i);
	}

	public int getsizeTabCounter(){
		return counter.size();
	}
	


}
