package test.app.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int maxDepth(TreeNode root) {
        
		// this approach is using DFS to find the max depth
		
        if( root == null )
            return 0;
        
        return 1 + Math.max( maxDepth(root.left) , maxDepth(root.right) );
    }
	
	
	public int maxDepthUsingBFS(TreeNode root) {
        
		// this approach is using BFS to find the max depth
		
        if( root == null )
            return 0;
        
        int level  = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while ( !q.isEmpty() ) {
        	
        	int nodes = q.size();
        	
        	while ( nodes-- > 0) {
        		TreeNode t = q.remove();
        		
        		if( Objects.nonNull(t.left) )
        			q.add(t.left);
        		
        		if( Objects.nonNull(t.right) )
        			q.add(t.right);
        	}
        	
        	level++;
        	
        }
        
        return level;
    }

}
