package pobj.tme5;

public class InvalidMultiSetFormat extends Exception {
	
	public InvalidMultiSetFormat(){
		super();
	}
	
	public InvalidMultiSetFormat(String s){
		super("pb Format :"+s);
	}

}
