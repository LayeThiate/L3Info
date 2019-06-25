package pobj.tme5;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class MultiSetDecorator<T> extends AbstractCollection<T> implements MultiSet<T>{
	
	private MultiSet decorated;
	
	public MultiSetDecorator (MultiSet dec){
		decorated = dec;
	}

	public boolean add(T e, int count) {
		boolean toto= decorated.add(e, count);
		assert isConsistent();
		return toto;
	}

	public boolean remove(Object e, int count) {
		boolean toto=decorated.remove(e, count);
		assert isConsistent();
		return toto;
	}

	public int count(T o) {
		return decorated.count(o);
	}

	public List<T> elements() {
		return decorated.elements();
	}

	public Spliterator<T> spliterator() {
		return decorated.spliterator();
	}

	@Override
	public Iterator<T> iterator() {
		return decorated.iterator();
	}

	@Override
	public int size() {
		return decorated.size();
	}
	public boolean isConsistent() {
		return decorated.isConsistent();
		/*
		List<T> list = decorated.elements();
		int cpt = 0;
		for(T t : list){
			int count = decorated.count(t);
			if( count< 0){
				return false;
			}
			else{
				cpt += count;
			}
		}
		if(cpt == size())
			return true;
		return false;*/
	}
	@Override
	public String toString(){
		return decorated.toString();
	}
	@Override
	public boolean isEmpty(){
		return decorated.isEmpty();
	}
}
