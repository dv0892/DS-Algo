package test.app.tree.bst;

import test.app.tree.Tree;

public class BinarySearchTree< T extends Comparable<T> > implements Tree<T> {
	
	protected Node<T> root ;

	@Override
	public Tree<T> insert(T data) {
		root = insert( data, root);
		return this; // This is being done to support chaning 
				
	}

	protected  Node<T> insert(T data, Node<T> node ) {
		 if( java.util.Objects.isNull(node) )
			 return new Node<>(data);
		
		 if( data.compareTo(node.getData()) < 0)
			 node.setLeftChild(  insert( data , node.getLeftChild()) );
		 else if ( data.compareTo(node.getData()) > 0 )
			 node.setRightChild( insert( data , node.getRightChild()) );
		 
		 return node;
		
	}

	@Override
	public void delete(T data) {
		root = delete(data,root);
	}
	
	protected Node<T> delete(T data , Node<T> node ) {
		
		if( java.util.Objects.isNull(node) )
			 return null;
		
		 if( data.compareTo(node.getData()) < 0)
			 node.setLeftChild(  delete( data , node.getLeftChild()) );
		 else if( data.compareTo(node.getData()) > 0)
			 node.setRightChild( delete( data , node.getRightChild()) );
		 else {
			 //Case for only one children
			 if( java.util.Objects.isNull(node.getLeftChild()) )
				 return node.getRightChild();
			 
			 if( java.util.Objects.isNull(node.getRightChild()) )
				 return node.getRightChild();
			 
			 //Two Children
			 // Either we can find Successor ( Min in Right Subtree ) or Predecessor ( max in left subtree ).
			
			 node.setData(getMin(node.getRightChild()));
			 
			 /*
			  * Successor   ( Min in right Subtree ) : won't be having left child; So the below logic just deletes successor from right subtree;
			  * Predecessor ( max in left subtree ) :  won't be having right child;
			  */
			 
			 node.setRightChild( delete( node.getData() , node.getRightChild() ) );
		 }
		 
		 return node;
		
	}

	@Override
	public T getMax() {
		if(isEmpty())
			return null;
		
		return getMax(root);
	}

	protected T getMax(Node<T> node) {
		while( java.util.Objects.nonNull(node.getRightChild()) )
			node = node.getRightChild();
		
		return node.getData();
	}

	@Override
	public T getMin() {
		if(isEmpty())
			return null;
		
		return getMin(root);
	}
	
	protected T getMin(Node<T> node ) {
		while( java.util.Objects.nonNull(node.getLeftChild()) )
			node = node.getLeftChild();
		
		return node.getData();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return java.util.Objects.isNull(root);
	}

	@Override
	public void traverse() {
		traverse(root);
	}

	private void traverse(Node<T> node) {
		if ( java.util.Objects.isNull(node) )
			return;
		
		System.out.print( node );
		traverse(node.getLeftChild());
		traverse(node.getRightChild());
		
	}
	
	
	
	

}
