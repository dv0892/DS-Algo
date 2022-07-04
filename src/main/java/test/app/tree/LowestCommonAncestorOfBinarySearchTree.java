package test.app.tree;

import java.util.Objects;

public class LowestCommonAncestorOfBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca(root,p,q);
            
        return ancestor;
    }
    
    TreeNode ancestor ;
    
    public boolean lca( TreeNode root, TreeNode p, TreeNode q ){
    	
    	/*
    	 * Here we not actually using properties of BST
    	 */
    	
        if( root == null )
            return false;
        
        if( Objects.nonNull(ancestor))
            return false;
        
        boolean leftSeen  = lca(root.left,p,q);
        boolean rightSeen = lca(root.right,p,q);
        boolean isCurr    = root.val == p.val || root.val == q.val;
        
        if( (leftSeen && rightSeen) || ( ( leftSeen || rightSeen) && ( isCurr )) )
        {
            if( Objects.isNull(ancestor))
                ancestor = root;
        }
        
        if( leftSeen || rightSeen || isCurr )
            return true;
        
        return false;
    }
    
    
    public TreeNode lcaOnBST( TreeNode root, TreeNode p, TreeNode q ){
    	
    	/*
    	 * Here we not actually using properties of BST
    	 * 
    	 * For a node, we will check 
    	 * 
    	 * if both p and q are less than curr node
    	 * then we will move to left subtree 
    	 * 
    	 * if both p and q are more than curr node
    	 * then we will move to right subtree
    	 * 
    	 * Else this means curr node is equal to p or q. Since a node ia also descendant of itself
    	 * So we have found the ancestor
    	 * 
    	 */
    	
    	
    	while ( root != null ) {
    		if( p.val < root.val && q.val < root.val )
    			root = root.left;
    		else if( p.val > root.val && q.val > root.val )
    			root = root.right;
    		else 
    			return root;
    	}
       
    	return null;
    }
    

}
