package test.app.backtracking;

import java.util.ArrayList;
import java.util.List;

import test.app.tree.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeNode leaf1 = new TreeNode(15,null,null,null);
		TreeNode leaf2 = new TreeNode(7,null,null,null);
		
		TreeNode right = new TreeNode(3,leaf1,leaf2,null);
		
		TreeNode left = new TreeNode(2,null,null,null);
		
		TreeNode root = new TreeNode(1,left,right,null);
		
		 System.out.println( new BinaryTreePaths().binaryTreePathsCleaned( new StringBuilder(""),root ) );
	}
	
	public List<String> binaryTreePaths(String path, TreeNode root) {
	    // Can I do this using StringBuilder ?
		
	    if( root.left == null && root.right == null ) {
	        List<String> ans  = new ArrayList<>();
	        ans.add(path + root.val);
	        
	        return ans;
	    }
	    
	    List<String> ans  = new ArrayList<>();
	    
	    path += root.val + "->";
	    
	    if( root.left != null ){
	       ans.addAll ( binaryTreePaths( path  , root.left ) );
	    }
	    
	    if( root.right != null ){
	       ans.addAll ( binaryTreePaths( path  , root.right ) );
	    }
	    
	    return ans; 
	}
	
	public List<String> binaryTreePathsCleaned(StringBuilder path, TreeNode root) {
	    
	    if( root.left == null && root.right == null ) {
	        path.append(root.val);
	        
	        List<String> ans  = new ArrayList<>();
	        ans.add( new String(path.toString()) );
	        
	        path.delete( path.lastIndexOf("->") + 2, path.length() );
	        
	        return ans;
	    }

	    List<String> ans  = new ArrayList<>();

	    path.append(root.val).append("->");;
	    
	    if( root.left != null ){
	       ans.addAll ( binaryTreePathsCleaned( path , root.left ) );
	    }
	    
	    if( root.right != null ){
	       ans.addAll ( binaryTreePathsCleaned( path , root.right ) );
	    }
	    
	    path.delete( path.lastIndexOf(""+root.val), path.length() );

	    return ans;
 }

}
