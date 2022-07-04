package test.app.tree.bst.avl;

import test.app.tree.Tree;
import test.app.tree.bst.Node;

public interface AVLTree<T extends Comparable<T>> extends Tree<T> {

	Node<T> rotateLeft( Node<T> node );
	
	Node<T> rotateRight( Node<T> node );
}
