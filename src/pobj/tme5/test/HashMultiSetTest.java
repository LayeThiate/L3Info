package pobj.tme5.test;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;

import pobj.tme5.HashMultiSet;
import pobj.tme5.InvalidCountException;
import pobj.tme5.MultiSet;
import pobj.tme5.MultiSetDecorator;

public class HashMultiSetTest {

	private MultiSet<String> m = null;
	
	@Before
	public void createHash(){
		m = null;
		m = new HashMultiSet<String>();
	}
	@Test
	public void testAdd1() throws InvalidCountException{
		//MultiSet<String> m = new HashMultiSet<>();
		m.add("a");
		m.add("a", 5);
		assertEquals(m.count("a"), 6);
		System.out.println("Succee de add1");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testAdd2() throws InvalidCountException{
		m.add("a");
		m.add("a", -1);
		System.out.println("Succee de add2");
	}
	
	@Test
	public void testRemove1(){
		m.add("a");
		m.remove("a");
		assertTrue(m.isEmpty());
		System.out.println("succee de remove1");
	}
	
	@Test
	public void testRemove2(){
		m.add("a", 3);
		m.remove("a", 2);
		assertEquals(m.count("a"), 1);
		System.out.println("Succee de Remove2");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testRemove3(){
		m.add("a", 4);
		m.remove("a", -1);
	}
	
	@Test
	public void testSize(){
		m.add("a", 4);
		m.add("b");
		assertEquals(m.size(), 5);
		System.out.println("Succee de TestSize");
	}
	
	@Test
	public void testToString(){
		m.add("a", 5);
		m.add("b", 3);
		String res = "[a:5 b:3]";
		assertTrue(res.equals(res));
		System.out.println("succee de testToString");
	}
	
	@Test
	public void testClear(){
		m.add("a", 3);
		m.add("b");
		m.clear();
		assertTrue(m.isEmpty());
		System.out.println("succee de Clear");
	}
}
