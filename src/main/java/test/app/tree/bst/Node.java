package test.app.tree.bst;

    public class Node <T extends Comparable<T> > {
	
		T data ;
		public Color color = Color.RED;
		
		
		Node<T> leftChild;
		Node<T> rightChild;
		Node<T> parent;
		
		public Node( T data ){
			this.data = data;
		}
		
		public boolean isLeftChild() {
			return this == parent.getLeftChild() ;
		}
		
		public T getData() {
			return data;
		}
		public void setData(T data) {
			this.data = data;
		}
		public Node<T> getLeftChild() {
			return leftChild;
		}
		public void setLeftChild(Node<T> leftChild) {
			this.leftChild = leftChild;
		}
		public Node<T> getRightChild() {
			return rightChild;
		}
		public void setRightChild(Node<T> rightChild) {
			this.rightChild = rightChild;
		}
		
		public Node<T> getParent() {
			return parent;
		}

		public void setParent(Node<T> parent) {
			this.parent = parent;
		}

		public String toString() {
			return data.toString() + " ";
		}
		
		public void flipColor() {
	        this.color = ( color == Color.RED ) ? Color.BLACK : Color.RED;
	    }

		public static enum Color { RED, BLACK };
}
    
 
