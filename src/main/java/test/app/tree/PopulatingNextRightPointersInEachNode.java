package test.app.tree;

import java.util.ArrayList;
import java.util.List;

import test.app.tree.bst.Node;

public class PopulatingNextRightPointersInEachNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	// Definition for a Node.
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}
	    
	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, Node _left, Node _right, Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	*/


	    public Node connect(Node root) {
	        connectNext(root,0);
	        return root;
	    }
	    
	    List<Node> rightNodes = new ArrayList<>();
	    public Node connectNext(Node node , int d ) {
	        if( node == null )
	            return node;

	        if( d < rightNodes.size() ){
	           // node.next = rightNodes.get(d);
	            rightNodes.set(d,node);
	        } else {
	            rightNodes.add(node);            
	        }

	        connectNext(node.getLeftChild(),d+1);
	        connectNext(node.getRightChild(),d+1);

	        return node;
	    }
	

}
