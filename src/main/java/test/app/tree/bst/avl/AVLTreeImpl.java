/**
 * 
 */
package test.app.tree.bst.avl;

import test.app.tree.Tree;
import test.app.tree.bst.BinarySearchTree;
import test.app.tree.bst.Node;

/**
 * @author Dinesh
 *
 */
public class AVLTreeImpl<T extends Comparable<T>> extends BinarySearchTree<T> implements AVLTree<T>, Tree<T> {

	
	
	protected  Node<T> insert(T data, Node<T> node ) {
		 if( java.util.Objects.isNull(node) )
			 return new Node<>(data);

		 if( data.compareTo(node.getData()) < 0)
			 node.setLeftChild(  insert( data , node.getLeftChild()) );
		 else if ( data.compareTo(node.getData()) > 0 )
			 node.setRightChild( insert( data , node.getRightChild()) );
		 else
			 return node;
		 
		 /* Do Rotations */
		 return applyRotations(node);
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
		 
		 return applyRotations(node);
		
	}
	
	
	
	private Node<T>  applyRotations(Node<T> node) {
		
		int balanceFactor = balanceFactor(node);
		
		if ( balanceFactor > 1 ) { // Left Subtree is taller than right subtree.
			return rotateRight(node);
		} else if ( balanceFactor < -1) {
			return rotateLeft(node);
		}
		
		return node;
	}
	
	private int balanceFactor( Node<T> node ) {
		return java.util.Objects.isNull(node) ? 0 : height(node.getLeftChild()) -  height(node.getRightChild()) ;
	}
	
	
	private int height( Node<T> node ) {
		if( java.util.Objects.isNull(node) )
			 return 0;
		
		return 1 + Math.max( height(node.getLeftChild()), height(node.getRightChild()) );
	}



	@Override
	public Node<T> rotateLeft(Node<T> node) {
		
		Node<T> newParent = node.getRightChild();
		
		if ( balanceFactor(newParent) > 0 ) 
			newParent = rotateRight( newParent );
		
		Node<T> temp      = newParent.getLeftChild();
		
		newParent.setLeftChild(node);
		node.setRightChild(temp);
		
		return newParent;
	}

	@Override
	public Node<T> rotateRight(Node<T> node) {
		
		Node<T> newParent = node.getLeftChild();
		
		if ( balanceFactor(newParent) < 0 ) 
			newParent = rotateLeft( newParent );
		
		Node<T> temp      = newParent.getRightChild();
		
		newParent.setRightChild(node);
		node.setLeftChild(temp);
		
		return newParent;
	}

}
