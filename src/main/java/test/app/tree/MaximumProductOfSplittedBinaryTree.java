package test.app.tree;

public class MaximumProductOfSplittedBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    public int maxProduct(TreeNode root) {
        maxProduct( root , sum(root) );
        return (int)(max%MOD);
    }

    long MOD  = (int)(1e9+7);
    long max = Long.MIN_VALUE;

    public int maxProduct(TreeNode root, int sum) {
        if( root == null ) 
            return 0;

        int leftSum  = maxProduct( root.left ,sum );
        int rightSum = maxProduct( root.right , sum );
      
        long p1 = ((long)leftSum*(long)(sum - leftSum));
        long p2 = ((long)rightSum*(long)(sum - rightSum));
        
        max = ( Math.max( max,  ( Math.max(p1,p2)) ) ) ;

        return root.val + leftSum + rightSum;
    }

    public int sum(TreeNode root) {
        if( root == null ) 
            return 0;

        return root.val + sum(root.left) + sum(root.right);
    }


	

}
