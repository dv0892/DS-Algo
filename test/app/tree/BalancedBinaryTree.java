package test.app.tree;

public class BalancedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public boolean isBalanced(TreeNode root) {
        
        height(root);
        
        return balanced;
        
        
    }
    
    boolean balanced = true;
    
    public int height( TreeNode node ) {
        
        if( node == null)
            return 0;
        
        int left   = height( node.left );
        int right  = height( node.right );
        
        if ( balanced )
            balanced = Math.abs( left - right  ) > 1 ? false : true ;
        
        return 1 + Math.max( left , right );
    }

}
