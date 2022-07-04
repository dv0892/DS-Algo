package test.app.tree;

public class ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		short t  = (short) (Short.MAX_VALUE + Short.MAX_VALUE);
		System.out.println( Short.MAX_VALUE + Short.MAX_VALUE) ;
		System.out.println( Integer.MAX_VALUE < Long.MAX_VALUE);
	}
	
	public boolean isValidBST(TreeNode root) {
			return isValidBST1 ( root , Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
     public boolean isValidBST1(TreeNode root , long l , long h ) {
        
        if( root == null )
            return true ;
        
         if( root.val <= l || root.val >= h )
             return false;
         
         
        
        return isValidBST1( root.left , l                    , Math.min(h,root.val) ) && 
               isValidBST1( root.right, Math.max(l, root.val), h);
    }

}
