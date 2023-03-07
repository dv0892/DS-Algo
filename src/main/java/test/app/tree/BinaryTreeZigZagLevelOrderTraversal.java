package test.app.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(7);

		TreeNode n3 = new TreeNode(20,n1,n2);
		TreeNode n4 = new TreeNode(9);
		
		TreeNode n5 = new TreeNode(3,n4,n3);
		
		System.out.println( new BinaryTreeZigZagLevelOrderTraversal().zigzagLevelOrder(n5));
		
		
	}
	
	    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
	            List<List<Integer>> res = new ArrayList<>();
	            if( root == null )  
	                return res;

		        Deque<TreeNode> levelNodes = new LinkedList<>();
		        levelNodes.add(root);

		        boolean left = true;
		        while( !levelNodes.isEmpty() ){
		            int size = levelNodes.size();
		            Deque<TreeNode> q = new LinkedList<TreeNode>(levelNodes);
		            List<Integer> level = new ArrayList<>();

		            levelNodes.clear();
		            while( size-- > 0 ) {
		                TreeNode curr = q.removeLast();
	                    level.add(curr.val); ;
		                if( left ){
		                    if( Objects.nonNull(curr.left) )
		                    levelNodes.add( curr.left );
		                
		                    if( Objects.nonNull(curr.right) )
		                    levelNodes.add( curr.right );

		                } else {
		                    if( Objects.nonNull(curr.right) ){
		                        levelNodes.add( curr.right );
		                    }
		                
		                    if( Objects.nonNull(curr.left) ){
		                        levelNodes.add( curr.left );
		                    }
		                }               
		            }
		            left = !left;
		            res.add(level);
		        }

		        return res;
	    }
	

}
