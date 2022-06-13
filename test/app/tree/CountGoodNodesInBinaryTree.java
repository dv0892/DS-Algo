package test.app.tree;

public class CountGoodNodesInBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int goodNodes(TreeNode root) {
        return goodNodes( root , Integer.MIN_VALUE ); 
    }
    
    
    public int goodNodes(TreeNode root, int max ) {
        
        if( root == null )
            return 0;
        
        max = Math.max(max,root.val);
        
        if( root.val >= max )
            return 1 + goodNodes( root.left , max ) + goodNodes( root.right , max );
        else
            return goodNodes( root.left , max ) + goodNodes( root.right , max );
        
    }

}
