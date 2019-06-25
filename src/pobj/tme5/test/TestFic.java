package pobj.tme5.test;
import pobj.tme5.*;

public class TestFic {

	public static void main(String[] args) {
		
		/*int a = Integer.decode("-12");
		
		if(a<0)
			System.out.println("negatif");
		System.out.println(Integer.decode("-1"));
		try {
			MultiSetParser.parse("fic.txt");
		} catch (InvalidMultiSetFormat e) {
			e.printStackTrace();
		}*/
		
		try {
			MultiSet<String> mult = MultiSetParser.parse("fic1.txt");
			System.out.println(mult.toString());
		} catch (InvalidMultiSetFormat e) {
			e.printStackTrace();
		}
	}
}
