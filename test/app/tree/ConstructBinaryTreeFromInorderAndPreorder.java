package test.app.tree;

public class ConstructBinaryTreeFromInorderAndPreorder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int[] pre = {3,9,20,15,7};
		int[] in	= {9,3,15,20,7};
		
		System.out.println( new ConstructBinaryTreeFromInorderAndPreorder().buildTree(pre, in));
		
	}
	
	public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        return buildTree(preorder,inorder,0,0,inorder.length);
    }
    
	 public TreeNode buildTree(int[] preorder, int[] inorder, int pi , int il , int ie) {
	        if( il >= ie )
	            return null;
	        
	        int index = search(inorder, preorder[pi], il, ie );
	        int sizeOfLeftTree = index - il + 1;
	            
	        return new TreeNode( preorder[pi],
	                             buildTree(preorder,inorder,pi+1, il, index ) ,
	                             buildTree(preorder,inorder,pi+sizeOfLeftTree,index+1,ie )
	                           );    
	        
	    }
	    
	    public int search( int[] inorder, int t , int il , int ie) {
	        if( il < 0 || ie > inorder.length)
	            return -1;
	        
	        while ( il < ie ){
	            if( inorder[il++] == t )
	                return il-1;
	        }
	        
	        return -1;
	    }

}
