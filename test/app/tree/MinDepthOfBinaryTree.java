package test.app.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class MinDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		TreeNode leaf1 = new TreeNode(15,null,null,null);
		TreeNode leaf2 = new TreeNode(7,null,null,null);
		
		TreeNode right = new TreeNode(20,leaf1,leaf2,null);
		
		TreeNode left = new TreeNode(9,null,null,null);
		
		TreeNode root = new TreeNode(3,left,right,null);
		
		System.out.println( new MinDepthOfBinaryTree().minDepthUsingBFS(root));
	}
	
	public int minDepth(TreeNode root) {
        
        if( root == null )
            return 0;
        
        if( root.left == null && root.right == null )
            return 1;
        
        if( root.left == null )
            return 1 +  minDepth(root.right) ;
        
        if( root.right == null )
            return 1 +  minDepth(root.left) ;
        
        return 1 + Math.min( minDepth(root.left) , minDepth(root.right) );
        
    }
	
	public int minDepthUsingBFS(TreeNode root) {
        
        if( root == null )
            return 0;
        
       int level = 0;
       Deque<TreeNode> queue = new ArrayDeque<>();
       queue.add(root);
       
       while ( !queue.isEmpty() ) {
    	   int size = queue.size();
    	   
    	   while( size-- > 0 ) {
    		   TreeNode temp = queue.remove();
    		   
    		   if( Objects.isNull(temp.left) && Objects.isNull(temp.right) )
    			   return level + 1;
    		   
    		   if( Objects.nonNull(temp.left))
    			   queue.add( temp.left );
    		   
    		   if( Objects.nonNull(temp.right))
    			   queue.add( temp.right );
    	   }
    	   
    	   level++;
       }
       
       return level;
        
    }

}
