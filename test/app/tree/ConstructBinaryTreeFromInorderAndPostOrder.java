package test.app.tree;

public class ConstructBinaryTreeFromInorderAndPostOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] postOrder = {9,3,15,20,7};
		int[] inOrder =   {9,15,7,20,3};
		
		System.out.println( new ConstructBinaryTreeFromInorderAndPostOrder().buildTree(postOrder, inOrder ));
	}
	
	public TreeNode buildTree(int[] postorder, int[] inorder) {
		return buildTree(postorder, inorder, postorder.length-1, 0, inorder.length);
    }
	
	
	public TreeNode buildTree(int[] postOrder, int[] inorder, int pi , int il , int ie) {
        if( il >= ie )
            return null;
        
        if( pi < 0 || pi == postOrder.length)
        	System.out.println( " Hi ");
        
        int index = search(inorder, postOrder[pi], il, ie );
        int sizeOfRightSubTree = ie - index - 1 ;
            
        return new TreeNode( postOrder[pi],
                             buildTree(postOrder,inorder,pi-sizeOfRightSubTree, il, index ) ,
                             buildTree(postOrder,inorder,pi-1,index+1,ie )
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
