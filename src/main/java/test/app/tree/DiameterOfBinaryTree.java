package test.app.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class DiameterOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}


	private int diameter;
	
	public int diameterOfBinaryTreeOptimized(TreeNode root) {
        /*
         * Here we are using height to calculate the diameter in a bottom up manner 
         * A node having two leaf children will have a diameter of 2
         * So we we take answer upwards and build the max answer in bottom up manner.
         * 
         */
        if( root ==  null )
        	return 0;
        
        int left   = diameterOfBinaryTreeOptimized(root.left);
        int right  = diameterOfBinaryTreeOptimized(root.right);
        
        diameter = Math.max(diameter, left + right);
        
        return 1 +  Math.max(left, right);
        
    }
	
	public int diameterOfBinaryTree(TreeNode root) {
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        
        int diameter = Integer.MIN_VALUE;
        while ( !queue.isEmpty() ){
            int size = queue.size();
            while ( size-- > 0 ) {
                TreeNode node = queue.remove();
                
                int leftDepth  = maxDepth(node.left);
                int rightDepth = maxDepth(node.right);
                
                diameter = Math.max( diameter, leftDepth + rightDepth  );
                
                 if( Objects.nonNull(node.left) )
                     queue.add(node.left);
                
                if( Objects.nonNull(node.right) )
                     queue.add(node.right);
                
            }
        }
        
        return diameter;
        
    }
    
    
    public int maxDepth(TreeNode root) {
        
		// this approach is using DFS to find the max depth
		
        if( root == null )
            return 0;
        
        return 1 + Math.max( maxDepth(root.left) , maxDepth(root.right) );
    }

}
