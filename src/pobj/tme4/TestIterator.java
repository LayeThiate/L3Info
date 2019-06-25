package pobj.tme4;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class TestIterator {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> l = new ArrayList<String>();
		l.add("abc");
		l.add("ab");
		l.add("def");
		l.add("abc");
		l.add("ab");
		l.add("abc");
		l.add("abc");
		int i = 0;
		
		/*System.out.println("hguh    "+l.get(++i));
		HashMultiSet<String> has = new HashMultiSet<String>(l);
		System.out.println(has.size);
		System.out.println(has.count("ab"));
		System.out.println(has.count("abc"));
		System.out.println(has.count("def"));

		Iterator<String> it = has.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
		
		List<String> hs = has.elements();
		System.out.println(hs);*/
		
		
		NaiveMultiSet<String> nms = new NaiveMultiSet<String>(l);
		System.out.println(nms.size());
		Iterator<String> it = nms.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

}
