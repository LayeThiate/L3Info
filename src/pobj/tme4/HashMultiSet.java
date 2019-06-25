package pobj.tme4;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.Spliterator;
import java.util.TreeSet;
/**
 * 
 * @author 3504824
 *
 * @param <T>
 */
public class HashMultiSet<T> extends AbstractCollection<T> implements MultiSet<T>, Iterable<T> {
	Map<T, Integer> hashT ;
	int size ;
	/**
	 * 
	 */
	public HashMultiSet(){
		hashT = new HashMap<T, Integer>();
		size = 0;
	}
	/**
	 * 
	 * @param coll
	 */
	public HashMultiSet(Collection<T> coll){
		hashT = new HashMap<T, Integer>();
		for(T t : coll){
			if(hashT.get(t) == null)
				add(t);
			else
				add(t, 1);		
		}
		size = coll.size();
	}
	/**
	 * 
	 */
	public boolean add(T e, int count) {
		Integer val = hashT.get(e);
		if(val == null){
			add(e);
			return true;
		}
		else{
			hashT.put(e, val+count);
			size += count;
			return true;
		}
	}
	/**
	 * 
	 */
	public boolean add(T e) {
		hashT.put(e, 1);
		size++;
		return true;
	}
	/**
	 * 
	 */
	public boolean remove(Object e) {
		Integer val = hashT.get(e);
		if(val == null)
			return false;
		hashT.remove(e);
		size--;
		return true;
	}
	/**
	 * 
	 */
	public boolean remove(Object e, int count) {
		Integer val = hashT.get(e);
		if(val == null)
			return false;
		if(val == 1)
			return remove(e);
		T obj = (T)e;
		hashT.put(obj, val-count);
		size -= count;
		return true;
	}
	/**
	 * 
	 */
	public int count(Object o) {
		Integer nbOcc = hashT.get((T)o);
		if(nbOcc == null)
			return 0;
		return nbOcc;
	}
	/**
	 * 
	 */
	public void clear() {
		hashT.clear();
		size = 0;
	}
	/**
	 * 
	 */
	public int size() {
		return size;
	}
	/**
	 * representant un iterateur de HashMultiSet
	 * @author 3504824
	 *
	 */
	class HashMultiIterator implements Iterator<T> {

		private Iterator<Entry<T, Integer>> setH;
		private int c = 0;
		private T t = null;
		public HashMultiIterator(){
			setH = hashT.entrySet().iterator();
		}

		public boolean hasNext() {
			return setH.hasNext();
		}
		/*renvoie la cle suivante*/
		public T next() {
			/*Si le nombre d'occ de la cle T est null*/
			if(c == 0){
				/*passer a la cle suivante*/
				Entry<T, Integer> e = setH.next();
				t = e.getKey();
				c = e.getValue();
			}
			c--;
			return t;
		}
	}

	public Iterator<T> iterator() {
		return new HashMultiIterator();
	}

	public Spliterator<T> spliterator() {
        return (Spliterator<T>) super.spliterator();
    }
	/**
	 * retournant la liste des cle sans doublons
	 */
	public List<T> elements(){
		Set<T> tr = new TreeSet<T>();
		tr = hashT.keySet();
		List<T> l = new ArrayList<T>(tr);
		return l;
	}

	public String toString(){
		StringBuilder sb = new StringBuilder("[");
		Iterator<Entry<T, Integer>> it = hashT.entrySet().iterator();
		while(it.hasNext()){
			Entry<T, Integer> e = it.next();
			sb.append(e.getKey()+":"+e.getValue()+" ");
		}
		sb.append("]");
		return sb.toString();
	}

}
