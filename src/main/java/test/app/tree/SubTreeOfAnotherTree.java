package test.app.tree;

public class SubTreeOfAnotherTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    
	public boolean isSubTreeDFS(TreeNode root, TreeNode subRoot) {
        
        if( root == null )
            return false;
        
        if( root.val == subRoot.val ) {
            if( isSameTree( root , subRoot ) )
                return true;
        }
        
        return isSubTreeDFS( root.left , subRoot ) ? true : isSubTreeDFS( root.right , subRoot );
        
    }
	
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if( root == null )
            return false;
        
        if( root.val == subRoot.val ) {
            if( isSameTree( root , subRoot ) )
                return true;
        }
        
        return isSubtree( root.left , subRoot ) ? true : isSubtree( root.right , subRoot );
        
    }
    
    public boolean isSameTree ( TreeNode p, TreeNode q ){
        
        if( p == null && q == null )
			return true;
		
		if( p == null || q == null )
			return false;
		
		if( p.val != q.val)
			return false;
		
		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        
    }

}
