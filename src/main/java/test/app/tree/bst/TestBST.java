package test.app.tree.bst;

import test.app.tree.*;

public class TestBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree<Integer>  bst = new BinarySearchTree<>();
		bst.insert(2).insert(3).insert(7);
		
		bst.traverse();
	}

}
