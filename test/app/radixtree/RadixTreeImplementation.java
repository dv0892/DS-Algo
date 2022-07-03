package test.app.radixtree;

import java.util.ArrayList;
import java.util.List;

public class RadixTreeImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RadixTree tree = new RadixTree();
		tree.insert("romane");
        tree.insert("romanus");
        tree.insert("romulus");
        tree.insert("rubens");
        tree.insert("ruber");
        tree.insert("rubicon");
        tree.insert("rubicundus");
		
        tree.preorder();
	}

}


class RadixTree {
	
	RadixTreeNode  root;
	
	public RadixTree() {
		root = new RadixTreeNode();
	}
	
	public void insert( String label ) {
		insert(label,root);
	}
	
	public void preorder() {
		preorder(root);
	}

	public void insert( String word , RadixTreeNode node ) {
		int matches = checkingMatchingCharacters(word,node);
		
		// Case 1 : When there are no matches, we will explore the children
		// Case 2 : If the Node's label  is a prefix of "word". we will explore the children
		if ( matches == 0 || root == node || 
		   ( matches < word.length() && matches >= node.label.length() )) 
		{
			
			boolean notInserted = true;
			word = word.substring(matches);
			for ( int i=0; i < node.childrens.size(); i++) {
				
				// If this condition matches, it is surely going be added as in the below as child.
				// as first character has matched with a ith children.
				if ( word.charAt(0) == node.childrens.get(i).label.charAt(0) ) {
					notInserted = false;
					insert(word,node.childrens.get(i));
				}
					
			}
			
			if ( notInserted )
				node.childrens.add( new RadixTreeNode(word));
		}
		// Case 3 : When the word and node's labels share a prefix
		else if ( matches < word.length() ) {
			String actualString = node.label;
			node.label = actualString.substring(0,matches);
			
			// Create two new childrens both sharing the same prefix e.g
			// rome is inserted after romane. e and ane will be two new childrens.
			// All the existing childrens of romane should become children of ane node
			
			RadixTreeNode newNode = new RadixTreeNode( actualString.substring(matches) );
			for ( RadixTreeNode n : node.childrens ) {
				newNode.childrens.add( n );
			}
			
			node.childrens.clear();
			
			node.childrens.add( newNode );
			
			node.childrens.add( new RadixTreeNode( word.substring(matches)));
		} /*else if ( false ) {
			
		}*/
	}

	private int checkingMatchingCharacters(String label, RadixTreeNode node) {
		
		int matches = 0;
		int min = Math.min(label.length(), node.label.length());
		
		for(int i=0;i<min;i++) {
			if ( label.charAt(i) != node.label.charAt(i))
				return matches;
			matches++;
		}
		
		return matches;
	}
	
	
	public void preorder ( RadixTreeNode node ) {
		if( node == null)
			return ;
		
		System.out.println( node.label );
		for ( RadixTreeNode n : node.childrens ) {
			preorder(n);
		}
	}
}


class RadixTreeNode {
	String label ;
	List<RadixTreeNode> childrens;
	
	public RadixTreeNode(String label) {
		this.label = label;
		childrens = new ArrayList<>();
	}
	
	public RadixTreeNode() {
		this("");
	}
}
