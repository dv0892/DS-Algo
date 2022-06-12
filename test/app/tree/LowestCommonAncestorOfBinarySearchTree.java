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
        if( root == null )
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

}
