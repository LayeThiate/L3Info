package pobj.tme5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Spliterator;
import java.util.TreeSet;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class NaiveMultiSet<T> implements MultiSet<T> {
	
	private List<T> list ;
	private int size ;
	
	public NaiveMultiSet(){
		list = new ArrayList<T>();
		size = 0;
	}
	
	public NaiveMultiSet(Collection<T> coll){
		list = new ArrayList<T>(coll);
		size = coll.size();
	}
	
	public boolean add(T e, int count) {
		for(int i=0; i<count; i++){
			list.add(e);
			size++;
		}
		return true;
	}

	public boolean add(T e) {
		list.add(e);
		size++;
		return true;
	}

	public boolean remove(Object e) {
		if(list.remove(e))
			size--;
		return true;
	}

	public boolean remove(Object e, int count) {
		for(int i=0; i<count; i++){
			list.remove(e);
			size--;
		}
		return true;
	}

	public int count(T o) {
		int cpt=0;
		for( T t : list){
			if(t.equals(o))
				cpt++;
		}
		return cpt;
	}

	public void clear() {
		list.clear();
		size = 0;
	}

	public int size() {
		return size;
	}

	public List<T> elements() {
		Set<T> tr = new TreeSet<T>(list);
		List<T> l = new ArrayList<T>(tr);
		return l;
	}

	class NaiveMultiSetIterator implements Iterator<T>{
		private int i = 0;
		
		public NaiveMultiSetIterator(){
			i = 0;
		}
		public boolean hasNext() {
			return i<size;
		}

		public T next() {
			if(!hasNext())
				try {
					throw new Exception("pas de next");
				} catch (Exception e) {
					e.printStackTrace();
				}
			T t = list.get(i);
			i++;
			return t;
		}
	}
	
	public boolean isConsistent() {
		return size == list.size();
		/*int cpt = 0;
		Set<T> tmp = new TreeSet<T>(list);
		for(T t : tmp){
			int count = count(t);
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		for(T t : list){
			sb.append(t+":"+count(t)+" ");
		}
		return sb.toString()+"]";
	}
	
	public Iterator<T> iterator() {
		return new NaiveMultiSetIterator();
	}
	public Spliterator<T> spliterator() {
		return null;
	}
	
	public boolean addAll(Collection<? extends T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean contains(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean containsAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	public Stream<T> parallelStream() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean removeIf(Predicate<? super T> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public Stream<T> stream() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public void forEach(Consumer<? super T> arg0) {
		// TODO Auto-generated method stub
		
	}

}