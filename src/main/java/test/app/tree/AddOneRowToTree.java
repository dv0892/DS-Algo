package test.app.tree;

import java.util.Deque;
import java.util.LinkedList;

public class AddOneRowToTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//GOOD QUESTION
	}
	
	public TreeNode addOneRow(TreeNode root, int val, int depth) {
	       if( depth == 1 )
	            return new TreeNode(val,root,null);
	       
	        return addOneRowDFS(root,val,depth-1,1);
	    }
	    
	    public TreeNode addOneRowDFS(TreeNode node, int val, int depth , int d) {
		       if( d == depth && node != null ) {
		    	   node.left  = new TreeNode(val,node.left,null);
		    	   node.right = new TreeNode(val,null,node.right);
		       }  else if ( node != null){
		    	   addOneRowDFS(node.left, val, depth, d+1);;
		    	   addOneRowDFS(node.right, val, depth, d+1);;
		       }
		       
		       return node;
	   }
	
	
	 public TreeNode addOneRowBFS(TreeNode root, int val, int depth) {
	       if( depth == 1 )
	            return new TreeNode(val,root,null);
	        
	        Deque<TreeNode> q = new LinkedList<>();
	        q.add(root);
	        
	        int d = 1;
	        while( d < (depth-1) ) {
	            int sz = q.size();
	            while( sz-- >  0 ){
	                TreeNode node = q.remove();
	                if( node.left != null )
	                    q.add(node.left);
	                
	                if( node.right != null )
	                    q.add(node.right);
	            }
	            d++;
	                
	        }
	        
	        while( !q.isEmpty() ){
	            TreeNode node = q.remove();
	            
	            node.left  = new TreeNode(val,node.left,null);
	            node.right = new TreeNode(val,null,node.right);
	            
	        }
	        
	        return root;
	    }

}
