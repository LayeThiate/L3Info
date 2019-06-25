package pobj.tme4;

import java.util.Collection;
import java.util.List;
import java.util.Spliterator;

public interface MultiSet<T> extends Collection<T> {
	public boolean add(T e, int count);
	public boolean add(T e);
	public boolean remove(Object e);
	public boolean remove(Object e, int count);
	public int count(T o);
	public void clear();	
	public int size();
	public List<T> elements();
	public Spliterator<T> spliterator();
}
