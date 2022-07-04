package test.app.tree;

import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Objects;

public class BinaryTreeRightSideView {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	 public List<Integer> rightSideView(TreeNode root) {
	       
		   /*
		    * Using BFS or Level first traversal mechanism to traverse.
		    * For each level or Breadth we will move from right to left
		    */
	       List<Integer> res = new ArrayList<>();
	        
	        if( root == null )
	            return res;
	        
	        Deque<TreeNode> q = new ArrayDeque<>();
	        q.add(root);
	            
	        while ( !q.isEmpty() ) {
	            int size = q.size();
	            
	            res.add(q.peek().val);
	            
	            while( size-- > 0 ) {
	                root = q.remove();
	                
	                if( Objects.nonNull(root.right) )
	                    q.add( root.right );
	                
	                if( Objects.nonNull(root.left) )
	                    q.add( root.left );
	                
	            }
	        }
	        
	        return res;
	    }
	

}
