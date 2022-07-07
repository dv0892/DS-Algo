package test.app.tree.redblack;


import test.app.tree.bst.BinarySearchTree;
import test.app.tree.bst.Node;
import test.app.tree.bst.Node.Color;
import test.app.tree.bst.avl.AVLTreeImpl;
import static test.app.tree.bst.Node.Color.RED;;

public class RedBlackTree< T extends Comparable<T> > extends BinarySearchTree<T> {

	
	protected  Node<T> insert(T data, Node<T> node ) {
		Node<T> nodeToBeInserted  = new Node<>(data);
		root = insert(nodeToBeInserted, node);
		fixRedBlackProperties( nodeToBeInserted );
		root.color = Color.BLACK;
		
		return root;
	}
	
	protected  Node<T> insert(Node<T> nodeToBeInserted, Node<T> node ) {
		 if( java.util.Objects.isNull(node) )
			 return nodeToBeInserted;
		
		 if( nodeToBeInserted.getData().compareTo(node.getData()) < 0) {
			 node.setLeftChild(  insert( nodeToBeInserted , node.getLeftChild()) );
			 node.getLeftChild().setParent(node);
		 } else if ( nodeToBeInserted.getData().compareTo(node.getData()) > 0 ) {
			 node.setRightChild( insert( nodeToBeInserted , node.getRightChild()) );
			 node.getRightChild().setParent(node);
		 }
		 
		 return node;
	}
	
	private void fixRedBlackProperties( Node<T> insertedNode) {
		
		if ( java.util.Objects.nonNull(insertedNode.getParent()) && RED == insertedNode.getParent().color  ) {
			
			Node<T> parent      = insertedNode.getParent();
			Node<T> grandParent = parent.getParent();
			Node<T> uncle       = parent.isLeftChild() ? grandParent.getRightChild() : grandParent.getLeftChild();
			// Combining Case 1 and 4 
			
			
			if ( java.util.Objects.nonNull(uncle) && uncle.color == RED ) { 
				recolorNodes( parent , uncle , grandParent );
			} else if ( parent.isLeftChild() ) {
				handleLeftHeavySituation( insertedNode , parent , grandParent );
			} else if ( !parent.isLeftChild() ) {
				handleRightHeavySituation( insertedNode , parent , grandParent );
			}
		
		} 
		
	}

	private void handleRightHeavySituation(Node<T> insertedNode, Node<T> parent, Node<T> grandParent) {
		if ( insertedNode.isLeftChild() )
			rotateRight(parent);
		
		grandParent.flipColor();
		parent.flipColor();
		rotateLeft( grandParent );
	}

	private void handleLeftHeavySituation(Node<T> insertedNode, Node<T> parent, Node<T> grandParent) {
		if ( !insertedNode.isLeftChild() )
			rotateLeft(parent);
		
		grandParent.flipColor();
		parent.flipColor();
		rotateRight( grandParent );
	}

	private void recolorNodes(Node<T> parent, Node<T> uncle, Node<T> grandParent) {
		parent.flipColor();
		uncle.flipColor();
		grandParent.flipColor();
		fixRedBlackProperties(grandParent);
	}

	public Node<T> rotateRight(Node<T> grandParent) {
		
		// Since we are rotating right, parent will take the place of grandParent.
		Node<T> parent = grandParent.getLeftChild();
		parent.setParent(grandParent.getParent());
		if ( java.util.Objects.nonNull(grandParent.getParent())) {
			if ( java.util.Objects.nonNull(grandParent.getParent().getLeftChild()) && grandParent == grandParent.getParent().getLeftChild()) {
				grandParent.getParent().setLeftChild(parent);
			} else {
				grandParent.getParent().setRightChild(parent);
			}
		} else {
			root = parent;
		}
		
		
		grandParent.setLeftChild(parent.getRightChild());
		if (grandParent.getLeftChild() != null) {
            grandParent.getLeftChild().setParent(grandParent);
        }
		
		parent.setRightChild(grandParent);
		grandParent.setParent(parent);
		
		return parent;
	}
	
	
	public Node<T> rotateLeft(Node<T> grandParent) {
		
		Node<T> parent = grandParent.getRightChild();
		parent.setParent(grandParent.getParent());
		if ( java.util.Objects.nonNull(grandParent.getParent()) ) {
			
			if ( java.util.Objects.nonNull(grandParent.getParent().getLeftChild()) && grandParent == grandParent.getParent().getLeftChild() ) {
				grandParent.getParent().setLeftChild(parent);
			} else {
				grandParent.getParent().setRightChild(parent);
			}
			 
		} else {
			root = parent;
		}
		
		grandParent.setRightChild(parent.getLeftChild());
		if (grandParent.getRightChild() != null) {
            grandParent.getRightChild().setParent(grandParent);
        }
		
		parent.setLeftChild(grandParent);
		grandParent.setParent(parent);
		
		return parent;
	}
	
}
