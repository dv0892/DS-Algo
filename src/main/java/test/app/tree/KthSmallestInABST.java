package test.app.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class KthSmallestInABST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int kthSmallest(TreeNode root, int k) {
       /* kth(root,0,k);
        return kth;*/
        
		 Deque<TreeNode> stack = new ArrayDeque<>();
	        TreeNode curr = root;
	        int count = 0;
	        
	        while( curr!=null || !stack.isEmpty() ) {
	        	while( curr != null ) {
	        		stack.push(curr);
	        		curr = curr.left;
	        	}
	        	
	        	curr = stack.pop();
	            count++;
	        	if( count == k ) {
	                break;
	            }
	        	
	        	curr = curr.right;
	        }
	        
	        return curr.val;
        
    }
    
    int kth ;
    
    public int kth(TreeNode root, int count, int k ) {
        
        if( root == null )
            return count;
        
        count = kth( root.left, count,k );
        
        if( ++count == k ) {
            kth = root.val;
        }
        
        return kth( root.right , count,k);
        
    }

}
