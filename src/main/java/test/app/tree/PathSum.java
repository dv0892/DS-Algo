package test.app.tree;

import java.util.Deque;
import java.util.LinkedList;

public class PathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public boolean hasPathSum(TreeNode root, int targetSum) {
		if ( root == null )
            return false;
        
        Deque<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while( !q.isEmpty() ){
            int sz = q.size();
            while( sz-- > 0){
                TreeNode n = q.remove();
                
                // check if it is a leaf
                if( n.left==null && n.right==null && n.val == targetSum )
                    return true;
                
                if( n.left != null ) {
                    n.left.val += n.val;
                    q.add(n.left);
                }
                
                if( n.right != null ) {
                    n.right.val += n.val;
                    q.add(n.right);
                }
            }
        }
        
        return false;
	}
	
	
	public boolean hasPathSumdfs(TreeNode root, int sum ,int targetSum) {
        
		if( root == null )
			return false;
		
		
		if( root.left == null && root.right == null && (root.val+sum) == targetSum)
			return true;
		
		return hasPathSumdfs(root.left,sum+root.val ,targetSum) || hasPathSumdfs(root.right,sum+root.val ,targetSum);
	}
}
