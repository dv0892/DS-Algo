package test.app.tree;

public interface Tree<T extends Comparable<T>> {

	public Tree<T> insert(T data);

	void delete(T data);
	
	T getMax();
	
	T getMin();
	
	boolean isEmpty();
	
	public void traverse();

	
}
