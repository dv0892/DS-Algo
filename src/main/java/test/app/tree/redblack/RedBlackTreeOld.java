package test.app.tree.redblack;

import static test.app.tree.bst.Node.Color.RED;

import test.app.tree.bst.BinarySearchTree;
import test.app.tree.bst.Node;
import test.app.tree.bst.Node.Color;

public class RedBlackTreeOld< T extends Comparable<T>  > extends BinarySearchTree<T>{

	protected  Node<T> insert(T data, Node<T> node ) {
		Node<T> nodeToBeInserted  = new Node<>(data);
		root = insert(nodeToBeInserted, node);
		fixRedBlackPropertiesAfterInsert( nodeToBeInserted );
		root.color = Color.BLACK;
		
		return root;
	}
	
	private void fixRedBlackPropertiesAfterInsert( Node<T> insertedNode) {
		
		if ( java.util.Objects.nonNull(insertedNode.getParent()) && RED == insertedNode.getParent().color  ) {
			
			Node<T> parent = insertedNode.getParent();
			Node<T> grandParent = parent.getParent();
			// Case for Left Parent ( When Parent is left child of GrandParent ) 
			if ( parent == grandParent.getLeftChild()) {
				//case 1 
				if ( java.util.Objects.nonNull(grandParent.getRightChild()) && grandParent.getRightChild().color == RED ) {
					parent.flipColor();
					grandParent.flipColor();
					grandParent.getRightChild().flipColor();
					
					fixRedBlackPropertiesAfterInsert( grandParent );
				} else {
					if(  parent.getRightChild() == insertedNode ) {
						// Do Left rotation on Parent
						rotateLeft(parent);
					}
					grandParent.flipColor();
					grandParent.getLeftChild().flipColor();
					/* Right Rotation Required on grandparent because sequence is R - R - B - B
					// Parent will become this subtree's root           B               B
					                                                   / \             / \
					                                                  R   B           R   R
					                                                 /                     \
					                                                R                       B
                    * 
                    * 
                    */
					
					rotateRight( grandParent );
				}
			} else {
				// Case for Right Parent ( When Parent is right child of GrandParent )
				
				//case 1 
				if ( java.util.Objects.nonNull(grandParent.getLeftChild()) && grandParent.getLeftChild().color == RED ) {
					parent.flipColor();
					grandParent.flipColor();
					grandParent.getLeftChild().flipColor();
					
					fixRedBlackPropertiesAfterInsert( grandParent );
				} else {
					if( parent.getLeftChild() == insertedNode ) {
						// Do Right rotation on Parent
						rotateRight(parent);
					}
					grandParent.flipColor();
					grandParent.getRightChild().flipColor();
					/* Left Rotation Required on grandparent because sequence is R - R - B - B
					// Parent will become this subtree's root           B               B
					                                                   / \             / \
					                                                  R   B           R   R
					                                                 /                     \
					                                                R                       B
                    * 
                    * 
                    */
					
					rotateLeft( grandParent );
				}
			
			}
		} 
		
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
	
	
	public Node<T> rotateRight(Node<T> node) {
		
		Node<T> newParent = node.getLeftChild();
		newParent.setParent(node.getParent());
		if ( java.util.Objects.nonNull(node.getParent())) {
			if ( java.util.Objects.nonNull(node.getParent().getLeftChild()) && node == node.getParent().getLeftChild()) {
				node.getParent().setLeftChild(newParent);
			} else {
				node.getParent().setRightChild(newParent);
			}
		} else {
			root = newParent;
		}
		
		
		node.setLeftChild(newParent.getRightChild());
		if (node.getLeftChild() != null) {
            node.getLeftChild().setParent(node);
        }
		
		newParent.setRightChild(node);
		
		node.setParent(newParent);
		
		return newParent;
	}
	
	
	public Node<T> rotateLeft(Node<T> node) {
		
		Node<T> newParent = node.getRightChild();
		newParent.setParent(node.getParent());
		if ( java.util.Objects.nonNull(node.getParent()) ) {
			
			if ( java.util.Objects.nonNull(node.getParent().getLeftChild()) && node == node.getParent().getLeftChild() ) {
				node.getParent().setLeftChild(newParent);
			} else {
				node.getParent().setRightChild(newParent);
			}
			 
		} else {
			root = newParent;
		}
		
		node.setRightChild(newParent.getLeftChild());
		if (node.getRightChild() != null) {
            node.getRightChild().setParent(node);
        }
		
		newParent.setLeftChild(node);
		node.setParent(newParent);
		
		return newParent;
	}

}
