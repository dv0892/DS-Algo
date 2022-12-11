package test.app.dp;

import test.app.tree.TreeNode;

public class MaxPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxPathSum(TreeNode root) {
		maxPath(root);
        return max;
    }
	
	int max = Integer.MIN_VALUE;
	
	// This will work if all values are positive
	public int maxPath(TreeNode root) {
        if(  root == null )
        	return 0;
        
        int leftPathSum = maxPath(root.left);
        int rightPathSum = maxPath(root.right);
        
        max = Math.max( max ,  root.val + leftPathSum + rightPathSum );
        
        return root.val + Math.max( leftPathSum , rightPathSum );
    }
	

	public int maxPathWithNegValues(TreeNode root) {
        if(  root == null )
        	return 0;
        
        int leftPathSum = maxPathWithNegValues(root.left);
        int rightPathSum = maxPathWithNegValues(root.right);
        
        max = Math.max( max ,  Math.max( root.val , root.val + leftPathSum + rightPathSum ) );       
        max = Math.max( max ,  Math.max( root.val + rightPathSum, root.val + leftPathSum  ) );

        return Math.max(root.val, Math.max(root.val + leftPathSum , root.val + rightPathSum) ) ;
    }

}
