package test.app.tree.redblack;


import test.app.tree.bst.BinarySearchTree;
import test.app.tree.bst.Node;
import test.app.tree.bst.Node.Color;
import test.app.tree.bst.avl.AVLTreeImpl;
import static test.app.tree.bst.Node.Color.RED;
import static test.app.tree.bst.Node.Color.BLACK;



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
	
	
	protected Node<T> delete(T data , Node<T> node ) { 
		
		
		Node<T> nodeToBeDeleted = findNodeToBeDeleted(data, node);
		 //Case for only one children
		 Color color = nodeToBeDeleted.color;
		 if( java.util.Objects.isNull(nodeToBeDeleted.getLeftChild()) || java.util.Objects.isNull(nodeToBeDeleted.getRightChild()) ) {
			 nodeToBeDeleted = deleteNodesWithZeroOrOneChild( nodeToBeDeleted );
			 
		 } else {
			 Node<T> successor = findSuccessorNode(nodeToBeDeleted.getRightChild()) ;
			 
			 nodeToBeDeleted.setData(successor.getData());
			 
			 nodeToBeDeleted = deleteNodesWithZeroOrOneChild( successor );
			 color = successor.color;
			 
		 }
		 
		 
		 if (color == Color.BLACK) {
			 
			 fixAfterDeletion(nodeToBeDeleted);
			 
			 if ( nodeToBeDeleted.getClass() == NilNode.class) {
				 replaceParentsChild(nodeToBeDeleted, null);
			 }
		 }
		 
		 return root;

	}
	
	private void fixAfterDeletion(Node<T> x) {
        while (x != root && colorOf(x) == BLACK) {
            if (x == leftOf(parentOf(x))) {
            	Node<T> sib = rightOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateLeft(parentOf(x));
                    sib = rightOf(parentOf(x));
                }

                if (colorOf(leftOf(sib))  == BLACK &&
                    colorOf(rightOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(rightOf(sib)) == BLACK) {
                        setColor(leftOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateRight(sib);
                        sib = rightOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(rightOf(sib), BLACK);
                    rotateLeft(parentOf(x));
                    x = root;
                }
            } else { // symmetric
            	Node<T> sib = leftOf(parentOf(x));

                if (colorOf(sib) == RED) {
                    setColor(sib, BLACK);
                    setColor(parentOf(x), RED);
                    rotateRight(parentOf(x));
                    sib = leftOf(parentOf(x));
                }

                if (colorOf(rightOf(sib)) == BLACK &&
                    colorOf(leftOf(sib)) == BLACK) {
                    setColor(sib, RED);
                    x = parentOf(x);
                } else {
                    if (colorOf(leftOf(sib)) == BLACK) {
                        setColor(rightOf(sib), BLACK);
                        setColor(sib, RED);
                        rotateLeft(sib);
                        sib = leftOf(parentOf(x));
                    }
                    setColor(sib, colorOf(parentOf(x)));
                    setColor(parentOf(x), BLACK);
                    setColor(leftOf(sib), BLACK);
                    rotateRight(parentOf(x));
                    x = root;
                }
            }
        }

        setColor(x, BLACK);
    }
	
	private Node<T> parentOf(Node<T> p) {
		// TODO Auto-generated method stub
		 return ( p == null ? null: p.getParent() );
	}
	
	private Node<T> leftOf( Node<T> p) {
        return (p == null) ? null: p.getLeftChild();
    }

    private Node<T> rightOf(Node<T> p) {
        return (p == null) ? null: p.getRightChild();
    }
    
    private Color colorOf(Node<T> p) {
        return (p == null ? BLACK : p.color);
    }

    private void setColor(Node<T> p, Color c) {
        if (p != null)
            p.color = c;
    }

	
	
	

	public Node<T> findNodeToBeDeleted( T data , Node<T> node  ) {
		if( java.util.Objects.isNull(node) )
			 return null;
		 
		 if( data.compareTo(node.getData()) < 0)
			 return findNodeToBeDeleted( data, node.getLeftChild() );
		 else if( data.compareTo(node.getData()) > 0)
			 return findNodeToBeDeleted( data, node.getRightChild() );
		 else
			 return node;
	}

	private Node<T> deleteNodesWithZeroOrOneChild(Node<T> node) {
		
		if( java.util.Objects.isNull(node.getRightChild()) ) {
			replaceParentsChild( node , node.getLeftChild() );
			return node.getLeftChild();
		} else {
			replaceParentsChild( node , node.getRightChild() );
			return node.getRightChild();
		} 	 
	}
	
	static class NilNode <T extends Comparable<T> > extends Node<T>{

		public NilNode(T data) {
			super(data);
			this.color = Color.BLACK;
		}
    	
    }

	private void replaceParentsChild(Node<T> node, Node<T> child) {
		
		if ( java.util.Objects.isNull( node.getParent()) ) {
			root = child;
		} else if ( node.isLeftChild() )
			node.getParent().setLeftChild(child);
		else if ( !node.isLeftChild() )
			node.getParent().setRightChild(child);
		
		if ( java.util.Objects.nonNull(child))
			child.setParent(node.getParent());
		
	}
	
	
	private Node<T> findSuccessorNode(Node<T> node ) {
		while( java.util.Objects.nonNull(node.getLeftChild()) )
			node = node.getLeftChild();
		
		return node;
	}
}
