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

	Node<T> root ;
	
	private  Node<T> insert(T data, Node<T> node ) {
		 if( java.util.Objects.isNull(node) )
			 return new Node<>(data);
		
		 if( data.compareTo(node.getData()) < 0)
			 node.setLeftChild(  insert( data , node.getLeftChild()) );
		 else if ( data.compareTo(node.getData()) > 0 )
			 node.setRightChild( insert( data , node.getRightChild()) );
		 else {
			  return node;
		 }
					 
		return node;
		
	}
	
	@Override
	public Node<T> rotateLeft(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Node<T> rotateRight(Node<T> node) {
		// TODO Auto-generated method stub
		return null;
	}

}
