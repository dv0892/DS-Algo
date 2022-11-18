package test.app.graph;

import test.app.tree.TreeNode;

public class LowestCommonAncestorOfABinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	        if( root==null || root.val==p.val || root.val==q.val )
	            return root;

	        TreeNode anc1 = lowestCommonAncestor(root.left,p,q) ;
	        TreeNode anc2 = lowestCommonAncestor(root.right,p,q) ;

	        if( anc1==null && anc2==null )
	            return null;
	        else if( anc1==null )
	            return anc2;
	        else if( anc2==null )
	            return anc1;
	        else 
	            return root;
	    }

}
