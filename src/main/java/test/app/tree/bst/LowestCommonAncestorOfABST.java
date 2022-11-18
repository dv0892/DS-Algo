package test.app.tree.bst;

import test.app.tree.TreeNode;

public class LowestCommonAncestorOfABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        	
			// if the curr root is null or equal any of the given to two nodes, we have found a ancestor
			if( root == null || root.val == p.val || root.val==q.val )
				return root;
			
			// Now using the properties of BST, we can decide whether we will find the ancestor in 
			// left subtree or right subtree/
			// Case 1 : If root is smaller than min of p,q, we will find ancestor in right subtree.
			// Case 2 : If root is greater than max of p,q, we will find ancestor in left subtree.
			// case 3 : root lies between p and q , and it is the ancestor
			
			if( Math.min(p.val, q.val) > root.val ) {
				return lowestCommonAncestor(root.right, p, q);
			} else if( Math.max(p.val, q.val) < root.val ) {
				return lowestCommonAncestor(root.left, p, q);
			} else {
			    return root;
			}
	}

}
