package test.app.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class SymmetricTree {

	public static void main(String[] args) {
		
		TreeNode node1 = new TreeNode(8);
		TreeNode node2 = new TreeNode(9);
		TreeNode node3 = new TreeNode(8);
		TreeNode node4 = new TreeNode(9);
		TreeNode node11 = new TreeNode(6);
		TreeNode node12 = new TreeNode(6);
		
		TreeNode node5 = new TreeNode(5,node1,node2);
		TreeNode node6 = new TreeNode(5,node4,node3);
		
		TreeNode node7 = new TreeNode(4,node11,null);
		TreeNode node8 = new TreeNode(4,null,node12);
		
		
		
		TreeNode node9 = new TreeNode(3,node7,node5);
		TreeNode node10 = new TreeNode(3,node6,node8);
				
		
		TreeNode root = new TreeNode(1,node9,node10);
		
		System.out.println( new SymmetricTree().isSymmetricBFS(root));

	}
	
	public boolean isSymmetric(TreeNode root) {
        return isSymmetricBFS(root);
    }
	
	public boolean isSymmetricBFS(TreeNode root) {
        
		Deque<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while( !q.isEmpty() ) {
			int n = q.size(),size = q.size();
			Deque<TreeNode> stack = new LinkedList<>();
			Deque<TreeNode> nextLevel = new LinkedList<>();
			boolean stackFull = false;
			while( size-- > 0) {
				TreeNode curr = q.remove();
				TreeNode left = curr.left , right = curr.right ;
				
				if( !stackFull && stack.size() < n ) {
					stack.push(left);
 				} else {
 					stackFull = true;
 					if( !compare(nextLevel, stack, left) )
 						return false;
 				}
				
				if( !stackFull && stack.size() < n ) {
					stack.push(right);
 				} else {
 					stackFull = true;
 					if( !compare(nextLevel, stack, right) )
 						return false;
 				}
			}
			
			q.addAll(nextLevel);
		}
		
		return true;
    }

	private boolean compare(Deque<TreeNode> q, Deque<TreeNode> stack, TreeNode node ) {
		TreeNode image = stack.pop();
		if( isEqualBFS(node, image) ) {
			if(node != null) {
				q.addFirst(image);
				q.addLast(node);
			}
		} else {
			return false;
		}
		
		return true;
	}

    public boolean isSymmetricDFS(TreeNode left , TreeNode right ) {
        if( left == null && right == null )
            return true ;
        
        return isEqualDFS(left,right) && isSymmetricDFS(left.right,right.left) && isSymmetricDFS(left.left,right.right) ;
    }

    public boolean isEqualDFS( TreeNode left , TreeNode right ){
        if( left == null || right == null )
            return false;
        
        return left.val == right.val ;
    } 
    
    public boolean isEqualBFS( TreeNode left , TreeNode right ){
    	
    	if( left == null && right == null )
            return true;
    	
        if( left == null || right == null )
            return false;
        
        return left.val == right.val ;
    } 

}
