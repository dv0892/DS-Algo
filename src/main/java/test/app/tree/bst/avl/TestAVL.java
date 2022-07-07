package test.app.tree.bst.avl;

import test.app.tree.Tree;
import test.app.tree.bst.BinarySearchTree;

public class TestAVL {

	public TestAVL() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Tree<Integer>  bst = new BinarySearchTree<>();
		//bst.insert(20).insert(30).insert(25);
		bst.traverse();
		
		Tree<Integer> avlTree = new AVLTreeImpl<>();
        avlTree.insert(10).insert(2).insert(6).insert(8).insert(25).insert(18).insert(35).insert(15).insert(22).insert(42)
                .insert(30).insert(40).insert(12).insert(17).insert(19).insert(24).insert(28).insert(33).insert(38);

        avlTree.traverse();

        System.out.println("Max is: " + avlTree.getMax());
        System.out.println("Min is: " + avlTree.getMin());

        System.out.println("Deleting 42 from Tree");
        avlTree.delete(42);

        System.out.println("New Max is: " + avlTree.getMax());

        avlTree.traverse();
	}

}
